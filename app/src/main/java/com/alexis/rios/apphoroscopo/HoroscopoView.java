package com.alexis.rios.apphoroscopo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class HoroscopoView extends AppCompatActivity {
    TextView edad, usuario, signo;
    ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscopo_view);
        inicializar();
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String fecha = intent.getStringExtra("fecha");
        int anioUsuario = obtenerAnio(fecha);
        int anioActual = obtenerAnioActual();
        int edadUsuario = anioActual - anioUsuario;
        String textoSigno = "N/A";
        int resto = anioUsuario % 12;
        switch (resto) {
            case 0:
                textoSigno = "El Mono";
                imagen.setImageResource(R.mipmap.mono);
                break;
            case 1:
                textoSigno = "El Gallo";
                imagen.setImageResource(R.mipmap.gallo);
                break;
            case 2:
                textoSigno = "El Perro";
                imagen.setImageResource(R.mipmap.perro);
                break;
            case 3:
                textoSigno = "El Cerdo";
                imagen.setImageResource(R.mipmap.cerdo);
                break;
            case 4:
                textoSigno = "La Rata";
                imagen.setImageResource(R.mipmap.rata);
                break;
            case 5:
                textoSigno = "El Buey";
                imagen.setImageResource(R.mipmap.buey);
                break;
            case 6:
                textoSigno = "El Tigre";
                imagen.setImageResource(R.mipmap.tigre);
                break;
            case 7:
                textoSigno = "El Conejo";
                imagen.setImageResource(R.mipmap.conejo);
                break;
            case 8:
                textoSigno = "El Dragón";
                imagen.setImageResource(R.mipmap.dragon);
                break;
            case 9:
                textoSigno = "La Serpiente";
                imagen.setImageResource(R.mipmap.serpiente);
                break;
            case 10:
                textoSigno = "El Caballo";
                imagen.setImageResource(R.mipmap.caballo);
                break;
            case 11:
                textoSigno = "La Cabra";
                imagen.setImageResource(R.mipmap.cabra);
                break;
        }
        usuario.setText("Hola " + nombre);
        edad.setText("Tu edad es: " + edadUsuario);
        signo.setText("Tu signo es: " + textoSigno);
    }

    private int obtenerAnioActual() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String[] fecha = dateFormat.format(date).split("/");
        return Integer.parseInt(fecha[0]);
    }

    private int obtenerAnio(String fecha) {
        String[] datos = fecha.split("/");
        return Integer.parseInt(datos[2]);
    }

    private void inicializar (){
        edad = findViewById(R.id.horoscopo_edad);
        usuario = findViewById(R.id.horoscopo_usuario);
        signo = findViewById(R.id.horoscopo_signo);
        imagen = findViewById(R.id.horoscopo_imagen);
    }
}
