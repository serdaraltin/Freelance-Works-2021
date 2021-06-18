package com.example.zehrakirann;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ArrayList> ZK_liste;
    ArrayList<Bitmap> ZK_listeBitmap;


    int CAMERA_REQUEST = 10;
    private ImageView ZK_imageViewFotograf;
    private Button ZK_buttonFotografCek,ZK_buttonDevam;
    private EditText ZK_editTextAdiniz,ZK_editTextSoyadiniz;
    private Bitmap ZK_fotograf;

    @Override
    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);


        ZK_liste = new ArrayList<ArrayList>();
        ZK_listeBitmap = new ArrayList<Bitmap>();

        ZK_imageViewFotograf = (ImageView) findViewById(R.id.ZK_imageViewFotograf);
        ZK_buttonFotografCek = (Button) findViewById(R.id.ZK_buttonFotografCek);
        ZK_buttonDevam = (Button) findViewById(R.id.ZK_buttonDevam);
        ZK_editTextAdiniz = (EditText) findViewById(R.id.ZK_editTextAdiniz);
        ZK_editTextSoyadiniz = (EditText) findViewById(R.id.ZK_editTextSoyadiniz);

        addListener();
    }

    public void addListener(){
        ZK_buttonFotografCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });

        ZK_buttonDevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ZK_editTextAdiniz.getText().toString().equals("") || ZK_editTextSoyadiniz.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(),"Gerekli alanları doldurunuz !",Toast.LENGTH_SHORT).show();
                    //return;
                }
                ArrayList ZK_bilgiler = new ArrayList();
                ZK_bilgiler.add(ZK_editTextAdiniz.getText());
                ZK_bilgiler.add(ZK_editTextSoyadiniz.getText());

                ZK_liste.add(ZK_bilgiler);
                ZK_listeBitmap.add(ZK_fotograf);


                Intent gecisYap = new Intent(MainActivity.this, MainActivity2.class);
                gecisYap.putExtra("liste",ZK_liste);
                gecisYap.putExtra("listeBitmap",ZK_listeBitmap);
                startActivity(gecisYap);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");

            ZK_fotograf = image;
            ZK_imageViewFotograf.setImageBitmap(image);
        }

    }
}
