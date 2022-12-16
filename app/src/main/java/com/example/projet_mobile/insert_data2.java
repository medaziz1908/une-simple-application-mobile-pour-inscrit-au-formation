package com.example.projet_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insert_data2 extends AppCompatActivity {

    EditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data2);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);


    }



    public void aadRecord(View view){
        DbManager db=new DbManager(this);
        if (!Patterns.EMAIL_ADDRESS.matcher(t2.getText().toString()).matches())
        {
            Toast.makeText(insert_data2.this, "mail incorrecte", Toast.LENGTH_LONG).show();
        }
        else if (t1.getText().toString().equals(""))
        {
            Toast.makeText(insert_data2.this, "VIDE", Toast.LENGTH_LONG).show();

        }
        else {

            String res=db.addRecord(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString());

            Toast.makeText(this,res,Toast.LENGTH_LONG).show();

            String nom = t1.getText().toString();
            Intent i = new Intent(getApplicationContext(),more_info.class);
            i.putExtra("NOME",nom);
            startActivity(i);

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");}


    }

}

