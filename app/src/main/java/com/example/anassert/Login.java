package com.example.anassert;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.anassert.TAIKHOAN.TaiKhoanDAO;
import com.example.anassert.TAIKHOAN.TaiKhoanObject;

import VUXUANDIEP.Timetable;

public class Login extends AppCompatActivity {
    Button btn_Login,btnSignup,ok_btn;

    EditText editUsername, editPassword;
    TextView txtMiss;

    TaiKhoanDAO taiKhoanDAO;
    CheckBox chkLuuThongTin;
    String tenThongTinDangNhap="login";
    private ImageButton cancelButton;
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
                saveLoginState();
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                if(username.equals("")  || password.equals("") ){
                    Toast.makeText(Login.this,"Yêu cầu nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }else{

                    TaiKhoanObject user = taiKhoanDAO.Login(username,password);
                    if(user != null){
                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intentMain =  new Intent(Login.this,MainActivity.class);
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
                View alertCustomDialog = LayoutInflater.from(Login.this).inflate(R.layout.custom_miss,null);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Login.this);

                alertDialog.setView(alertCustomDialog);
                cancelButton = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
                ok_btn = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);
                final  AlertDialog dialog = alertDialog.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                ok_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        Toast.makeText(Login.this, "Cố lên.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
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
        btnSignup = findViewById(R.id.btnSignup);
        editUsername = findViewById(R.id.editUsername) ;
        editPassword = findViewById(R.id.editPassword);
        txtMiss  = findViewById(R.id.txtMiss);
        chkLuuThongTin = findViewById(R.id.chkLuuThongTin);
    }
    private void saveLoginState(){
        SharedPreferences preferences=getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("UserName", editUsername.getText().toString());
        editor.putString("PassWord", editPassword.getText().toString());
        editor.putBoolean("Save", chkLuuThongTin.isChecked());
        editor.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        String userName = preferences.getString("UserName","");
        String pass = preferences.getString("PassWord","");
        boolean save = preferences.getBoolean("Save",false);
        if (save) {
            editUsername.setText(userName);
            editPassword.setText(pass);
            chkLuuThongTin.setChecked(save);
        }
    }
}