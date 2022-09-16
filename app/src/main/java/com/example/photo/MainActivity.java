package com.example.photo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.capturedImage);
        button = findViewById(R.id.Photo);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, 100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(photo);
    }
}

//    private Button button;
//        private ImageView imageView;
//
//        imageView = findViewById(R.id.capturedImage);
//        button = findViewById(R.id.Photo);
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(open_camera, 100);
//            }
//        });
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Bitmap photo = (Bitmap)data.getExtras().get("data");
//        imageView.setImageBitmap(photo);
