package com.softulp.pelicula.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.pelicula.R;
import com.softulp.pelicula.modelo.Pelicula;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {
    private List<Pelicula> peliculas;
    private Context context;
    private LayoutInflater li;

    public PeliculaAdapter(List<Pelicula> peliculas, Context context, LayoutInflater li) {
        this.peliculas = peliculas;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(peliculas.get(position).getTitulo());
        holder.foto.setImageResource(peliculas.get(position).getFoto());
        holder.resenia.setText(peliculas.get(position).getDescripcion());
        holder.detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                Pelicula peliculaSeleccionada = peliculas.get(holder.getAdapterPosition());

                intent.putExtra("TITULO", peliculaSeleccionada.getTitulo());
                intent.putExtra("DESCRIPCION", peliculaSeleccionada.getDescripcion());
                intent.putExtra("FOTO", peliculaSeleccionada.getFoto());
                intent.putExtra("DIRECTOR", peliculaSeleccionada.getDirector());
                intent.putExtra("ACTORES", peliculaSeleccionada.getActores());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titulo;
        private TextView resenia;
        private ImageView foto;
        private Button detalles;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvTitulo);
            resenia = itemView.findViewById(R.id.tvResenia);
            foto = itemView.findViewById(R.id.ivFoto);
            detalles = itemView.findViewById(R.id.btDetalles);
        }
    }
}
