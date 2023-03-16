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
        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        pref = MainActivity.this.getSharedPreferences("data", MODE_PRIVATE);
        if (sharedPreferences.getAll().size()>0){
            setContentView(R.layout.activity_second);
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
                String password = editpassword.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.apply();
                if (username.equals("amel") && password.equals("1a")) {
                    Toast.makeText(MainActivity.this, "login berhasil", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    // untuk mengarahkan halaman 1 ke halaman 2
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
//                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("password",password);
                    editor.putString("username",username);
                    editor.putBoolean("status_login", true);
                    editor.apply();
                    editor.commit();
                    startActivity(intent);
                    finish();
                    //agar tidak kembali ke halaman sebelumnya
                } else {
                    Toast.makeText(MainActivity.this, "login gagal", Toast.LENGTH_LONG).show();
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