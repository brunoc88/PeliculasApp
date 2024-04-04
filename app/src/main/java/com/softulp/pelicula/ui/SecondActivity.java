package com.softulp.pelicula.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.softulp.pelicula.R;
import com.softulp.pelicula.modelo.Pelicula;

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



        TextView tvTitulo = findViewById(R.id.tvDetalleTitulo);
        ImageView ivFoto = findViewById(R.id.ivFotoPelicula);
        TextView tvDirector = findViewById(R.id.tvDetalleDirector);
        TextView tvActores = findViewById(R.id.tvListaActores);
        TextView tvResenia = findViewById(R.id.datosPeli);

        tvTitulo.setText(titulo);
        //ivFoto.setImageResource(foto);
        tvDirector.setText(director);




        StringBuilder actoresStr = new StringBuilder();
        for (String actor : actores) {
            actoresStr.append(actor).append("\n");
        }
        ((TextView) findViewById(R.id.tvListaActores)).setText(actoresStr.toString());

        tvResenia.setText(descripcion);

        Button volver = findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}