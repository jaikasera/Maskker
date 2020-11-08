package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void switchAbout(View view)
    {
        startActivity(new Intent(MainActivity.this, AboutUsJava.class));
    }
    public void switchScanner(View view)
    {
        startActivity(new Intent(MainActivity.this, MaskScannerJava.class));
    }
}

