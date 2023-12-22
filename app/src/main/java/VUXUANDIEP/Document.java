package VUXUANDIEP;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.anassert.R;

public class Document extends AppCompatActivity {
    ListView listView,listView1;
    String tn[]= {"Trí tuệ nhân tạo","Phát triển ứng dụng trên thiết bị di động",
            "Kiểm thử phần mềm","Thiết kế đồ họa 2D","Phát triển dự án công nghệ thông tin",
            "Lập trình Java nâng cao","Phát triển ứng dụng Game","Kinh tế chính trị","Mỹ thuật đại cương",
            "Quản trị mạng trên hệ điều hành Windows"};
    String dc[]= {"Tư tưởng Hồ Chí Minh","Triết học", "Pháp luật đại cương","Triết học",
            "Mỹ thuật đại cương", "Thể Chất","Kinh tế chính trị","Tiếng Anh công nghệ thôngtin cơ bản 1"};
    ArrayAdapter<String> lvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Ẩn tiêu đề mặc định của Action Bar
        app();

    }
    private void app() {
        lvAdapter = new ArrayAdapter<>(Document.this, android.R.layout.simple_list_item_1,tn);
        ListView listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(lvAdapter);
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder Option = new AlertDialog.Builder(Document.this);
                Option.setTitle("Có muốn xem tài liệu môn học?");
                Option.setMessage(tn[position].toString());
                Option.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
                Option.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                Option.create().show();
                return false;
            }
        });
        lvAdapter = new ArrayAdapter<>(Document.this, android.R.layout.simple_list_item_1,dc);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(lvAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder Option = new AlertDialog.Builder(Document.this);
                Option.setTitle("Có muốn xem tài liệu môn học?");
                Option.setMessage(tn[position].toString());
                Option.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
                Option.setNegativeButton("Có", new DialogInterface.OnClickListener() {
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

}