package com.softulp.pelicula.ui;

import android.os.Bundle;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.pelicula.R;
import com.softulp.pelicula.databinding.ActivityMainBinding;
import com.softulp.pelicula.modelo.Pelicula;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getListaMutable().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                RecyclerView rv = findViewById(R.id.rvPeliculas);
                GridLayoutManager glm = new GridLayoutManager(MainActivity.this, 2, GridLayoutManager.HORIZONTAL, false);
                rv.setLayoutManager(glm);
                PeliculaAdapter peliculaAdapter = new PeliculaAdapter(peliculas, MainActivity.this, getLayoutInflater());
                rv.setAdapter(peliculaAdapter);
            }
        });
        mv.crearLista();
}}