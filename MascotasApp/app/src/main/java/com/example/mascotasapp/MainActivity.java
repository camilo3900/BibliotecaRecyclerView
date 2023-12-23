package com.example.mascotasapp;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mascotasapp.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    LinearLayout groupLeft;
    LinearLayout groupRigth;
    RadioButton selectedRadioButton = null;
    String nombre, edad;
    int idButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        boolean goToLeft= true;

        groupLeft = binding.columnLeft;
        groupRigth = binding.columnRigth;
        groupRigth.removeAllViews();
        groupLeft.removeAllViews();
        ArrayList<String> listaMascotas = new ArrayList<>();
        listaMascotas.add("PERRO");
        listaMascotas.add("CONEJO");
        listaMascotas.add("GATO");
        listaMascotas.add("SAPO");

        System.out.println("lista "+ listaMascotas);

        for(String mascota : listaMascotas){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(View.generateViewId());
            radioButton.setText(mascota);
            radioButton.setTextColor(getColor( R.color.white));
            ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white));
            radioButton.setButtonTintList(colorStateList);
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(radioButton.getId()+"\n" + radioButton.getText());
                    idButton = v.getId();
                    if (selectedRadioButton != null) {
                        selectedRadioButton.setChecked(false);
                    }
                    selectedRadioButton = (RadioButton) v;
                    selectedRadioButton.setChecked(true);
                }
            });

            if(goToLeft){
                groupLeft.addView(radioButton);
            }else{
                groupRigth.addView(radioButton);
            }
            goToLeft = !goToLeft;
        }

        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarCampos()) {
                    binding.edtNombre.setText("");
                    binding.edtEdad.setText("");
                    ArrayList<String> vacunas = new ArrayList<>();
                    if(binding.chkVacuna1.isChecked()) {
                        vacunas.add(binding.chkVacuna1.getText().toString());
                    }
                    if(binding.chkVacuna2.isChecked()) {
                        vacunas.add(binding.chkVacuna2.getText().toString());
                    }
                    if(binding.chkVacuna3.isChecked()) {
                        vacunas.add(binding.chkVacuna3.getText().toString());
                    }
                    if(binding.chkVacuna4.isChecked()) {
                        vacunas.add(binding.chkVacuna4.getText().toString());
                    }
                    if(binding.chkVacuna5.isChecked()) {
                        vacunas.add(binding.chkVacuna5.getText().toString());
                    }
                    Intent intent = new Intent(MainActivity.this, DatosMascotaActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("NAME", nombre);
                    bundle.putString("AGE", edad);
                    bundle.putString("MASCOTA", selectedRadioButton.getText().toString());
                    bundle.putStringArrayList("VACUNA", vacunas);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
    private void limpiarErrores(){
        binding.edtNombre.setError(null);
        binding.edtEdad.setError(null);
    }
    private boolean validarCampos() {
        limpiarErrores();
        boolean entrar = false;
        nombre = binding.edtNombre.getEditableText().toString();
        edad = binding.edtEdad.getEditableText().toString();
        if(nombre.isEmpty()){
            binding.edtNombre.setError("Completar Nombre");
            Toast.makeText(getBaseContext(), "Llenar campo nombre", Toast.LENGTH_LONG).show();
        }
        else if(edad.isEmpty()){
            binding.edtEdad.setError("Completar Edad");
            Toast.makeText(getBaseContext(), "Llenar campo edad", Toast.LENGTH_LONG).show();
        }
        else{
            entrar=true;
        }
        return entrar;
    }
    }


