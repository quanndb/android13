package LEMINHKHOI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anassert.CoVanHocTap.CoVanHocTapDAO;
import com.example.anassert.CoVanHocTap.CoVanHocTapObject;
import com.example.anassert.MainActivity;
import com.example.anassert.R;

import java.util.ArrayList;

import PHAHUUHIEU.ReportingAdvisor;

public class Message extends AppCompatActivity {
    Button btnSearch;
    EditText edtSearch;
    ListView lv;
    CoVanHocTapDAO _service;
    ArrayList<CoVanHocTapObject> listData = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        _service = new CoVanHocTapDAO(this);

        setup();
        eventFuntion();
    }
    private void setup(){
        btnSearch = findViewById(R.id.btn_searchMessage);
        edtSearch = findViewById(R.id.edt_searchMessage);
        lv = findViewById(R.id.lvMessage);
        searchData("");
    }
    private void eventFuntion(){


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent  intentView  = new Intent(Message.this, ConsultantDetail.class);
                CoVanHocTapObject data = listData.get(position);
                intentView.putExtra("CVHTObject", data);
                startActivity(intentView);
            }
        });
       btnSearch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String request = "";
               if(edtSearch.getText().toString() != null){
                   request =  edtSearch.getText().toString();
               }
               searchData(request);
           }
       });
    }

    private void searchData(String request){
        listData = _service.getAll(request);
        adapter = new messageAdapter(Message.this,R.layout.adapte_message, listData);
        lv.setAdapter(adapter);
    }

}