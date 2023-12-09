package PHAHUUHIEU;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.anassert.R;

public class ReportingAdvisor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportingadvisor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Ẩn tiêu đề mặc định của Action Bar
        // Dữ liệu mẫu
        String[] maSinhVienArray = {"SV001", "SV002", "SV003", "SV004", "SV005", "SV006", "SV007", "SV008"};
        String[] tenSinhVienArray = {"Nguyen Van Anh", "Tran Thi Binh", "Le Van Cuong", "Pham Thi Duong", "Phan Đinh Hiep", "Dang Ba Nam", "Vu Thuy Nga", "Vu Dinh Nghia"};

        // Tạo danh sách cặp Mã và Tên sinh viên
        String[] combinedArray = new String[maSinhVienArray.length];
        for (int i = 0; i < maSinhVienArray.length; i++) {
            combinedArray[i] = maSinhVienArray[i] + " - " + tenSinhVienArray[i];
        }

        // Tạo ArrayAdapter để hiển thị danh sách trên ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combinedArray);
        // Liên kết ArrayAdapter với ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Tạo một Builder để xây dựng AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ReportingAdvisor.this);
                builder.setTitle("Nhập dữ liệu");

                // Inflate layout tùy chỉnh cho AlertDialog
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.customlayout, null);
                builder.setView(dialogView);

                // Lấy tham chiếu đến EditText trong layout tùy chỉnh
                EditText inputEditText = dialogView.findViewById(R.id.editText);

                // Thiết lập nút "OK"
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Xử lý dữ liệu được nhập ở đây
                        String userInput = inputEditText.getText().toString();
                        // Thực hiện các thao tác khác với dữ liệu nhập
                        Toast.makeText(ReportingAdvisor.this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                    }
                });
                // Thiết lập nút "Cancel"
                builder.setNegativeButton("Cảnh báo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                // Tạo và hiển thị AlertDialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }

}
