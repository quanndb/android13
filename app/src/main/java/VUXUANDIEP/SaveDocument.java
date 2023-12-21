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

public class SaveDocument extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView txtUrl;
    private SaveDocumentDAO dao ;
    private SaveDocumentAdapter adapter;

    private LinearLayoutManager linearLayoutManager;
    private ArrayList<SaveDocumentObject> list;
    private  SaveDocumentAdapter savedocumentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_document);
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
        dao = new SaveDocumentDAO(this);
        list = dao.getAll();
        adapter = new SaveDocumentAdapter(this,list);
        recyclerView.setAdapter(adapter);
        /* RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        documentAdapter = new DocumentAdapter(Document.this,List());
        recyclerView.setAdapter(documentAdapter);*/
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudocument,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_close) {
            finish();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}