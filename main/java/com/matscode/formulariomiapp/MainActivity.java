package com.matscode.formulariomiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button botonSiguiente;
    TextInputEditText etNombre, etTelefono, etEmail, etDescripcion;
    DatePicker dpCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonSiguiente = (Button) findViewById(R.id.btnBoton);
        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etTelefono = (TextInputEditText) findViewById(R.id.etTelefono);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etDescripcion = (TextInputEditText) findViewById(R.id.etDescripcion);
        dpCalendario = (DatePicker) findViewById(R.id.dpCalendario);

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, telefono, email, descripcion;
                int dia, mes, año;

                nombre = etNombre.getText().toString();
                telefono = etTelefono.getText().toString();
                email = etEmail.getText().toString();
                descripcion = etDescripcion.getText().toString();

                if (nombre.isEmpty() || telefono.isEmpty() || email.isEmpty() || descripcion.isEmpty()){
                    Snackbar.make(v, "Rellene todos los campos",Snackbar.LENGTH_SHORT)
                            .setTextColor(getResources().getColor(R.color.design_default_color_secondary))
                            .show();
                } else {
                    dia = dpCalendario.getDayOfMonth();
                    mes = dpCalendario.getMonth();
                    año = dpCalendario.getYear();

                    Intent intent = new Intent(MainActivity.this, Actividad2.class);
                    intent.putExtra("dia", dia);
                    intent.putExtra("mes", mes);
                    intent.putExtra("año", año);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("telefono", telefono);
                    intent.putExtra("email", email);
                    intent.putExtra("descripcion", descripcion);
                    startActivity(intent);
                }
            }
        });
    }
}