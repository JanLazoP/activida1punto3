package com.novita.activida1punto3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();

        //vincular la vista con el objeto
        ImageView imagen=(ImageView)findViewById(R.id.imageView);


        registerForContextMenu(imagen);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        //metodo que ejecutara el codigo que contiene a la hora de presionar el boton
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Imagen guardada en favoritos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //al mantener pulsada la vista el sistema llamara al este metodo y tomara el recurso "contextual" para agrandar el menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextual,menu);
    }

    //el metodo decidira que hacer en caso de que un item haya sido seleccionado, esto mediante el itemID.
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.descarga:
                Toast.makeText(this,"Imagen guardada",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.copia:
                Toast.makeText(this,"Enlace copiado en el portapapeles",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
