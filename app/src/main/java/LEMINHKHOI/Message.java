package LEMINHKHOI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anassert.R;

public class Message extends AppCompatActivity {
    Button btnInfor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getID();
        app();
    }
    private void getID(){
        btnInfor = findViewById(R.id.btnInfor);
    }
    private void app(){
        btnInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itentConsultantDetail = new Intent(Message.this, ConsultantDetail.class);
                startActivity(itentConsultantDetail);
            }
        });
    }
}