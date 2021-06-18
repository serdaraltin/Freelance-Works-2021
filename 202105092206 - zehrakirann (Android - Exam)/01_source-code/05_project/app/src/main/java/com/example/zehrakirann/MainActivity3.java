package com.example.zehrakirann;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ArrayList<ArrayList> ZK_liste;
    ArrayList<Bitmap> ZK_listeBitmap;

    ListView ZK_listViewListe;
    Button ZK_buttonYeni;
    ImageView ZK_imageViewListe;


    @Override
    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        Intent intent = getIntent();
        ZK_liste = (ArrayList) intent.getStringArrayListExtra("liste");
        ZK_listeBitmap = (ArrayList) intent.getStringArrayListExtra("listeBitmap");

        ZK_buttonYeni = (Button)findViewById(R.id.ZK_buttonYeni);
        ZK_listViewListe = (ListView)findViewById(R.id.ZK_listViewListe);

        ArrayAdapter ZK_arrayAdapter = new ArrayAdapter<ArrayList>(this,R.layout.support_simple_spinner_dropdown_item,ZK_liste);

        ZK_listViewListe.setAdapter(ZK_arrayAdapter);

        AddListener();
    }

    public  void AddListener(){

        ZK_buttonYeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(gecisYap);
            }
        });


    }


}
