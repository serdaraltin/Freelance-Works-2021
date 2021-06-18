package com.example.zehrakirann;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<ArrayList> ZK_liste;
    ArrayList<Bitmap> ZK_listeBitmap;


    Button ZK_buttonHesapla;
    EditText ZK_editTextBoy,ZK_editTextIdealKilo,ZK_editTextDurum,ZK_editTextKitleIndeks;
    SeekBar ZK_seekBarKilo;
    Spinner ZK_spinnerCinsiyet;
    TextView ZK_textViewKilo;
    RadioButton ZK_radioButtonGoster,ZK_radioButtonGosterme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();
        ZK_liste = (ArrayList) intent.getStringArrayListExtra("liste");
        ZK_listeBitmap = (ArrayList) intent.getStringArrayListExtra("listeBitmap");

        ZK_editTextBoy = (EditText)findViewById(R.id.ZK_editTextBoy);
        ZK_seekBarKilo = (SeekBar) findViewById(R.id.ZK_seekBarKilo);
        ZK_spinnerCinsiyet = (Spinner)findViewById(R.id.ZK_spinnerCinsiyet);
        ZK_textViewKilo = (TextView)findViewById(R.id.ZK_textViewKiloCikti);
        ZK_buttonHesapla = (Button)findViewById(R.id.ZK_buttonHesapla);
        ZK_editTextIdealKilo = (EditText)findViewById(R.id.ZK_editTextIdealKilo);
        ZK_editTextDurum = (EditText)findViewById(R.id.ZK_editTextDurum);
        ZK_editTextKitleIndeks = (EditText)findViewById(R.id.ZK_editTextKitleIndeks);
        ZK_radioButtonGoster = (RadioButton)findViewById(R.id.ZK_radioButtonGoster);
        ZK_radioButtonGosterme = (RadioButton)findViewById(R.id.ZK_radioButtonGosterme);

        ZK_radioButtonGoster.setChecked(true);

        ZK_seekBarKilo.setMax(200);

        ZK_textViewKilo.setText("50 kg");

        String[] ZK_cinsiyetler = {"Bay","Bayan"};
        ArrayAdapter ZK_arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,ZK_cinsiyetler);
        ZK_spinnerCinsiyet.setAdapter(ZK_arrayAdapter);

        AddListener();
    }

    public void AddListener(){

        ZK_buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ZK_editTextBoy.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Boy değerini giriniz !",Toast.LENGTH_SHORT).show();
                    return;
                }
                float ZK_boy = Float.parseFloat(ZK_editTextBoy.getText().toString());
                int ZK_kilo = 50 +ZK_seekBarKilo.getProgress();
                String ZK_cinsiyet = ZK_spinnerCinsiyet.getSelectedItem().toString();

                ZK_boy = ZK_boy/100.0f;

                float ZK_kitleIndex = (float)(ZK_kilo)/(ZK_boy*ZK_boy);

                float ZK_boyInc = (float)(ZK_boy * 39.3701);

                float ZK_idealKilo = 2.3f*(ZK_boyInc-60.0f);

                if(ZK_cinsiyet.equals("Bayan")){
                    ZK_idealKilo += 45.5f;
                }else{
                    ZK_idealKilo += 50.0f;
                }

                String ZK_durum = "";


                if(ZK_kitleIndex >= 0 && ZK_kitleIndex <= 18.4f){
                    ZK_durum = "Zayıf";
                }
                else if(ZK_kitleIndex >= 18.5f && ZK_kitleIndex <= 24.9f){
                    ZK_durum = "Normal";
                }
                else if(ZK_kitleIndex >= 25.0f && ZK_kitleIndex <= 29.9f){
                    ZK_durum = "Fazla Kilolu";
                }
                else if(ZK_kitleIndex >= 30.0f && ZK_kitleIndex <= 34.9f){
                    ZK_durum = "Şişman 1.Sınıf";
                }
                else if(ZK_kitleIndex >= 35.0f && ZK_kitleIndex <= 44.9f){
                    ZK_durum = "Şişman 2.Sınıf";
                }
                else if(ZK_kitleIndex >= 45.0f){
                    ZK_durum = "Aşırı Şişman 3.Sınıf";
                }


                ZK_editTextKitleIndeks.setText(String.valueOf(ZK_kitleIndex));

                if(ZK_radioButtonGoster.isChecked()){
                    ZK_editTextIdealKilo.setText(String.valueOf(ZK_idealKilo)+" kg");
                    ZK_editTextDurum.setText(ZK_durum);
                }else{
                    ZK_editTextIdealKilo.setText("Gösterilmiyor");
                    ZK_editTextDurum.setText("Gösterilmiyor");
                }

                ArrayList ZK_bilgiler = ZK_liste.get(ZK_liste.size()-1);
                ZK_bilgiler.add(ZK_durum);
                ZK_bilgiler.add(ZK_kitleIndex);
                ZK_liste.set(ZK_liste.size()-1,ZK_bilgiler);

                Intent gecisYap = new Intent(MainActivity2.this, MainActivity3.class);
                gecisYap.putExtra("liste",ZK_liste);
                gecisYap.putExtra("listeBitmap",ZK_listeBitmap);
                startActivity(gecisYap);

               //Toast.makeText(getApplicationContext(),ZK_liste.get(0).toString(),Toast.LENGTH_LONG).show();
            }
        });

        ZK_seekBarKilo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int ZK_durum = 50 + progress;
                ZK_textViewKilo.setText(String.valueOf(ZK_durum)+" kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}