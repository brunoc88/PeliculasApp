package com.softulp.pelicula.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.softulp.pelicula.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        String titulo = getIntent().getStringExtra("TITULO");
        String descripcion = getIntent().getStringExtra("DESCRIPCION");
        int foto = getIntent().getIntExtra("FOTO", 0); // 0 es un valor por defecto
        String director = getIntent().getStringExtra("DIRECTOR");
        String[] actores = getIntent().getStringArrayExtra("ACTORES");

        // Encuentra las vistas por ID y les asigna los datos

        TextView titulo = findViewById(R.id.)

        // Concatena los nombres de los actores para mostrarlos
        StringBuilder actoresStr = new StringBuilder();
        for (String actor : actores) {
            actoresStr.append(actor).append("\n");
        }
        ((TextView) findViewById(R.id.actores_detalle)).setText(actoresStr.toString());
    }
}