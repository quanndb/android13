package VUXUANDIEP;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.anassert.R;
import java.util.ArrayList;
import android.view.Menu;
import android.view.MenuItem;

public class Document extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView txtUrl;
    private DocumentDAO dao ;
    private DocumentAdapter adapter;
    Button btnWatch,btnSave,btnReport;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<DocumentObject> list;
    private  DocumentAdapter documentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //vd4 set back button
        ActionBar actionBar = getSupportActionBar();
        String tab = "";
        for (int i = 0; i < 13; i++) {
            tab += "\t";
        }
        actionBar.setTitle(tab+"Tài liệu tham khảo");
        recyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView .setLayoutManager(linearLayoutManager);
        dao = new DocumentDAO(this);
        list = dao.getAll();
        adapter = new DocumentAdapter(this,list);
        recyclerView.setAdapter(adapter);
        /* RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        documentAdapter = new DocumentAdapter(Document.this,List());
        recyclerView.setAdapter(documentAdapter);*/
    }

    private ArrayList<DocumentObject>Listt(){
        ArrayList<DocumentObject> list = new ArrayList<>();
        String subjectid[] = {"LP6010","LP6011","LP6004",
                "LP6013","LP6012"};
        String subject[] = {"Triết học","Kinh Tế Chính Trị","Tư tưởng Hồ Chí Minh",
                "Lịch Sử Đảng cộng sản Việt Nam", "Chủ nghĩa xã hội khoa học"};
        String url[] ={"https://lps.haui.edu.vn/vn"};
        String decrible[] = {"Thuộc khoa chính trị - pháp luật"};
        for(int i = 0;i<subjectid.length;i++) {
            list.add(new DocumentObject("Mã học phần:"+subjectid[i],"Tên học phần:"+subject[i],url[0],decrible[0]));
        }
        //listtb.add(new TimeTable("T2","2/10","Tieng Anh","Thao","508-A9","1,2","C1"));

        return list;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudocument,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_save) {
           Intent  save = new Intent(Document.this,SaveDocument.class);
           startActivity(save);
            return true;
        }
        else if (id==R.id.action_close) {
            finish();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}