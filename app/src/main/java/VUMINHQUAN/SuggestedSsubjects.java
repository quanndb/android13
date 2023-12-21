package VUMINHQUAN;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anassert.HOCPHAN.HocPhanDAO;
import com.example.anassert.HOCPHAN.HocPhanObject;
import com.example.anassert.R;

import java.util.ArrayList;

import BUITIENDUNG.MyAdapterResult;
import BUITIENDUNG.Result;
import PHAHUUHIEU.ReportingAdvisor;

public class SuggestedSsubjects extends AppCompatActivity {
    private final String hk[]= {"1","2","3","4","5","6","7","8"};
    private final String TARGET[] = {"AI & BIGDATA","GAME", "WEB JAVA","WEB PHP","WEB .NET","MOBILE","IOT"};
    public ArrayList<HocPhanObject> mh1,mh2,mh3,mh4,mh5,mh6,mh7,mh8;
    ArrayAdapter<String> spAdapter;
    ArrayAdapter<String> lvAdapter;
    ArrayAdapter<String> targetAdapter;
    Spinner sp;
    Button btnTarget,btnUse;
    TextView txtTarget;
    ListView lv;
    HocPhanDAO hocPhanDAO;
    ArrayList<HocPhanObject> listHP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestedsubjects);
        getWidget();
        define();
        app();
    }

    private void define() {
        mh1 = new ArrayList<>();
        mh2 = new ArrayList<>();
        mh3 = new ArrayList<>();
        mh4 = new ArrayList<>();
        mh5 = new ArrayList<>();
        mh6 = new ArrayList<>();
        mh7 = new ArrayList<>();
        mh8 = new ArrayList<>();

        hocPhanDAO = new HocPhanDAO(this);

        spAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,hk);
        targetAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,TARGET);
    }

    private void app() {
        //Data
        listHP = hocPhanDAO.getHP();
        //
        sp.setAdapter(spAdapter);
        //Set các kỳ học
        changeMH(3);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeLV(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh1);
                lv.setAdapter(lvAdapter);
            }
        });

        btnUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SuggestedSsubjects.this, "Cập nhật kế hoạch thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tạo một Builder để xây dựng AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(SuggestedSsubjects.this);
                builder.setTitle("Nhập mục tiêu nghề nghiệp");

                // Inflate layout tùy chỉnh cho AlertDialog
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.customlayout, null);
                builder.setView(dialogView);

                // Lấy tham chiếu đến Spinner trong layout tùy chỉnh
                Spinner spTarget = dialogView.findViewById(R.id.spEvaluate);
                spTarget.setAdapter(targetAdapter);

                // Thiết lập nút "OK"
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Xử lý dữ liệu được nhập ở đây
                        String userInput = spTarget.getSelectedItem().toString();
                        txtTarget.setText(userInput);
                        changeMH(spTarget.getSelectedItemPosition()+1);

                        // Thực hiện các thao tác khác với dữ liệu nhập
                        Toast.makeText(SuggestedSsubjects.this, "Cập nhật thông tin thành công "+userInput, Toast.LENGTH_SHORT).show();
                    }
                });
                // Thiết lập nút "Cancel"
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                // Tạo và hiển thị AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void changeMH(int input){
        // Duyệt qua ArrayList bằng vòng lặp for-each
        mh1.clear();
        mh2.clear();
        mh3.clear();
        mh4.clear();
        mh5.clear();
        mh6.clear();
        mh7.clear();
        mh8.clear();
        for (HocPhanObject item : listHP) {
            if(item.getHocKy() == 1){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                     mh1.add(item);
            }
            if(item.getHocKy() == 2){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                    mh2.add(item);
            }
            if(item.getHocKy() == 3){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                    mh3.add(item);
            }
            if(item.getHocKy() == 4){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                    mh4.add(item);
            }
            if(item.getHocKy() == 5){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                    mh5.add(item);
            }
            if(item.getHocKy() == 6){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                    mh6.add(item);
            }
            if(item.getHocKy() == 7){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                    mh7.add(item);
            }
            if(item.getHocKy() == 8){
                String tieuChi = item.getTieuChi();
                if(tieuChi.charAt(0) == '0' || (tieuChi.charAt(0) == '1' && tieuChi.charAt(input) == '1'))
                    mh8.add(item);
            }
        }
        changeLV(sp.getSelectedItemPosition());
    }

    private void changeLV(int position){
        if(position==0) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh1);
        if(position==1) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh2);
        if(position==2) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh3);
        if(position==3) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh4);
        if(position==4) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh5);
        if(position==5) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh6);
        if(position==6) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh7);
        if(position==7) lvAdapter = new MyAdapterSGS(SuggestedSsubjects.this,R.layout.customlvsgs,mh8);
        lv.setAdapter(lvAdapter);
    }

    private void getWidget() {
        sp = findViewById(R.id.sp);
        lv = findViewById(R.id.lv);
        btnTarget = findViewById(R.id.btnTarget);
        txtTarget = findViewById(R.id.txtTarget);
        btnUse = findViewById(R.id.btnUse);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btnBack) {
            back();
        }if (id == R.id.btnPlan) {
            plan();
        }
        return super.onOptionsItemSelected(item);
    }
    private void plan() {
        Intent plan = new Intent(this, StudyPlan.class);
        startActivity(plan);
    }
    private void back() {
        finish();
    }
}