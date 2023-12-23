package com.example.mostrarnombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mostrarnombre.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String nombre;
    private String apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerCampos();
            }
        });

        binding.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarCampos();
            }
        });
    }

    private void borrarCampos() {
        binding.edtNombre.setText("");
        binding.edtApellido.setText("");
        binding.tvSaludar.setText("[SALUDO]");
    }

    private void obtenerCampos() {
        nombre = binding.edtNombre.getText().toString();
        apellido = binding.edtApellido.getText().toString();

        binding.tvSaludar.setText("Bienvenido, " + nombre+" "+apellido);


    }
}