package com.example.edadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edadapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String edad, mensaje;
   TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniciar();
        binding.btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesarEdad();
                Toast.makeText(getBaseContext(), "mi mensaje", Toast.LENGTH_LONG).show();
            }
        });



    }

    private void procesarEdad() {

        edad = binding.edtEdad.getText().toString();

        if (Integer.parseInt(edad)>=18){
            binding.tvRespuesta.setText("Tienes "+ String.valueOf(Integer.parseInt(edad)) + "Años, Eres Mayor de Edad");
        }else{
            binding.tvRespuesta.setText("Eres Menor de Edad");
        }
        binding.edtEdad.setText("");

    }

    private void iniciar() {
        titulo = binding.tvTitulo;

        titulo.setText("¿Eres Mayor de Edad?");

        binding.tvRespuesta.setText("[RESPUESTA]");
    }
}