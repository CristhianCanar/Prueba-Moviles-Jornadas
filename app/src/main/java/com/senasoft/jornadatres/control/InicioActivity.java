package com.senasoft.jornadatres.control;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.senasoft.jornadatres.R;
import com.senasoft.jornadatres.model.AdapterItemImpVeh;
import com.senasoft.jornadatres.model.AdapterItemSoap;
import com.senasoft.jornadatres.model.AdapterItemTecno;
import com.senasoft.jornadatres.model.ManagerHelper;
import com.senasoft.jornadatres.model.Services;
import com.senasoft.jornadatres.model.Vehicle;
import com.senasoft.jornadatres.model.Vehiculo;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView lvLista1, lvLista2, lvLista3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        referent();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mostrarServicios();
    }

    private void referent() {

        lvLista1 = findViewById(R.id.lvListaServ1);
        lvLista2 = findViewById(R.id.lvListaServ2);
        lvLista3 = findViewById(R.id.lvListaServ3);
    }

    private void mostrarServicios() {

        try {

            ManagerHelper managerHelper = new ManagerHelper(getApplicationContext());

            ArrayList<Services> services = new ArrayList<>(managerHelper.listServices());

            if (services.get(0).getServ1() == 0) {

                AdapterItemSoap adapterItemSoap;

                ArrayList<Vehicle> list = new ArrayList<>(managerHelper.listVehiculo());

                adapterItemSoap = new AdapterItemSoap(getApplicationContext(), list);

                lvLista1.setAdapter(adapterItemSoap);

            }

            if (services.get(0).getServ2() == 0) {

                ArrayList<Vehicle> list = new ArrayList<>(managerHelper.listVehiculo());

                AdapterItemTecno adapterItemTecno = new AdapterItemTecno(getApplicationContext(), list);

                lvLista2.setAdapter(adapterItemTecno);
            }

            if (services.get(0).getServ3() == 0) {

                ArrayList<Vehicle> list = new ArrayList<>(managerHelper.listVehiculo());

                AdapterItemImpVeh adapter = new AdapterItemImpVeh(getApplicationContext(), list);

                lvLista3.setAdapter(adapter);

            }

            if (services.get(0).getServ4() == 0) {

            }
        }catch (Exception e){
            e.printStackTrace();
        }


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
        getMenuInflater().inflate(R.menu.inicio, menu);
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
            Toast.makeText(this, "Empresa dedicada a la implementacion de software", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Intent intent;

        int id = item.getItemId();

        if (id == R.id.nav_Inicio) {
            intent = new Intent(InicioActivity.this, InicioActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_RegAutos) {
            intent = new Intent(InicioActivity.this, RegistroAutosActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_Servicios) {
            intent = new Intent(InicioActivity.this, ServiciosActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_MiPerfil) {
            intent = new Intent(InicioActivity.this, PerfilActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_AcercaDe) {
            Toast.makeText(this, "Empresa dedicada a la implementacion de software", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_Salir) {
            System.exit(0);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
