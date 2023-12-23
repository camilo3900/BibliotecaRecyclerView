package com.example.formularioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.formularioapp.databinding.ActivityDatosBinding;

public class DatosActivity extends AppCompatActivity {

    ActivityDatosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle recoge= getIntent().getExtras();
        if(recoge!=null){
            binding.tvNombre.setText(recoge.getString("name", "nada"));
            binding.tvGenero.setText(recoge.getString("gender", "nada"));
            binding.tvEdad.setText(recoge.getString("age", "nada"));
        }

        binding.btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ERROR", "este es mi error");

            }
        });
    }
}