package com.miguel_lm.penha_celta.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.miguel_lm.penha_celta.R;

public class MainActivity extends AppCompatActivity {

    private long tiempoParaSalir = 0;
    EditText ed_email,ed_password;
    Button bt_registrar,bt_acceder;
    String email = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.teixugos_celestes_round);

        ed_email = findViewById(R.id.tv_email_cerrara_sesion);
        ed_password = findViewById(R.id.ed_Password);
        bt_registrar = findViewById(R.id.btn_cerrar_sesion);
        bt_acceder = findViewById(R.id.btn_acceder);
    }

    public void OnClickRegistrar(View view){

        Intent intent = new Intent(MainActivity.this, Registro_Firbase.class);
        startActivity(intent);
        finish();
    }

    public void OnClickAcceder(View view){

        email = ed_email.getText().toString();
        password = ed_password.getText().toString();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String emailUser = user.getEmail();
            String passwordUser = user.getDisplayName();
            //Uri photoUrl = user.getPhotoUrl();

            boolean emailVerified = user.isEmailVerified();
            //String uid = user.getUid();

            if(!email.isEmpty() && !password.isEmpty() || email.equals(emailUser) && password.equals(passwordUser)){
                Intent intent = new Intent(MainActivity.this, ActivityNavigationDrawer.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "El email o la contraseña no es correcta",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Fragment fragmentMenu = null;
        //boolean fragmentSeleccionado = false;

        if (item.getItemId() == R.id.accionAnhadirNuevo) {
            accionNuevoMiembro();

            //fragmentMenu = new FragmentAdd();
            //fragmentSeleccionado = true;

        } else if (item.getItemId() == R.id.accionUltimasNoticias) {
            accionUltimasNoticias();

            //fragmentMenu = new FragmentNoticias();
            //fragmentSeleccionado = true;

        } else if (item.getItemId() == R.id.accionModificar) {
            accionModificarDatos();

            //fragmentMenu = new FragmentModificar();
            //fragmentSeleccionado = true;

        } else if (item.getItemId() == R.id.accionEliminar) {
            accionEliminarMiembro();

            //fragmentMenu = new FragmentEliminar();
            //fragmentSeleccionado = true;

        } else if (item.getItemId() == R.id.accionDatosPersonales) {
            accionDatosPersonales();

            /*fragmentMenu = new FragmentDatosPersonales();
            fragmentSeleccionado = true;*/

        } else if (item.getItemId() == R.id.accionCerrarSesion) {
            accionCerrarSesion();

            //fragmentMenu = new FragmentCerrarSesion();
            //fragmentSeleccionado = true;
        }

        /*if(fragmentSeleccionado = true){
            getSupportFragmentManager().beginTransaction().add(R.id.ContenedorFragments,fragmentMenu).commit();
        }*/

        return super.onOptionsItemSelected(item);
    }

    public void accionNuevoMiembro(){
        Intent intent = new Intent(MainActivity.this, Registro_Firbase.class);
        startActivity(intent);
        finish();
    }

    public void accionUltimasNoticias(){
        Intent intent = new Intent(MainActivity.this, ActivityNavigationDrawer.class);
        startActivity(intent);
        finish();
    }

    public void accionModificarDatos(){
        /*Intent intent = new Intent(MainActivity.this, ActivityNavigationDrawer.class);
        startActivity(intent);
        finish();*/
    }

    public void accionEliminarMiembro(){
        /*Intent intent = new Intent(MainActivity.this, ActivityNavigationDrawer.class);
        startActivity(intent);
        finish();*/
    }

    public void accionDatosPersonales(){
        Intent intent = new Intent(MainActivity.this, ActivityPerfil.class);
        startActivity(intent);
        finish();
    }

    public void accionCerrarSesion(){
        Intent intent = new Intent(MainActivity.this, ActivityCerrarSesion.class);
        startActivity(intent);
        finish();
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