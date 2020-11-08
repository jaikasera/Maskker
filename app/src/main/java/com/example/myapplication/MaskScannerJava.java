package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageFormat;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class MaskScannerJava extends AppCompatActivity {

    ImageView imageView;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mask_scan);

        imageView = findViewById(R.id.imageView6);
        button = findViewById(R.id.imageButton6);
        if(ContextCompat.checkSelfPermission(MaskScannerJava.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MaskScannerJava.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] array = stream.toByteArray();
            imageView.setImageBitmap(bitmap);
            checkMask(true);

        }
    }


    public void switchHomeAgain(View view)
    {
        startActivity(new Intent(MaskScannerJava.this, MainActivity.class));
    }

    public void takePicture(View view)
    {

    }

    public void checkMask(boolean maskCorrect)
    {
        if(maskCorrect)
        {
            ImageView image1 = (ImageView)findViewById(R.id.imageView);
            image1.setVisibility(View.VISIBLE);
        }
        else
        {
            ImageView image2 = (ImageView)findViewById(R.id.imageView3);
            image2.setVisibility(View.VISIBLE);
        }
    }




}


