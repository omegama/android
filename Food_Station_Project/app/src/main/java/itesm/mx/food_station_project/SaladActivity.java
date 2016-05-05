package itesm.mx.food_station_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SaladActivity extends AppCompatActivity {

    RadioButton med, grande, quesoP, quesoM, pollo, surimi, atun, jamon, salchicha, cruton, frit;
    String ordenEnsalada = "";
    Integer precioEnsalada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);

        med = (RadioButton)findViewById(R.id.radioMediana);
        grande = (RadioButton)findViewById(R.id.radioGrande);
        quesoP = (RadioButton)findViewById(R.id.radioPanela);
        quesoM = (RadioButton)findViewById(R.id.radioManchego);
        pollo = (RadioButton)findViewById(R.id.radioPollo);
        surimi = (RadioButton)findViewById(R.id.radioSurimi);
        atun = (RadioButton)findViewById(R.id.radioAtun);
        jamon = (RadioButton)findViewById(R.id.radioJamon);
        salchicha = (RadioButton)findViewById(R.id.radioSalchicha);
        cruton = (RadioButton)findViewById(R.id.radioCrutones);
        frit = (RadioButton)findViewById(R.id.radioFrituras);

        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                med.setChecked(true);
                grande.setChecked(false);
            }
        });

        grande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                med.setChecked(false);
                grande.setChecked(true);
            }
        });

        quesoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesoP.setChecked(true);
                quesoM.setChecked(false);
                pollo.setChecked(false);
                surimi.setChecked(false);
                atun.setChecked(false);
                jamon.setChecked(false);
                salchicha.setChecked(false);
            }
        });

        quesoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesoP.setChecked(false);
                quesoM.setChecked(true);
                pollo.setChecked(false);
                surimi.setChecked(false);
                atun.setChecked(false);
                jamon.setChecked(false);
                salchicha.setChecked(false);
            }
        });
        pollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesoP.setChecked(false);
                quesoM.setChecked(false);
                pollo.setChecked(true);
                surimi.setChecked(false);
                atun.setChecked(false);
                jamon.setChecked(false);
                salchicha.setChecked(false);
            }
        });
        surimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesoP.setChecked(false);
                quesoM.setChecked(false);
                pollo.setChecked(false);
                surimi.setChecked(true);
                atun.setChecked(false);
                jamon.setChecked(false);
                salchicha.setChecked(false);
            }
        });
        atun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesoP.setChecked(false);
                quesoM.setChecked(false);
                pollo.setChecked(false);
                surimi.setChecked(false);
                atun.setChecked(true);
                jamon.setChecked(false);
                salchicha.setChecked(false);
            }
        });
        jamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesoP.setChecked(false);
                quesoM.setChecked(false);
                pollo.setChecked(false);
                surimi.setChecked(false);
                atun.setChecked(false);
                jamon.setChecked(true);
                salchicha.setChecked(false);
            }
        });
        salchicha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesoP.setChecked(false);
                quesoM.setChecked(false);
                pollo.setChecked(false);
                surimi.setChecked(false);
                atun.setChecked(false);
                jamon.setChecked(false);
                salchicha.setChecked(true);
            }
        });

        cruton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cruton.setChecked(true);
                frit.setChecked(false);
            }
        });
        frit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cruton.setChecked(false);
                frit.setChecked(true);
            }
        });

        Button backBtn = (Button) findViewById(R.id.backFood);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaladActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        Button totalBtn = (Button) findViewById(R.id.totalFood);
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCheckout = new Intent(SaladActivity.this, CheckoutActivity.class);
                if((med.isChecked() == true || grande.isChecked() == true) && (quesoP.isChecked() == true || quesoM.isChecked() == true || pollo.isChecked() == true || surimi.isChecked() == true || atun.isChecked() == true || jamon.isChecked() == true ||salchicha.isChecked() == true)
                       && (cruton.isChecked() == true || frit.isChecked() == true) ){

                    if(med.isChecked() == true){
                        ordenEnsalada += "Ensalada mediana";
                        precioEnsalada += 35;
                    }
                    if(grande.isChecked() == true){
                        ordenEnsalada += "Ensalada grande";
                        precioEnsalada += 48;
                    }

                    //int precioParse = Integer.parseInt(precioEnsalada.toString());

                    //goToCheckout.putExtra("orderSalad", ordenEnsalada);
                    //goToCheckout.putExtra("costSalad", precioParse);

                    SharedPreferences saveOrder = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = saveOrder.edit();
                    editor.putString("saveOrderSalad", ordenEnsalada);
                    editor.putString("saveCostSalad", String.valueOf(precioEnsalada));
                    editor.apply();

                    Toast.makeText(SaladActivity.this,"Producto agregado", Toast.LENGTH_LONG).show();


                    startActivity(goToCheckout);


                } else if (med.isChecked() == false && grande.isChecked() == false){
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Seleccione el tamaño de su ensalada", Toast.LENGTH_LONG).show();
                    return;

                } else if ((med.isChecked() == true || grande.isChecked() == true) && (quesoP.isChecked() == false && quesoM.isChecked() == false && pollo.isChecked() == false && surimi.isChecked() == false && atun.isChecked() == false && jamon.isChecked() == false && salchicha.isChecked() == false)) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Seleccione la proteína para su ensalada", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Elija si desea crutones o frituras", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });




    }
}
