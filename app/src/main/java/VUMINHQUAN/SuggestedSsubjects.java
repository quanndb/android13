package VUMINHQUAN;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.anassert.R;

public class SuggestedSsubjects extends AppCompatActivity {
    String hk[]= {"1","2","3","4","5","6","7","8"};
    String mh1[]= {"Trí tuệ nhân tạo","Phát triển ứng dụng trên thiết bị di động","Kiểm thử phần mềm","Thiết kế đồ họa 2D","Phát triển dự án công nghệ thông tin","Lập trình Java nâng cao"};
    String mh2[]= {"Vật lý đại cương","Pháp luật đại cương","Kiến trúc máy tính","Hệ điều hành","Quản trị mạng"};
    String mh3[]= {"Hóa học đại cương","Kinh tế chính trị","Phát triển ứng dụng Game","Thực tập cơ sở ngành","Thực tại ảo"};
    ArrayAdapter<String> spAdapter;
    ArrayAdapter<String> lvAdapter;
    Spinner sp;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestedsubjects);
        getWidget();
        app();
    }

    private void app() {
        spAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,hk);
        sp.setAdapter(spAdapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) lvAdapter = new ArrayAdapter<>(SuggestedSsubjects.this, android.R.layout.simple_list_item_1,mh1);
                if(position==1) lvAdapter = new ArrayAdapter<>(SuggestedSsubjects.this, android.R.layout.simple_list_item_1,mh2);
                if(position==2) lvAdapter = new ArrayAdapter<>(SuggestedSsubjects.this, android.R.layout.simple_list_item_1,mh3);
                lv.setAdapter(lvAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lvAdapter = new ArrayAdapter<>(SuggestedSsubjects.this, android.R.layout.simple_list_item_1,mh1);
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