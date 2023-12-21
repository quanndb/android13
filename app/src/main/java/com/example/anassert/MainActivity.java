package com.example.anassert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anassert.SINHVIEN.SinhVienDAO;
import com.example.anassert.SINHVIEN.SinhVienObject;

import BUITIENDUNG.Result;
import LEMINHKHOI.Message;
import PHAHUUHIEU.ReportingAdvisor;
import VUMINHQUAN.StudyPlan;
import VUMINHQUAN.SuggestedSubjects;
import VUXUANDIEP.Document;
import VUXUANDIEP.Timetable;

public class MainActivity extends AppCompatActivity {
    SinhVienDAO sinhVienDAO;
    SinhVienObject getSV;
    ImageView back,imageTimetable,imageDocument,imageMessage,imageResult, btnReport,btnChat, btnEvaluate;
    Button btnPair,btnTest,btnStudyplane,btnSugsub,btnLater1,btnLater2,btnLater3,btnLater4;
    ConstraintLayout logo,logo1;
    TextView txtUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String username = getIntent().getStringExtra("hoTen");
        String role = getIntent().getStringExtra("role");
        int IDTK = Integer.parseInt(getIntent().getStringExtra("IDTK"));

        super.onCreate(savedInstanceState);
        if(role.equals("student")){
            setContentView(R.layout.activity_main_student);
            sinhVienDAO = new SinhVienDAO(this);
            getSV = sinhVienDAO.getSV(IDTK);
            getWidgetStudent();
            appStudent();
        }
        else{
            setContentView(R.layout.activity_main_teacher);
            getWidgetTeacher();
            appTeacher();
        }
        txtUsername.setText(username);
        getBack();

    }

    private void appTeacher() {
        btnEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intentWarning  = new Intent(MainActivity.this, ReportingAdvisor.class);
                startActivity(intentWarning);
            }
        });
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));

                try {
                    startActivity(emailIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    // Handle case where no email app is available
                }
            }
        });
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnLater1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
        btnLater2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
        btnLater3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
        btnLater4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImplicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.haui.edu.vn/vn"));
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
    }

    private void appStudent() {

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

        btnStudyplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStudyplane = new Intent(MainActivity.this, StudyPlan.class);
                intentStudyplane.putExtra("IDSV",getSV.getID()+"");
                startActivity(intentStudyplane);
            }

        });
        btnSugsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSugsub = new Intent(MainActivity.this, SuggestedSubjects.class);
                intentSugsub.putExtra("IDSV",getSV.getID()+"");
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
                Intent intentImplicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.haui.edu.vn/vn"));
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
        btnPair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sms();
            }
        });
    }

    private void getWidgetStudent() {
        back = findViewById(R.id.imageback);
        txtUsername = findViewById(R.id.txtUsername);
        imageMessage = findViewById(R.id.imageMessage);
        imageTimetable = findViewById(R.id.imageTimetable);
        imageDocument = findViewById(R.id.imageDocument);
        imageResult = findViewById(R.id.imageResult);
        btnStudyplane = findViewById(R.id.btnStudyplane);
        btnSugsub = findViewById(R.id.btnSuggestedsubjects);
        logo  = findViewById(R.id.logo);
        logo1  = findViewById(R.id.logo1);
        btnPair = findViewById(R.id.btnPair);
        btnTest = findViewById(R.id.btnTest);
    }

    private void getWidgetTeacher(){
        back = findViewById(R.id.imageback);
        txtUsername = findViewById(R.id.txtUsername);
        btnReport = findViewById(R.id.btnReport);
        logo  = findViewById(R.id.logo);
        logo1  = findViewById(R.id.logo1);
        btnChat = findViewById(R.id.btnChat);
        btnEvaluate = findViewById(R.id.btnEvaluate);
        btnLater1 = findViewById(R.id.btnLater1);
        btnLater2 = findViewById(R.id.btnLater2);
        btnLater3 = findViewById(R.id.btnLater3);
        btnLater4 = findViewById(R.id.btnLater4);
    }
    private void getBack(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder backRequest = new AlertDialog.Builder(MainActivity.this);
                backRequest.setTitle("Xác nhận đăng xuất");
                backRequest.setMessage("Bạn có chắc chắn muốn đăng xuất");
                backRequest.setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent backLogin = new Intent(MainActivity.this,Login.class);
                        startActivity(backLogin);
                        finish();
                    }
                });
                backRequest.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                backRequest.create().show();
            }

        });
    }
    //Thông báo tính năng đang trong quá trình phát triển
    private void Sms() {
        Toast.makeText(MainActivity.this, "Tính năng đang trong quá trình phát triển", Toast.LENGTH_SHORT).show();
    }
}