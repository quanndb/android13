package LEMINHKHOI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anassert.CoVanHocTap.CoVanHocTapDAO;
import com.example.anassert.CoVanHocTap.CoVanHocTapObject;
import com.example.anassert.CoVanHocTap.HocPhanDto;
import com.example.anassert.R;

import java.util.ArrayList;

public class ConsultantDetail extends AppCompatActivity {
   Button btnContact;
   TextView txtName, txtPhone, txtEmail;
   ListView lv;
   private CoVanHocTapObject data;
   private CoVanHocTapDAO _service;
    ArrayList<HocPhanDto> listData = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultant_detail);
        _service = new CoVanHocTapDAO(ConsultantDetail.this);
        getData();
        app();
    }
    private void getData(){
        btnContact = findViewById(R.id.btn_contact_messageDetails);
        txtEmail = findViewById(R.id.txt_email_messageDetails);
        txtPhone = findViewById(R.id.txt_phone_messageDetails);
        txtName = findViewById(R.id.txt_fulleName_messageDetails);
        lv = findViewById(R.id.lv_consultant_details);

        Intent intent = getIntent();
        if (intent != null) {
            // Nhận đối tượng từ Intent
            data = (CoVanHocTapObject) intent.getSerializableExtra("CVHTObject");

            // Sử dụng đối tượng nhận được
            if (data != null) {
                txtEmail.setText(data.Email.toString());
                txtPhone.setText(data.PhoneNumber.toString());
                txtName.setText(data.FullName.toString());

                listData = _service.getAllHP(data.ID);
                adapter = new consultant_details_Adapter(ConsultantDetail.this,R.layout.adapter_consultant_details, listData);
                lv.setAdapter(adapter);
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