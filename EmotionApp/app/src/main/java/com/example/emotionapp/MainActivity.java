package com.example.emotionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.emotionapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    int fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerResultado();
            }
        });


    }

    private void obtenerResultado() {
        TextView mensaje = binding.tvResultado;
        fecha = Integer.parseInt(binding.edtAnioNacimiento.getText().toString());

    /*1994-2010(IRREVERENCIA)
    * 1981-1993(FRUSTRACION)
    * 1969-1980(OBSESION POR EL EXITO)
    * 1949-1968(AMBICION)
    * 1930-1948(AUSTERIDAD)*/

        if(fecha<=2010 && fecha>=1994 ){
            mensaje.setText("GENERACION IRREVERENCIA");

        }else if(fecha<1994 && fecha>=1981 ){
            mensaje.setText("GENERACION FRUSTRACION");
        }else if(fecha<1981 && fecha>=1969 ){
            mensaje.setText("OBSESION POR EL EXITO");
    }else if(fecha < 1969 && fecha >= 1949){
            mensaje.setText("AMBICION");
        }else{
            mensaje.setText("AUSTERIDAD");
        }
        binding.edtAnioNacimiento.setText("");
}
}
