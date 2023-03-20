package com.amel.kedua;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amel.kedua.R;

public class MainActivity extends AppCompatActivity {
    EditText editusername,editpassword;
    Button loginbtn,regisbtn;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getSharedPreferences("Login", MODE_PRIVATE);
        if (pref.contains("username")){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            finish(); // tambahkan kode ini agar pengguna tidak bisa kembali ke halaman login
        }
        setContentView(R.layout.activity_main);
        editusername = findViewById(R.id.editusername);
        editpassword = findViewById(R.id.editpassword);
        loginbtn = findViewById(R.id.loginbtn);
        regisbtn = findViewById(R.id.regisbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editusername.getText().toString();
                String pass = editpassword.getText().toString();
                if (username.equals("admin") && pass.equals("admin")){
                    SharedPreferences.Editor editor = pref.edit();
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    editor.putString("username", username); // ubah "email" menjadi "username"
                    editor.putString("password", pass); // ubah "pass" menjadi "password"
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    finish(); // tambahkan kode ini agar pengguna tidak bisa kembali ke halaman login
                }else {
                    Toast.makeText(MainActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
        regisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, RegisActivity.class);
                startActivity(intent);
            }
        });
    }

}