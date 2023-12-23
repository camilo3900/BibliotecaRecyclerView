package com.example.mascotasapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mascotasapp.databinding.ActivityDatosMascotaBinding;
import java.util.ArrayList;

public class DatosMascotaActivity extends AppCompatActivity {

    ActivityDatosMascotaBinding binding;
    Bundle recibe;
    ArrayList<String> vacunas;
    String nombre, edad, mascota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatosMascotaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recibe = getIntent().getExtras();
        if(recibe!=null){
            nombre = recibe.getString("NAME", "nada");
            edad = recibe.getString("AGE", "nada");
            mascota = recibe.getString("MASCOTA", "nada");
            vacunas = recibe.getStringArrayList("VACUNA");
            switch (mascota){
                case "PERRO":
                    binding.imgMascota.setImageResource(R.drawable.perro_icon);
                    break;
                case "CONEJO":
                    System.out.println("El número es 2");
                    binding.imgMascota.setImageResource(R.drawable.conejo_icon);
                    break;
                case "GATO":
                    System.out.println("El número es 3");
                    binding.imgMascota.setImageResource(R.drawable.gato_icon);
                    break;
                case "SAPO":
                    System.out.println("El número es 3");
                    binding.imgMascota.setImageResource(R.drawable.sapo_icon);
                    break;
                default:
                    binding.imgMascota.setImageResource(R.drawable.undefined_icon);
                    break;
            }
            binding.tvNombreMascota.setText(nombre);
            binding.tvEdadMascota.setText(edad);
            binding.tvTipoMascota.setText(mascota);
            binding.tvVacunasMascota.setText(vacunas.toString());
        }



    }
}