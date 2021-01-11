package com.miguel_lm.penha_celta.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.miguel_lm.penha_celta.R;

import java.util.HashMap;
import java.util.Map;

public class Registro_Firbase extends AppCompatActivity {

    EditText ed_nombre;
    EditText ed_email;
    EditText ed_password;
    Button btn_cancelar;
    Button btn_registrar;

    String nombre = "";
    String email = "";
    String password = "";

    private long tiempoParaSalir = 0;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__firbase);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.teixugos_celestes_round);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        ed_nombre = findViewById(R.id.ed_nom);
        ed_email = findViewById(R.id.ed_email_registro);
        ed_password = findViewById(R.id.ed_PasswordRegistro);
        btn_cancelar = findViewById(R.id.bt_cancelar);
        btn_registrar = findViewById(R.id.bt_registrar2);

        btn_cancelar.setOnClickListener(v -> {

        });

        btn_registrar.setOnClickListener(v -> {
            nombre = ed_nombre.getText().toString();
            email = ed_email.getText().toString();
            password = ed_password.getText().toString();

            if(!nombre.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                if(password.length()>=6){
                    progressDialog = new ProgressDialog(this);
                    registrarUsuario();
                } else {
                    Toast.makeText(Registro_Firbase.this,"El password debe tener al menos 6 caracteres",Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Registro_Firbase.this,"Debe completar los campos",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*@Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(Registro_Firbase.this, ActivityCerrarSesion.class));
            finish();
        }
    }*/

    private void registrarUsuario(){

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){

                Map<String, Object> map = new HashMap<>();
                map.put("nombre",nombre);
                map.put("email",email);
                map.put("password",password);
                String id = mAuth.getCurrentUser().getUid();
                mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(task2 -> {
                    if(task2.isSuccessful()){
                        startActivity(new Intent(Registro_Firbase.this, ActivityPerfil.class));
                        finish();
                    } else {
                        Toast.makeText(Registro_Firbase.this,"Error, los datos no se han podido crear correctamente",Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                Toast.makeText(Registro_Firbase.this,"Error, no se pudo registrar este usuario",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*@Override
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
    }*/

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}