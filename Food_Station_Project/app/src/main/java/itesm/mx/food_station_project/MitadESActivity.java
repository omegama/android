package itesm.mx.food_station_project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MitadESActivity extends DialogFragment implements View.OnClickListener {

        RadioButton quesoP, quesoM, pollo, surimi, atun, jamon, salchicha, crutones, frituras, cSandwich;
        CheckBox pepino, zana, acei, manz, pimi, jito, champi, jica, alfalfa, elote, nuez, aran;
        Button cancel, add;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.activity_mitad_es, null);


        quesoP= (RadioButton)view.findViewById(R.id.radioPanela);
        quesoM = (RadioButton)view.findViewById(R.id.radioManchego);
        pollo = (RadioButton)view.findViewById(R.id.radioPollo);
        surimi= (RadioButton)view.findViewById(R.id.radioSurimi);
        atun= (RadioButton)view.findViewById(R.id.radioAtun);
        jamon= (RadioButton)view.findViewById(R.id.radioJamon);
        salchicha= (RadioButton)view.findViewById(R.id.radioSalchicha);
        crutones= (RadioButton)view.findViewById(R.id.radioCrutonMitad);
        frituras= (RadioButton)view.findViewById(R.id.radioFrituraMitad);

        pepino = (CheckBox)view.findViewById(R.id.checkPep);
        zana = (CheckBox)view.findViewById(R.id.checkZanaoria);
        acei = (CheckBox)view.findViewById(R.id.checkAcei);
        manz = (CheckBox)view.findViewById(R.id.checkManza);
        pimi = (CheckBox)view.findViewById(R.id.checkPim);
        jito = (CheckBox)view.findViewById(R.id.checkJito);
        jica = (CheckBox)view.findViewById(R.id.checkJica);
        champi = (CheckBox)view.findViewById(R.id.checkChamp);
        alfalfa = (CheckBox)view.findViewById(R.id.checkAlf);
        elote = (CheckBox)view.findViewById(R.id.checkElo);
        nuez = (CheckBox)view.findViewById(R.id.checkNu);
        aran = (CheckBox)view.findViewById(R.id.checkAra);

        cSandwich = (RadioButton)view.findViewById(R.id.radioClub);

        cancel = (Button)view.findViewById(R.id.buttonCancel);
        add  = (Button)view.findViewById(R.id.buttonAdd);

        cancel.setOnClickListener(this);
        add.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if(quesoP.isChecked() == true || quesoM.isChecked() == true || pollo.isChecked() == true || surimi.isChecked() == true || atun.isChecked() == true || jamon.isChecked() == true ||salchicha.isChecked() == true){
                    if(crutones.isChecked() == true || frituras.isChecked() == true){
                        Intent goToCheckout = new Intent(getContext(), CheckoutActivity.class);
                        startActivity(goToCheckout);
                        //Enviar la información
                    }else {
                        Toast.makeText(getContext(), "Seleccione crutones o frituras", Toast.LENGTH_LONG).show();
                        return;
                    }
                }else{
                    Toast.makeText(getContext(), "Seleccione una proteina", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

        return view;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCancel) {
            dismiss();
        } else {
            //boton de agregar producto
        }
    }
}
