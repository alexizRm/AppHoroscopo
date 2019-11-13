package com.alexis.rios.apphoroscopo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button button_continuar;
    EditText nombre, numeroCuenta, email, fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();

        button_continuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               boolean error = false;
               String textoNombre = nombre.getText().toString();
               String textoNumeroCuenta = numeroCuenta.getText().toString();
               String textoFecha = fecha.getText().toString();
               String textoEmail = email.getText().toString();

               if (!validarNombre(textoNombre)) {
                   Toast mensaje = Toast.makeText(getApplicationContext(), "Error en el nombre",
                           Toast.LENGTH_LONG);
                    mensaje.show();
                   error = true;
               }
               if (!validarNumeroCuenta(textoNumeroCuenta)) {
                   Toast mensaje = Toast.makeText(getApplicationContext(), "Error en el número de cuenta",
                            Toast.LENGTH_LONG);
                   mensaje.show();
                   error = true;
               }
               if (!validarEmail(textoEmail)) {
                   error = true;
                   Toast mensaje = Toast.makeText(getApplicationContext(), "Error en el email",
                            Toast.LENGTH_LONG);
                   mensaje.show();
               }
               if (!validarFecha(textoFecha)) {
                   error = true;
                   Toast mensaje = Toast.makeText(getApplicationContext(), "Error en la fecha",
                            Toast.LENGTH_LONG);
                   mensaje.show();
               }

               if (!error) {
                   Intent intent = new Intent(getApplicationContext(), HoroscopoView.class);
                   intent.putExtra("nombre", textoNombre);
                   intent.putExtra("fecha", textoFecha);
                   startActivity(intent);

               }
            }

        });
    }

    private boolean validarNombre(String nombre) {
        if (TextUtils.isEmpty(nombre)) {
            return false;
        }
        Pattern p = Pattern.compile("^[A-Za-z\\s]+$*");
        Matcher m = p.matcher(nombre);
        return m.matches();
    }

    private boolean validarNumeroCuenta(String numeroCuenta) {
        if (TextUtils.isEmpty(numeroCuenta)) {
            return false;
        }
        Pattern p = Pattern.compile("[0-9]{9}");
        Matcher m = p.matcher(numeroCuenta);
        return m.matches();
    }

    private boolean validarFecha(String fecha) {
        if (TextUtils.isEmpty(fecha)) {
            return false;
        }
        Pattern p = Pattern.compile("[0-31]/[0-12]/[1-2][0-9]{3}");
        Matcher m = p.matcher(fecha);
        return m.matches();
    }

    private boolean validarEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void inicializarComponentes() {
        button_continuar = findViewById(R.id.registrar_button_continuar);
        nombre = findViewById(R.id.registro_nombre);
        numeroCuenta = findViewById(R.id.registro_numero_cuenta);
        email = findViewById(R.id.registro_email);
        fecha = findViewById(R.id.registro_fecha);
    }
}
