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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MitadGSActivity extends DialogFragment implements View.OnClickListener {

        RadioButton tampicoR, caliR, noriR, teriR, verdeR, clubR;
        Button cancel, add;
        EditText clubSpec;
        SharedPreferences sendCombo;
        SharedPreferences.Editor editor;
        String comboOrder, orderMail = "";
        Integer comboCost;


public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.activity_mitad_gs, null);


        tampicoR = (RadioButton)view.findViewById(R.id.radioTampico);
        caliR = (RadioButton)view.findViewById(R.id.radioCali);
        noriR = (RadioButton)view.findViewById(R.id.radioNori);
        teriR = (RadioButton)view.findViewById(R.id.radioTeriyaki);
        verdeR = (RadioButton)view.findViewById(R.id.radioVerde);
        clubR = (RadioButton)view.findViewById(R.id.radioClub);
        clubSpec = (EditText)view.findViewById(R.id.clubEspecificacion);

        cancel = (Button)view.findViewById(R.id.buttonCancel);
        add  = (Button)view.findViewById(R.id.buttonAdd);

        cancel.setOnClickListener(this);
    add.setOnClickListener(new View.OnClickListener() {
        @TargetApi(Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {

            if(tampicoR.isChecked() == true || verdeR.isChecked() == true || noriR.isChecked() == true || teriR.isChecked() == true || caliR.isChecked() == true){
                Intent goToCheckout = new Intent(getContext(), CheckoutActivity.class);


                if(tampicoR.isChecked() == true){
                    orderMail += "Mitad gohan tampico\n\n";
                }
                if(caliR.isChecked() == true){
                    orderMail += "Mitad gohan california\n\n";
                }
                if(noriR.isChecked() == true){
                    orderMail += "Mitad gohan nori\n\n";
                }
                if(teriR.isChecked() == true){
                    orderMail += "Mitad gohan teriyaki\n\n";
                }
                if(verdeR.isChecked() == true){
                    orderMail += "Mitad gohan verde\n\n";
                }
                if(clubR.isChecked() == true){
                    orderMail += "Mitad Club Sandwich\n";
                }
                if(clubSpec.getText().toString().matches("")){
                    //No hay especificaciones para el gohan
                } else {
                    orderMail += "Especificaciones: " + clubSpec.getText().toString() + "\n";
                }

                comboOrder = "Mitad gohan - club";
                comboCost = 50;
                sendCombo = getActivity().getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
                editor = sendCombo.edit();
                editor.putString("GSorden", comboOrder);
                editor.putString("GScosto", String.valueOf(comboCost));
                editor.putString("mailCombo2", orderMail);
                editor.apply();

                Toast.makeText(getActivity(),"Producto agregado", Toast.LENGTH_LONG).show();

                startActivity(goToCheckout);
            } else {
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
