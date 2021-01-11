package com.miguel_lm.penha_celta.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.miguel_lm.penha_celta.R;
import com.miguel_lm.penha_celta.modelo.Socio;

public class ActivityListaMiembros extends AppCompatActivity implements SeleccionarMiembro {

    private AdapterMiembros adapterMiembros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_miembros);

        RecyclerView recyclerViewEntrenamientos = findViewById(R.id.recyclerViewMiembros);
        recyclerViewEntrenamientos.setLayoutManager(new LinearLayoutManager(this));
        adapterMiembros = new AdapterMiembros(this, this);
        recyclerViewEntrenamientos.setAdapter(adapterMiembros);
    }

    @Override
    public void eliminarMiembro(Socio socio) {

    }

    @Override
    public void modificarMiembro(Socio socio) {

    }
}