package com.amel.kedua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amel.kedua.R;

public class SecondActivity extends AppCompatActivity {
    Button btnBack;
    Button btnLogout;
    Button btnDetail;
    Button btnListView;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        String usernameData = pref.getString("Username","");
//        Log.e("Isian Shared Pref",usernameData);
        Intent intent = getIntent();
        String data = intent.getStringExtra("username");
        Log.e("data intent",data);
        // untuk memvalidasi data

        btnBack = findViewById(R.id.btnBack);
        btnLogout = findViewById(R.id.btnLogout);
        btnDetail = findViewById(R.id.btnDetail);
        btnListView = findViewById(R.id.btnListView);
        // memeriksa status login saat aplikasi dimulai kembali


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                boolean statusLogin = sharedPreferences.getBoolean("status_login", false);
                if (!statusLogin) {
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
//                Toast.makeText(SecondActivity.this, "Berhasil Back", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
//                startActivity(intent);
//                SharedPreferences.Editor editor = pref.edit();
//                finish();

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Berhasil Logout", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Halaman Detail", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SecondActivity.this, Halaman.class);
                startActivity(intent);
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Halaman List View", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SecondActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}