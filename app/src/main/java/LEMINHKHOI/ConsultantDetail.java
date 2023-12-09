package LEMINHKHOI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anassert.R;

public class ConsultantDetail extends AppCompatActivity {
   Button btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultant_detail);
        getID();
        app();
    }
    private void getID(){
        btnCheck = findViewById(R.id.btnCall);
    }
    private void app(){
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConsultantContact = new Intent(ConsultantDetail.this, ConsultantContact.class);
                startActivity(intentConsultantContact);
            }
        });
    }
}