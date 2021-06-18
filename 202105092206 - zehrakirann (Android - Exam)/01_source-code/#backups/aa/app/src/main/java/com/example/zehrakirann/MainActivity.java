package com.example.zehrakirann;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ArrayList> ZK_liste;

    public MainActivity() {
        this.ZK_liste = new ArrayList<ArrayList>();
    }

    public MainActivity(ArrayList<ArrayList> _liste) {
        this.ZK_liste = _liste;
    }

    int CAMERA_REQUEST = 10;
    private ImageView ZK_imageViewFotograf;
    private Button ZK_buttonFotografCek,ZK_buttonDevam;
    private EditText ZK_editTextAdiniz,ZK_editTextSoyadiniz;
    private Bitmap ZK_fotograf;

    @Override
    protected  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);


        ZK_imageViewFotograf = (ImageView)findViewById(R.id.ZK_imageViewFotograf);
        ZK_buttonFotografCek = (Button)findViewById(R.id.ZK_buttonFotografCek);
        ZK_buttonDevam = (Button)findViewById(R.id.ZK_buttonDevam);
        ZK_editTextAdiniz = (EditText)findViewById(R.id.ZK_editTextAdiniz);
        ZK_editTextSoyadiniz = (EditText)findViewById(R.id.ZK_editTextSoyadiniz);

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
                ZK_bilgiler.add(ZK_fotograf);
                ZK_bilgiler.add(ZK_editTextAdiniz.getText());
                ZK_bilgiler.add(ZK_editTextSoyadiniz.getText());

                ZK_liste.add(ZK_bilgiler);

                
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            ZK_imageViewFotograf.setImageBitmap(image);
            ZK_fotograf = image;
        }
    }
}
