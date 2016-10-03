package com.example.andresperez.ejemplomanifest;



import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.andresperez.ejemplomanifest.OtroFragment.*;

public class MainActivity extends AppCompatActivity implements EjemploFragment.OnFragmentInteractionListener, OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void changeFragment(View view) {
        //Paso 1: Obtener la instancia del administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager();

        //Paso 2: Crear una nueva transacción
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(currentFragmentIsEjemploFragment()){
            //Paso 3: Crear un nuevo fragmento y reemplazarlo
            OtroFragment fragment = new OtroFragment();
            transaction.replace(R.id.containerFragment, fragment);
            transaction.addToBackStack("other_fragment");
        }else{
            //Paso 3: Crear un nuevo fragmento y reemplazarlo
            EjemploFragment fragment = new EjemploFragment();
            transaction.replace(R.id.containerFragment, fragment);
            transaction.addToBackStack("ejemplo_fragment");
        }

        //Paso 4: Confirmar el cambio
        transaction.commit();
    }

    private  boolean currentFragmentIsEjemploFragment(){
        Fragment currentFragment = getFragmentManager().findFragmentById(R.id.containerFragment);
        if(currentFragment != null){
            if (!currentFragment.getClass().getName().equalsIgnoreCase(EjemploFragment.class.getName())) {
                //El actual fragment no coincide con EjemploFragment
                return false;
            } else {
                //El actual fragment  coincide con EjemploFragment
                return true;
            }
        }
        return false;
    }
}
