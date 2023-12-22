package VUXUANDIEP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anassert.R;

public class Timetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Ẩn tiêu đề mặc định của Action Bar

        // Dữ liệu mẫu
        String[] maSinhVienArray = {"T2", "T3"};
        String[] tenSinhVienArray = {"English","The Chat"};

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

    }

}