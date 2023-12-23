package com.example.interaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.interaccion.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {


    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle datos = getIntent().getExtras();

        String recibeNombre = null;
        int recibeEdad = 0;
        if (datos != null) {
            recibeNombre = datos.getString("NAME", "John Doe");
            recibeEdad = datos.getInt("AGE", 0);
        }

        binding.tvName.setText("Su nombre es: " + recibeNombre);
        binding.tvAge.setText("SU EDAD ES: "+ recibeEdad);


    }
}