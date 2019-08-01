package com.senasoft.jornadatres.control;

import android.app.DatePickerDialog;
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
import com.senasoft.jornadatres.model.ManagerHelper;
import com.senasoft.jornadatres.model.Person;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PerfilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText etNombrePerfil, etFechaNaciminetoPerfil, etCorreoPerfil, etFechaVencLicPerfil;
    Button btnGuardarPerfil;

    private static final String CERO = "0";
    private static final String BARRA = "/";

    public final Calendar c = Calendar.getInstance();

    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        //todo referenciación
        etNombrePerfil = findViewById(R.id.editNombrePerfil);
        etFechaNaciminetoPerfil = findViewById(R.id.editFechaNaciminetoPerfil);
        etCorreoPerfil = findViewById(R.id.editCorreoPerfil);
        etFechaVencLicPerfil = findViewById(R.id.editFechaVencLicPerfil);


        btnGuardarPerfil = findViewById(R.id.btnGuardarPerfil);
        btnGuardarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    insertReg();

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        etFechaNaciminetoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obetenerFechaNacimiento();
            }
        });

        etFechaVencLicPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obetenerFechaVencimiento();
            }
        });

    }

    private void insertReg() throws ParseException {

        Date date;

        ManagerHelper managerHelper = new ManagerHelper(getApplicationContext());

        Person person = new Person();

        person.setNombrePerson(etNombrePerfil.getText().toString());
        person.setFechaNacPerson(date = new SimpleDateFormat("dd/mm/yy").parse(etFechaNaciminetoPerfil.getText().toString()));
        person.setCorreoPerson(etCorreoPerfil.getText().toString());
        person.setFechaVencLicencia(date = new SimpleDateFormat("dd/mm/yy").parse(etFechaVencLicPerfil.getText().toString()));

        long insert = managerHelper.insertPerson(person);

        if (insert < 0) {Toast.makeText(this, "No se inserto el dato", Toast.LENGTH_SHORT).show();}
        else {
            Toast.makeText(this, "Se inserto el dato", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), InicioActivity.class);
            startActivity(intent);
            finish();
        }


    }

    public void obetenerFechaNacimiento(){

        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                final int mesActual = i1 + 1;

                 String diaFormateado = (i2 < 10)? CERO + String.valueOf(i2):String.valueOf(i2);

                 String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);

                 etFechaNaciminetoPerfil.setText(diaFormateado + BARRA + mesFormateado + BARRA + i);

            }
        }, anio, mes, dia);

        recogerFecha.show();

    }

    public void obetenerFechaVencimiento(){

        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                final int mesActual = i1 + 1;

                String diaFormateado = (i2 < 10)? CERO + String.valueOf(i2):String.valueOf(i2);

                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);

                etFechaVencLicPerfil.setText(diaFormateado + BARRA + mesFormateado + BARRA + i);

            }
        }, anio, mes, dia);

        recogerFecha.show();

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
