package com.miguel_lm.penha_celta.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.miguel_lm.penha_celta.R;

public class PerfilActivity extends AppCompatActivity {

    ImageButton btn_editar;
    Button btn_aceptar;
    ImageView imagenPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.teixugos_celestes_round);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        btn_editar = findViewById(R.id.btn_editar);
        btn_aceptar = findViewById(R.id.btn_aceptar);
        imagenPerfil = findViewById(R.id.imageView_fotoSocio);

        imagenPerfil.setOnClickListener(v -> imagenPerfil.setImageResource(R.mipmap.nueva_imagen_perfil));

        btn_editar.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilActivity.this, EditarActivity.class);
            startActivity(intent);
            finish();
        });

        btn_aceptar.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilActivity.this, ActivityNavigationDrawer.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ActivityNavigationDrawer.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}