package com.senasoft.jornadatres.control;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.senasoft.jornadatres.R;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroAutosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText etPlacaReg,etCiudadReg,etModeloReg,etFechaSoatReg;
    Spinner spMarcaReg, spColorReg;
    Button btnGuardarAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_autos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //todo referenciacion elementos Registro

        etPlacaReg = findViewById(R.id.editPlacaReg);
        etCiudadReg = findViewById(R.id.editCiudadReg);
        etFechaSoatReg = findViewById(R.id.editFechaSoatReg);
        etModeloReg = findViewById(R.id.editModeloReg);
        spColorReg = findViewById(R.id.spColorReg);
        spMarcaReg = findViewById(R.id.spMarcaReg);

        btnGuardarAuto = findViewById(R.id.btnGuardarAuto);
        btnGuardarAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AGREGAR FUNCIONALIDAD
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.registro_autos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent;

        if (id == R.id.nav_Inicio) {
            intent = new Intent(getApplicationContext(), InicioActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_RegAutos) {
            intent = new Intent(getApplicationContext(), RegistroAutosActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_Servicios) {
            intent = new Intent(getApplicationContext(), ServiciosActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_MiPerfil) {
            intent = new Intent(getApplicationContext(), PerfilActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_AcercaDe) {
            Toast.makeText(this, "Empresa dedicada a la implementacion de software", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_Salir){

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
