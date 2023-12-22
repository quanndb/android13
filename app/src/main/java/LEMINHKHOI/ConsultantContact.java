package LEMINHKHOI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anassert.CoVanHocTap.CoVanHocTapObject;
import com.example.anassert.R;

public class ConsultantContact extends AppCompatActivity {
    TextView txtEmail;
    EditText txtTile, txtDescription;
    Button btnSend;
    private CoVanHocTapObject data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultant_contact);
        setup();
    }

    private void setup(){
        txtEmail = findViewById(R.id.txt_email_contact);
        txtTile = findViewById(R.id.txt_title_contact);
        txtDescription = findViewById(R.id.txt_description_contact);
        btnSend = findViewById(R.id.btn_sendEmail_contact);

        Intent intent = getIntent();
        if (intent != null) {
            // Nhận đối tượng từ Intent
            data = (CoVanHocTapObject) intent.getSerializableExtra("email_contact");
            // Sử dụng đối tượng nhận được
            if (data != null) {
                txtEmail.setText(data.Email.toString());
            }
        }


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String[] TO = {data.Email};
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, txtTile.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, txtDescription.getText().toString());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            // Handle case where no email app is available
        }
    }
}