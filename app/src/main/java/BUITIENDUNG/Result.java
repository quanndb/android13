package BUITIENDUNG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.anassert.R;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    String hk[]= {"1","2","3","4","5","6","7","8"};

    ArrayAdapter<String> spAdapter;
    ArrayList<MyResult> hk1,hk2,hk3;
    MyAdapterResult lvAdapter;
    Spinner sp;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWidget();
        data();
        app();
    }
    private void app() {
        spAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,hk);
        sp.setAdapter(spAdapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) lvAdapter = new MyAdapterResult(Result.this,R.layout.customlvresult,hk1);
                if(position==1) lvAdapter = new MyAdapterResult(Result.this,R.layout.customlvresult,hk2);
                if(position==2) lvAdapter = new MyAdapterResult(Result.this,R.layout.customlvresult,hk3);
                lv.setAdapter(lvAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lvAdapter = new MyAdapterResult(Result.this,R.layout.customlvresult,hk1);
                lv.setAdapter(lvAdapter);
            }
        });

    }
    private void getWidget() {
        sp = findViewById(R.id.sp);
        lv = findViewById(R.id.lv);
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
        }
        return super.onOptionsItemSelected(item);
    }

    private void data(){
        hk1 = new ArrayList<>();
        hk2 = new ArrayList<>();
        hk3 = new ArrayList<>();
        hk1.add(new MyResult("Trí tuệ nhân tạo","A"));
        hk1.add(new MyResult("Phát triển ứng dụng trên thiết bị di động","B+"));
        hk1.add(new MyResult("Kiểm thử phần mềm","B"));
        hk1.add(new MyResult("Thiết kế đồ họa 2D","A"));

        hk2.add(new MyResult("Vật lý đại cương","B+"));
        hk2.add(new MyResult("Pháp luật đại cương","A"));
        hk2.add(new MyResult("Kiến trúc máy tính","A"));
        hk2.add(new MyResult("Quản trị mạng","B"));

        hk3.add(new MyResult("Hóa học đại cương","C"));
        hk3.add(new MyResult("Phát triển ứng dụng Game","B"));
        hk3.add(new MyResult("Kinh tế chính trị","B+"));
        hk3.add(new MyResult("Thực tập cơ sở ngành","A"));
    }
    private void back() {
        finish();
    }
}