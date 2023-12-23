package com.example.interaccion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.interaccion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String nombre  ;
    int edad;
    String apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = binding.edtNombre.getText().toString();
                apellido = binding.edtApellido.getText().toString();
                edad = Integer.parseInt(binding.edtEdad.getText().toString());
                System.out.println(nombre+" "+apellido+" su edad es: "+edad*5);
                Bundle bundle = new Bundle();
                bundle.putString("NAME", nombre);
                bundle.putInt("AGE", edad);
                hacerIntent(MainActivity.this, SecondActivity.class, bundle);
            }
        });

        binding.btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerCampos();
                binding.tvMensaje.setText("Hola "+nombre+" "+apellido+"!");
            }
        });
    }

    private void obtenerCampos(){
        nombre = binding.edtNombre.getText().toString();
        apellido = binding.edtApellido.getText().toString();

    }
    private void hacerIntent(Context vista, Class<?> destino, Bundle bundle){
        Intent intent = new Intent(vista, destino);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}