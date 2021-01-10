package com.miguel_lm.penha_celta.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.miguel_lm.penha_celta.R;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityNavigationDrawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        ImageButton btn_perfil = findViewById(R.id.btn_perfil);

        btn_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityNavigationDrawer.this, PerfilActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_navigation_drawer, menu);
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
        Intent intent = new Intent(ActivityNavigationDrawer.this, Registro_Firbase.class);
        startActivity(intent);
        finish();
    }

    public void accionUltimasNoticias(){
        Intent intent = new Intent(ActivityNavigationDrawer.this, ActivityNoticias.class);
        startActivity(intent);
        finish();
    }

    public void accionModificarDatos(){
        /*Intent intent = new Intent(ActivityNavigationDrawer.this, ActivityNavigationDrawer.class);
        startActivity(intent);
        finish();*/
    }

    public void accionEliminarMiembro(){
        /*Intent intent = new Intent(ActivityNavigationDrawer.this, ActivityNavigationDrawer.class);
        startActivity(intent);
        finish();*/
    }

    public void accionDatosPersonales(){
        Intent intent = new Intent(ActivityNavigationDrawer.this, ActivityPerfil.class);
        startActivity(intent);
        finish();
    }

    public void accionCerrarSesion(){
        Intent intent = new Intent(ActivityNavigationDrawer.this, ActivityCerrarSesion.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}