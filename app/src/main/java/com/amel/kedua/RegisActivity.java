package com.amel.kedua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amel.kedua.R;

public class RegisActivity extends AppCompatActivity {
    Button back;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        // memeriksa status login saat aplikasi dimulai kembali
        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            // pengguna akan diarahkan ke halaman yang sesuai
        } else {
            // pengguna akan diarahkan ke halaman login
            Intent intent = new Intent(RegisActivity.this, ListActivity.class);
            startActivity(intent);
            finish();
        }

        // membuat tombol "back"
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // kode untuk menangani tombol "back"
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // kode untuk menangani tombol "back"
        super.onBackPressed();
    }
};

