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
import com.senasoft.jornadatres.model.Constantes;
import com.senasoft.jornadatres.model.ManagerHelper;
import com.senasoft.jornadatres.model.Services;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class ServiciosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    Switch swServ1, swServ2,swServ3,swSrev4;
    boolean estadoSwitch=false;

    private ManagerHelper managerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //todo referenciacion elementos de Servicios

        swServ1 = findViewById(R.id.swServ1);
        swServ2 = findViewById(R.id.swServ2);
        swServ3 = findViewById(R.id.swServ3);
        swSrev4 = findViewById(R.id.swSrev4);



        swServ1.setChecked(false);
        swServ2.setChecked(false);
        swServ3.setChecked(false);
        swSrev4.setChecked(false);

    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean resultado) {
        switch (compoundButton.getId()){
            case R.id.swServ1:
                if (resultado==true){
                    activarServicio(1, Constantes.NAME_COLUMN_11, 1);
                }
                break;

            case R.id.swServ2:
                activarServicio(1, Constantes.NAME_COLUMN_12, 1);
                break;

            case R.id.swServ3:
                if (resultado==true){
                    activarServicio(1, Constantes.NAME_COLUMN_13, 1);
                }
                break;

            case R.id.swSrev4:
                if (resultado==true){
                    activarServicio(1, Constantes.NAME_COLUMN_14, 1);
                }
                break;
        }

    }


    public void activarServicio(int id, String column, int value){

        long update = managerHelper.updateService(id, column, value);

        if (update > 0) Toast.makeText(this, "Se han actualizado el servicio", Toast.LENGTH_SHORT).show();
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
        getMenuInflater().inflate(R.menu.servicios, menu);
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
            System.exit(0);
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
