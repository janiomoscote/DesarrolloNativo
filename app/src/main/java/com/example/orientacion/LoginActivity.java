package com.example.orientacion;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         Button loginButton;
         Button loginGoogleButton;
         Button recuperarButton;

        usernameEditText = findViewById(R.id.etx_nombre_usuario);
        passwordEditText = findViewById(R.id.etx_contrasenya);
        loginButton = findViewById(R.id.btn_ingresar);
        loginGoogleButton = findViewById(R.id.btn_google);
        recuperarButton = findViewById(R.id.btn_recuperar);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Aquí puedes agregar la lógica de autenticación
                if (username.equals("usuario") && password.equals("contraseña")) {
                    // Si las credenciales son correctas, inicia la siguiente actividad
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Cierra la actividad de login
                } else {
                    // Si las credenciales son incorrectas, muestra un mensaje
                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Aquí puedes agregar la lógica de autenticación
                if (username.equals("usuario") && password.equals("contraseña")) {
                    // Si las credenciales son correctas, inicia la siguiente actividad
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Cierra la actividad de login
                } else {
                    // Si las credenciales son incorrectas, muestra un mensaje
                    Toast.makeText(LoginActivity.this, "Credenciales Google incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Obtener el TextView del registro de usuario
        TextView textView = findViewById(R.id.txv_regis_login);

        // Establecer el OnClickListener
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la nueva actividad
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
