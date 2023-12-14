package VUMINHQUAN;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.anassert.R;
import com.example.anassert.TAIKHOAN.TaiKhoanDAO;
import com.example.anassert.TAIKHOAN.TaiKhoanObject;

import java.util.ArrayList;


public class StudyPlan extends AppCompatActivity {
    String hk[]= {"1","2","3","4","5","6","7","8"};
    ArrayList<String> mh;
    ListView lv;
    Spinner sp;
    ArrayAdapter<String> lvAdapter;
    ArrayAdapter<String> spAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyplan);
        getWidget();
        app();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.submenu,menu);
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

    private void back() {
        finish();
    }

    private void app() {
        spAdapter = new ArrayAdapter<>(StudyPlan.this, android.R.layout.simple_spinner_dropdown_item,hk);
        sp.setAdapter(spAdapter);
        mh = new ArrayList<>();
        lvAdapter = new ArrayAdapter<>(StudyPlan.this, android.R.layout.simple_list_item_1,mh);
        lv.setAdapter(lvAdapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder Option = new AlertDialog.Builder(StudyPlan.this);
                Option.setTitle("Có muốn xóa môn học?");
                Option.setMessage(mh.get(position).toString());
                Option.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(StudyPlan.this, "Xóa thành công "+mh.get(position), Toast.LENGTH_SHORT).show();
                        mh.remove(position);
                        dialogInterface.cancel();
                        lvAdapter.notifyDataSetChanged();

                    }
                });
                Option.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                Option.create().show();
                return false;
            }
        });
    }

    private void getWidget() {
        lv = findViewById(R.id.lv);
        sp = findViewById(R.id.sp);
    }
}
