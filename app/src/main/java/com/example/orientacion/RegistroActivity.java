package com.example.orientacion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    EditText names, surnames, email, contrasenya, confirm_contras;
    String namesStr, surnamesStr,emailStr, contrasenyaStr, confirm_contrasStr;
    CheckBox ckbx_terminos;

    Button btn_registrar, btn_ingresar_reg;


    SharedPreferences shrprf;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        names=findViewById(R.id.edtx_nombres);
        surnames=findViewById(R.id.edtx_apellidos);
        email=findViewById(R.id.edtx_correo);
        contrasenya=findViewById(R.id.edtx_contrasenya);
        confirm_contras=findViewById(R.id.edtx_repet_contrasenya);
        btn_registrar=findViewById(R.id.btn_registrar);

        shrprf = getSharedPreferences("DataSP",Context.MODE_PRIVATE);


        btn_registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if( validarCampos()){
                    //Guardar los datos
                    guardarDatos();
                    Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    private boolean validarCampos() {
        namesStr = names.getText().toString().trim();
        surnamesStr = surnames.getText().toString().trim();
        emailStr = email.getText().toString().trim();
        contrasenyaStr = contrasenya.getText().toString().trim();
        confirm_contrasStr = confirm_contras.getText().toString().trim();

        if (namesStr.isEmpty()) {
            Toast.makeText(this, "El campo Nombre es requerido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (surnamesStr.isEmpty()) {
            Toast.makeText(this, "El campo Apellido es requerido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (emailStr.isEmpty()) {
            Toast.makeText(this, "El campo Correo es requerido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (contrasenyaStr.isEmpty()) {
            Toast.makeText(this, "El campo Contraseña es requerido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!contrasenyaStr.equals(confirm_contrasStr)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!ckbx_terminos.isChecked()) {
            Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void guardarDatos() {
        SharedPreferences.Editor editor = shrprf.edit();
        editor.putString("nombres", namesStr);
        editor.putString("apellidos",surnamesStr);
        editor.putString("correo",emailStr);
        editor.putString("contrasena",contrasenyaStr);
        editor.apply();
        Toast.makeText(RegistroActivity.this,"Información Salvada", Toast.LENGTH_LONG).show();
    }
}
