package LEMINHKHOI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anassert.CoVanHocTap.CoVanHocTapObject;
import com.example.anassert.R;

public class ConsultantDetail extends AppCompatActivity {
   Button btnContact;
   TextView txtName, txtPhone, txtEmail;
   private CoVanHocTapObject data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultant_detail);
        getID();
        app();
    }
    private void getID(){
        btnContact = findViewById(R.id.btn_contact_messageDetails);
        txtEmail = findViewById(R.id.txt_email_messageDetails);
        txtPhone = findViewById(R.id.txt_phone_messageDetails);
        txtName = findViewById(R.id.txt_fulleName_messageDetails);

        Intent intent = getIntent();
        if (intent != null) {
            // Nhận đối tượng từ Intent
            data = (CoVanHocTapObject) intent.getSerializableExtra("CVHTObject");

            // Sử dụng đối tượng nhận được
            if (data != null) {
                txtEmail.setText(data.Email.toString());
                txtPhone.setText(data.PhoneNumber.toString());
                txtName.setText(data.FullName.toString());
            }
        }


    }
    private void app(){
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContact = new Intent(ConsultantDetail.this, ConsultantContact.class);
                intentContact.putExtra("email_contact", data);
                startActivity(intentContact);
            }
        });
    }
}