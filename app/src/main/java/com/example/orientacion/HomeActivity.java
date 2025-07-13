package com.example.orientacion;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Obtener el botón por su ID
        Button button = findViewById(R.id.btn_comienza);

        // Establecer el OnClickListener del Botón Comienza
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para disparar la siguiente Activity
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Obtener el TextView de registro
        TextView textView = findViewById(R.id.txv_registro);

        // Establecer el OnClickListener del TextView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la nueva actividad
                Intent intent = new Intent(HomeActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}