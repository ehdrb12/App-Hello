package com.human.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTel = findViewById(R.id.btnTel);

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "전화걸기실행!", Toast.LENGTH_LONG).show();
                Intent telIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:010-1111-1111"));
                startActivity(telIntent);
                finish();
                System.exit(0);
            }
        });
    }

    public void goToNaver(View view) {
        //Toast.makeText(getApplicationContext(),"네이버웹 클릭!",Toast.LENGTH_LONG).show();
        Intent naverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
        startActivity(naverIntent);
    }
}