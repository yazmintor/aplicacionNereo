package com.example.ricki.neroactualizado;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import static com.example.ricki.neroactualizado.R.layout.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

// se declaran los drawerLayaout con su repectivo id 

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
// se declara la navegacion entre las vistas que hace q se despliege la lista
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
            // un progreso que hace se deslice la lista con  la informacion que trae
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// se crean las opciones del menu
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// selecciona la opcion  del item
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
// se muestra la seleccion del item en la lista  y llama cada fragment al precionarle encima de cada item
        int id = item.getItemId();

        if (id == R.id.nav_primero) {

          FirstFragment firstFragment=new FirstFragment();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.conten,firstFragment).commit();

        } else if (id == R.id.nav_segundo) {
            SecondFragment secondFragment = new SecondFragment();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.conten,secondFragment).commit();

        } else if (id == R.id.nav_tercero) {

            ThirdFragment thirdFragment = new ThirdFragment();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.conten,thirdFragment).commit();

        } else if (id == R.id.nav_notas) {

            NotasFragment notasFragment = new NotasFragment();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.conten, notasFragment).commit();

        } else {
            if (id == R.id.nav_stream) {

                StreamFragment streamFragment = new StreamFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.conten, streamFragment).commit();


            }
        }
// esconde  la lista despues de seleccionado el  item 
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
