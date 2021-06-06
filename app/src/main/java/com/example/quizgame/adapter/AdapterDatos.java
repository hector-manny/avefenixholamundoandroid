package com.example.quizgame.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizgame.R;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    //En este caso, la fuente de datos que espera recibir el adaptador
    // es solo un arreglo de objetos String.
   // Pero esta fuente de datos puede ser más compleja, según se requiera.
    ArrayList<String> listDatos;

    public AdapterDatos(ArrayList<String> listDato) {
        this.listDatos = listDato;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null, false);
        return new ViewHolderDatos(view);
    }

    // Este método asigna valores para cada elemento de la lista
    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido usando tales datos
        holder.asignarDatos(listDatos.get(position));
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        // en este ejemplo cada elemento consta solo de un título
        TextView dato;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String pdato) {
            dato.setText(pdato);
        }
    }

}
