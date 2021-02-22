package com.matscode.formulariomiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    TextView tvNombre, tvFechaNac, tvTelefono, tvEmail, tvDescripcion;
    Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        /*Bundle parametros = getIntent().getExtras();
        int dia = parametros.getInt("dia");
        int mes = parametros.getInt("mes");
        int año = parametros.getInt("año");
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");

        etNombre.setText(nombre);
        etTelefono.setText(telefono);
        etEmail.setText(email);
        etDescripcion.setText(descripcion);
        dpCalendario.updateDate(año, mes, dia);*/

        Bundle parametros = getIntent().getExtras();
        int dia = parametros.getInt("dia");
        int mes = parametros.getInt("mes");
        int año = parametros.getInt("año");
        String FechaDeNacimiento = dia + "/" + mes + "/" + año;
        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNac = (TextView) findViewById(R.id.tvFechaNac);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        boton2 = (Button) findViewById(R.id.boton2);

        tvNombre.setText(nombre);
        tvFechaNac.setText(FechaDeNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Actividad2.this, MainActivity.class);
                intent.putExtra("dia", dia);
                intent.putExtra("mes", mes);
                intent.putExtra("año", año);
                intent.putExtra("nombre", nombre);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                startActivity(intent);
            }
        });
    }
}