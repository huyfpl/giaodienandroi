package com.example.huynvph20687_2608;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.setMax(10);
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setMessage("loading...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent i=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);

                finish();
                progressDialog.dismiss();
            }

        }).start();
    }
}