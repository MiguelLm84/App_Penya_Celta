package com.miguel_lm.penha_celta.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.miguel_lm.penha_celta.R;
import com.miguel_lm.penha_celta.modelo.Socio;

import java.util.List;

public class AdapterMiembros extends RecyclerView.Adapter<ViewHolderMiembros> {

    private List<Socio> listaMiembros;
    private final Context context;
    private final SeleccionarMiembro seleccionarMiembros;

    public AdapterMiembros(Context context, SeleccionarMiembro seleccionarMiembros) {
        //this.listaMiembros;
        this.context = context;
        this.seleccionarMiembros = seleccionarMiembros;
    }

    @NonNull
    @Override
    public ViewHolderMiembros onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_socio, parent, false);
        return new ViewHolderMiembros(v, seleccionarMiembros);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMiembros holder, int position) {
        Socio socioAmostrar = listaMiembros.get(position);
        holder.mostrarMiembro(socioAmostrar,context);
    }

    @Override
    public int getItemCount() {
        return listaMiembros.size();
    }
}
