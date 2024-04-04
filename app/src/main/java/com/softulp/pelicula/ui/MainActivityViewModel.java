package com.softulp.pelicula.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.pelicula.R;
import com.softulp.pelicula.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pelicula>>listaMutable;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Pelicula>>getListaMutable(){
        if(listaMutable == null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void crearLista(){
        ArrayList<Pelicula>lista = new ArrayList<>();
        lista.add(new Pelicula(
                "Terminator",
                "En 1984, un soldado humano es enviado desde 2029 para proteger a Sarah Connor. Al mismo tiempo, un asesino androide es enviado para eliminarla.",
                R.drawable.pelicula1,
                "James Cameron",
                new String[]{"Arnold Schwarzenegger", "Linda Hamilton"}
        ));

        lista.add(new Pelicula(
                "Rocky II",
                "Rocky Balboa lucha en una revancha con el campeón Apollo Creed, para probar que su primera pelea fue solo una casualidad.",
                R.drawable.pelicula2,
                "Sylvester Stallone",
                new String[]{"Sylvester Stallone", "Talia Shire"}
        ));

        lista.add(new Pelicula(
                "El lobo de Wall Street",
                "Basada en la historia real de Jordan Belfort, desde su ascenso a una vida rica como corredor de bolsa que vive la alta vida hasta su caída que involucra crimen, corrupción y el gobierno federal.",
                R.drawable.pelicula3,
                "Martin Scorsese",
                new String[]{"Leonardo DiCaprio", "Jonah Hill"}
        ));
        listaMutable.setValue(lista);
    }
}
