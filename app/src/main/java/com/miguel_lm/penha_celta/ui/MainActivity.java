package com.miguel_lm.penha_celta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.miguel_lm.penha_celta.R;

public class MainActivity extends AppCompatActivity {

    private long tiempoParaSalir = 0;
    Button bt_registrar,bt_acceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_teixugos);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        bt_registrar = findViewById(R.id.btn_registrar);
        bt_acceder = findViewById(R.id.btn_acceder);
    }

    public void OnClickRegistrar(View view){

        Intent intent = new Intent(MainActivity.this, Registro_Firbase.class);
        startActivity(intent);
        finish();
    }

    public void OnClickAcceder(View view){

        Intent intent = new Intent(MainActivity.this, ActivityFirst.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.accionAnhadirNuevo) {
            //accionNuevoMiembro(null);
        } else if (item.getItemId() == R.id.accionUltimasNoticias) {
            //accionUltimasNoticias();
        } else if (item.getItemId() == R.id.accionModificar) {
            //accionModificarDatos();
        } else if (item.getItemId() == R.id.accionEliminar) {
            //accionEliminarMiembro();
        } else if (item.getItemId() == R.id.accionDatosPersonales) {
            //accionDatosPersonales();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){

        long tiempo = System.currentTimeMillis();
        if (tiempo - tiempoParaSalir > 3000) {
            tiempoParaSalir = tiempo;
            Toast.makeText(this, "Presione de nuevo 'Atrás' si desea salir",
                    Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}