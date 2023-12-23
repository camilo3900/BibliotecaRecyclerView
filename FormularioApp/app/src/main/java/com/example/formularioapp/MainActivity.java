package com.example.formularioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


import com.example.formularioapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String nombre, edad, genero;
    CheckBox terminos;
//    Boolean terminos = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        genero = "Hombre";

        binding.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             capturarDatos();
            }
        });
    }

    private void capturarDatos() {
        nombre = binding.edtNombre.getEditableText().toString();
        edad = binding.edtEdad.getEditableText().toString();
        genero = binding.rbMujer.isChecked()? "Mujer": "Hombre";
        terminos = binding.chkTerminos;
        if(validarCampos()){
            Toast.makeText(getBaseContext(), "Llenar campo nombre", Toast.LENGTH_LONG).show();
            System.out.println("nombre: "+nombre+"\nedad: "+edad);
            Bundle bundle = new Bundle();
            bundle.putString("name", nombre);
            bundle.putString("age", edad);
            bundle.putString("gender", genero);
//            Intent intent = new Intent(MainActivity.this, DatosActivity.class);
//            intent.putExtras(bundle);
//            startActivity(intent);

            startActivity(new Intent(MainActivity.this, DatosActivity.class).putExtras(bundle));

        }
    }

    private boolean validarCampos() {
        boolean entrar = false;
        if(binding.edtNombre.getEditableText().toString().equals("")){
            Toast.makeText(getBaseContext(), "Llenar campo nombre", Toast.LENGTH_LONG).show();
        }
        else if(edad.isEmpty()){
            Toast.makeText(getBaseContext(), "Llenar campo edad", Toast.LENGTH_LONG).show();
        }
        else if(!terminos.isChecked()){
            Toast.makeText(getBaseContext(), "Aceptar Terminos!!", Toast.LENGTH_LONG).show();
        }
        else{
            entrar=true;
        }
        return entrar;
    }
}