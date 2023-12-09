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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.anassert.R;


public class StudyPlan extends AppCompatActivity {
    String mh[]= {"Trí tuệ nhân tạo","Phát triển ứng dụng trên thiết bị di động",
            "Kiểm thử phần mềm","Thiết kế đồ họa 2D","Phát triển dự án công nghệ thông tin",
            "Lập trình Java nâng cao","Phát triển ứng dụng Game","Kinh tế chính trị","Mỹ thuật đại cương",
            "Quản trị mạng trên hệ điều hành Windows"};
    ListView lv;
    ArrayAdapter<String> lvAdapter;
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
        lvAdapter = new ArrayAdapter<>(StudyPlan.this, android.R.layout.simple_list_item_1,mh);
        lv.setAdapter(lvAdapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder Option = new AlertDialog.Builder(StudyPlan.this);
                Option.setTitle("Có muốn xóa môn học?");
                Option.setMessage(mh[position].toString());
                Option.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
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
    }
}
