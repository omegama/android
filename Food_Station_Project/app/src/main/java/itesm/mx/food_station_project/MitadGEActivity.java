package itesm.mx.food_station_project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MitadGEActivity extends DialogFragment implements View.OnClickListener {

    RadioButton tampicoR, caliR, noriR, teriR, verdeR, quesoP, quesoM, pollo, surimi, atun, jamon, salchicha, crutones, frituras;
    CheckBox pepino, zana, acei, manz, pimi, jito, champi, jica, alfalfa, elote, nuez, aran;
    ImageButton cancel, add;
    SharedPreferences sendCombo;
    SharedPreferences.Editor editor;
    String comboOrder, ordenMail = "";
    Integer comboCost;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.activity_mitad_ge, null);

        tampicoR = (RadioButton)view.findViewById(R.id.radioTampico);
        caliR = (RadioButton)view.findViewById(R.id.radioCali);
        noriR = (RadioButton)view.findViewById(R.id.radioNori);
        teriR = (RadioButton)view.findViewById(R.id.radioTeriyaki);
        verdeR = (RadioButton)view.findViewById(R.id.radioVerde);

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

        cancel = (ImageButton)view.findViewById(R.id.buttonCancel);
        add  = (ImageButton)view.findViewById(R.id.buttonAdd);



        cancel.setOnClickListener(this);
        add.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int acumBarraFria = 0;

                if(pepino.isChecked() == true){
                    acumBarraFria ++;
                }
                if(zana.isChecked() == true){
                    acumBarraFria ++;
                }
                if(acei.isChecked() == true){
                    acumBarraFria ++;
                }
                if(manz.isChecked() == true){
                    acumBarraFria ++;
                }
                if(pimi.isChecked() == true){
                    acumBarraFria ++;
                }
                if(jito.isChecked() == true){
                    acumBarraFria ++;
                }
                if(champi.isChecked() == true){
                    acumBarraFria ++;
                }
                if(jica.isChecked() == true){
                    acumBarraFria ++;
                }
                if(alfalfa.isChecked() == true){
                    acumBarraFria ++;
                }
                if(elote.isChecked() == true){
                    acumBarraFria ++;
                }
                if(nuez.isChecked() == true){
                    acumBarraFria ++;
                }
                if(aran.isChecked() == true){
                    acumBarraFria ++;
                }

                if(tampicoR.isChecked() == true || verdeR.isChecked() == true || noriR.isChecked() == true || teriR.isChecked() == true || caliR.isChecked() == true){

                    if (quesoP.isChecked() == true || quesoM.isChecked() == true || pollo.isChecked() == true || surimi.isChecked() == true || atun.isChecked() == true || jamon.isChecked() == true || salchicha.isChecked() == true) {

                        if(acumBarraFria == 4) {

                            if (crutones.isChecked() == true || frituras.isChecked() == true) {
                                Intent goToCheckout = new Intent(getContext(), CheckoutActivity.class);

                                if(tampicoR.isChecked() == true){
                                    ordenMail += "Mitad gohan tampico\n\n";
                                }
                                if(verdeR.isChecked() == true){
                                    ordenMail += "Mitad gohan verde\n\n";
                                }
                                if(noriR.isChecked() == true){
                                    ordenMail += "Mitad gohan nori\n\n";
                                }
                                if(teriR.isChecked() == true){
                                    ordenMail += "Mitad gohan teriyaki\n\n";
                                }
                                if(caliR.isChecked() == true){
                                    ordenMail += "Mitad gohan california\n\n";
                                }

                                ordenMail += "Mitad Ensalada\n";
                                //Ensalada para mail
                                if(quesoP.isChecked() == true){
                                    ordenMail += "Queso Panela\n";
                                }
                                if(quesoM.isChecked() == true){
                                    ordenMail += "Queso Manchego\n";
                                }
                                if(pollo.isChecked() == true){
                                    ordenMail += "Pollo\n";
                                }
                                if(surimi.isChecked() == true){
                                    ordenMail += "Surimi\n";
                                }
                                if(atun.isChecked() == true){
                                    ordenMail += "Atún\n";
                                }
                                if(jamon.isChecked() == true){
                                    ordenMail += "Jamón\n";
                                }
                                if(salchicha.isChecked() == true){
                                    ordenMail += "Salchicha\n";
                                }

                                //Tomar los ingredientes de barra fria para el mail
                                if(pepino.isChecked() == true){
                                    ordenMail += "Pepino\n";
                                }
                                if(zana.isChecked() == true){
                                    ordenMail += "Zanahoria\n";
                                }
                                if(acei.isChecked() == true){
                                    ordenMail += "Aceituna\n";
                                }
                                if(manz.isChecked() == true){
                                    ordenMail += "Manzana\n";
                                }
                                if(pimi.isChecked() == true){
                                    ordenMail += "Pimiento\n";
                                }
                                if(jito.isChecked() == true){
                                    ordenMail += "Jitomate\n";
                                }
                                if(champi.isChecked() == true){
                                    ordenMail += "Champiñón\n";
                                }
                                if(jica.isChecked() == true){
                                    ordenMail += "Jicama\n";
                                }
                                if(alfalfa.isChecked() == true){
                                    ordenMail += "G. de Alfalfa\n";
                                }
                                if(elote.isChecked() == true){
                                    ordenMail += "Elote\n";
                                }
                                if(nuez.isChecked() == true){
                                    ordenMail += "Nuez\n";
                                }
                                if(aran.isChecked() == true){
                                    ordenMail += "Arándano\n";
                                }

                                //Tomar el complemento para el mail
                                if(crutones.isChecked() == true){
                                    ordenMail += "Crutones\n\n";
                                }
                                if(frituras.isChecked() == true){
                                    ordenMail += "Frituras\n\n";
                                }


                                comboOrder = "Mitad gohan - ensalada";
                                comboCost = 50;
                                sendCombo = getActivity().getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
                                editor = sendCombo.edit();
                                editor.putString("GEorden", comboOrder + "\n");
                                editor.putInt("GEcosto", Integer.parseInt(String.valueOf(comboCost)));
                                editor.putString("mailCombo1", "\n" + ordenMail);
                                editor.apply();
                                Toast.makeText(getActivity(), "Producto agregado", Toast.LENGTH_LONG).show();

                                startActivity(goToCheckout);
                            } else {
                                Toast.makeText(getContext(), "Seleccione crutones o frituras", Toast.LENGTH_LONG).show();
                                return;
                            }
                        } else {
                            Toast.makeText(getContext(), "Debe seleccionar 4 ingredientes de barra fría", Toast.LENGTH_LONG).show();
                            return;
                        }
                    } else {
                        Toast.makeText(getContext(), "Seleccione una proteina", Toast.LENGTH_LONG).show();
                        return;
                    }

                }else {
                    Toast.makeText(getContext(), "Seleccione un estilo de Gohan", Toast.LENGTH_LONG).show();
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
