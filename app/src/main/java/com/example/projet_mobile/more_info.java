package com.example.projet_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class more_info extends AppCompatActivity {
     private static final int REQUEST_CALL=1;
    TextView nome;
    Button btn;
    Button btn2;
    Button btn3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        nome = findViewById(R.id.txtv);
        Bundle extras = getIntent().getExtras();
        String noma =extras.getString("NOME");

        nome.setText("Welcome: " +noma+",find more info here");

        btn = findViewById(R.id.butt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(ii);


            }
        });

        btn2 = findViewById(R.id.butt2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makecall();
            }
        });

        btn3 = findViewById(R.id.butt3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(more_info.this, ViewListContents.class);
                startActivity(intent);


            }
        });




    }

    private void makecall() {

        int number = 24556234;
        if (number > 0) {

            if (ContextCompat.checkSelfPermission(more_info.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(more_info.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        }
    }

}
