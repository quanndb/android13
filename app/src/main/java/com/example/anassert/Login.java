package com.example.anassert;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anassert.TAIKHOAN.TaiKhoanDAO;
import com.example.anassert.TAIKHOAN.TaiKhoanObject;

import java.time.LocalDate;

public class Login extends AppCompatActivity {
    Button btn_Login;
    EditText editUsername, editPassword;
    TextView txtMiss;

    TaiKhoanDAO taiKhoanDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        taiKhoanDAO = new TaiKhoanDAO(this);
        getID();
        app();
    }

    private void app() {
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editUsername.length() == 0 || editPassword.length() == 0){
                    Toast.makeText(Login.this, "Yêu cầu nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    String username = editUsername.getText().toString().trim();
                    String password = editPassword.getText().toString().trim();
                    TaiKhoanObject user = taiKhoanDAO.Login(username,password);
                    if(user != null){
                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intentMain =  new Intent(Login.this,MainActivity.class);
                        intentMain.putExtra("IDTK",user.getID()+"");
                        intentMain.putExtra("hoTen",user.getHoTen());
                        intentMain.putExtra("role",user.getRole());
                        intentMain.putExtra("taiKhoan",user.getTaiKhoan());
                        startActivity(intentMain);
                        finish();
                    }
                    else{
                        Toast.makeText(Login.this, "Tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txtMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sms();
            }
        });
    }

    private void sms(){
        Toast.makeText(Login.this, "Chức năng đang trong quá trình phát triển", Toast.LENGTH_SHORT).show();
    }
    private void getID(){
        btn_Login =  findViewById(R.id.btnLogin);
        editUsername = findViewById(R.id.editUsername) ;
        editPassword = findViewById(R.id.editPassword);
        txtMiss  = findViewById(R.id.txtMiss);
    }
}