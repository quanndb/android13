package com.example.anassert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import BUITIENDUNG.Result;
import LEMINHKHOI.Message;
import PHAHUUHIEU.ReportingAdvisor;
import VUMINHQUAN.StudyPlan;
import VUMINHQUAN.SuggestedSsubjects;
import VUXUANDIEP.Document;
import VUXUANDIEP.Timetable;

public class MainActivity extends AppCompatActivity {
    ImageView back,imageTimetable,imageDocument,imageMessage,imageResult;
    Button btn2,btnReport,btnStudyplane,btnSugsub;
    ConstraintLayout logo,logo1;
    TextView txtUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getID();
        String username = getIntent().getStringExtra("key_username");
        txtUsername.setText(username);
        getBack();
        activity();
    }
    private void getID(){
        btnReport = findViewById(R.id.btnReport);
        btnStudyplane = findViewById(R.id.btnStudyplane);
        btnSugsub = findViewById(R.id.btnSuggestedsubjects);
        btn2 = findViewById(R.id.btn2);
        logo  = findViewById(R.id.logo);
        logo1  = findViewById(R.id.logo1);
        back = findViewById(R.id.imageback);
        imageTimetable = findViewById(R.id.imageTimetable);
        imageDocument = findViewById(R.id.imageDocument);
        imageMessage = findViewById(R.id.imageMessage);
        imageResult = findViewById(R.id.imageResult);
        txtUsername = findViewById(R.id.txtUsername);

    }
    public void activity(){

        //Timetable
        imageTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTimetbable = new Intent(MainActivity.this, Timetable.class);
                startActivity(intentTimetbable);
            }
        });
        imageDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDocument = new Intent(MainActivity.this, Document.class);
                startActivity(intentDocument);
            }
        });
        imageMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMesage = new Intent(MainActivity.this, Message.class);
                startActivity(intentMesage);
            }
        });
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intentWarning  = new Intent(MainActivity.this, ReportingAdvisor.class);
                startActivity(intentWarning);
            }
        });
        btnStudyplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStudyplane = new Intent(MainActivity.this, StudyPlan.class);
                startActivity(intentStudyplane);
            }

        });
        btnSugsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSugsub = new Intent(MainActivity.this, SuggestedSsubjects.class);
                startActivity(intentSugsub);
            }
        });
        imageResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(MainActivity.this, Result.class);
                startActivity(result);
            }
        });
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImplicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/46lQ8G9"));
                startActivity(intentImplicit);
            }
        });
        logo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImplicit1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fit.haui.edu.vn/vn"));
                startActivity(intentImplicit1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
    }
    private void getBack(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLogin = new Intent(MainActivity.this,Login.class);
                startActivity(backLogin);
                finish();
            }
        });
    }
    //Thông báo tính năng đang trong quá trình phát triển
    private void Sms() {
        Toast.makeText(MainActivity.this, "Tính năng đang trong quá trình phát triển", Toast.LENGTH_SHORT).show();
    }

}