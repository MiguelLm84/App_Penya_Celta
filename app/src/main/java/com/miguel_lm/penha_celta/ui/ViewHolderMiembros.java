package com.miguel_lm.penha_celta.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.miguel_lm.penha_celta.R;
import com.miguel_lm.penha_celta.modelo.Socio;

public class ViewHolderMiembros extends RecyclerView.ViewHolder {

    private TextView tv_nombre,tv_ap1,tv_ap2,tv_numSocio;
    //private final LinearLayout linearLayoutItemMiembro;
    private SeleccionarMiembro seleccionarMiembro;

    public ViewHolderMiembros(@NonNull View itemView,SeleccionarMiembro seleccionarMiembro) {
        super(itemView);
        this.seleccionarMiembro = seleccionarMiembro;

        tv_nombre = itemView.findViewById(R.id.tv_nom_item);
        tv_ap1 = itemView.findViewById(R.id.tv_ap1_item);
        tv_ap2 = itemView.findViewById(R.id.tv_ap2_item);
        tv_numSocio = itemView.findViewById(R.id.tv_num_socio);
        //linearLayoutItemMiembro = itemView.findViewById(R.id.linearLayoutItemMiembro);
    }

    public void mostrarMiembro(final Socio socio, final Context context) {
        tv_nombre.setText(socio.getNombre());
        tv_ap1.setText(socio.getApellido1());
        tv_ap2.setText(socio.getApellido2());
        tv_numSocio.setText(socio.getNumSocio());
    }
}
