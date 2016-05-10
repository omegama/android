package itesm.mx.food_station_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class SaladActivity extends AppCompatActivity {

    RadioButton med, grande, quesoP, quesoM, pollo, surimi, atun, jamon, salchicha, cruton, frit;
    CheckBox pepino, zana, acei, manz, pimi, jito, champi, jica, alfalfa, elote, nuez, aran;
    String ordenEnsalada = "", ordenMail = "";
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

        pepino = (CheckBox)findViewById(R.id.checkPepino);
        zana = (CheckBox)findViewById(R.id.checkZana);
        acei = (CheckBox)findViewById(R.id.checkAceituna);
        manz = (CheckBox)findViewById(R.id.checkManzana);
        pimi = (CheckBox)findViewById(R.id.checkPimiento);
        jito = (CheckBox)findViewById(R.id.checkJitomate);
        jica = (CheckBox)findViewById(R.id.checkJicama);
        champi = (CheckBox)findViewById(R.id.checkChampiñon);
        alfalfa = (CheckBox)findViewById(R.id.checkAlfalfa);
        elote = (CheckBox)findViewById(R.id.checkElote);
        nuez = (CheckBox)findViewById(R.id.checkNuez);
        aran = (CheckBox)findViewById(R.id.checkArandano);

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


        if(pepino.isChecked() == true){

        }
        if(zana.isChecked() == true){

        }
        if(acei.isChecked() == true){

        }
        if(manz.isChecked() == true){

        }
        if(pimi.isChecked() == true){

        }
        if(jito.isChecked() == true){

        }
        if(champi.isChecked() == true){

        }
        if(jica.isChecked() == true){

        }
        if(alfalfa.isChecked() == true){

        }
        if(elote.isChecked() == true){

        }
        if(nuez.isChecked() == true){

        }
        if(aran.isChecked() == true){

        }

        checaIngredientes();

        ImageButton backBtn = (ImageButton) findViewById(R.id.backFood);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaladActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        ImageButton totalBtn = (ImageButton) findViewById(R.id.totalFood);
        totalBtn.setOnClickListener(new View.OnClickListener() {
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

                Intent goToCheckout = new Intent(SaladActivity.this, CheckoutActivity.class);
                if((med.isChecked() == true || grande.isChecked() == true) && (quesoP.isChecked() == true || quesoM.isChecked() == true || pollo.isChecked() == true || surimi.isChecked() == true || atun.isChecked() == true || jamon.isChecked() == true ||salchicha.isChecked() == true)
                       && (cruton.isChecked() == true || frit.isChecked() == true && acumBarraFria == 4 ) ){

                    if(med.isChecked() == true){
                        ordenEnsalada += "Ensalada mediana";
                        precioEnsalada += 35;
                        ordenMail += "\nEnsalada mediana\n";
                    }
                    if(grande.isChecked() == true){
                        ordenEnsalada += "Ensalada grande";
                        precioEnsalada += 48;
                        ordenMail += "\nEnsalada grande\n";
                    }

                    //Tomar el tipo de proteina que se selecciono para el mail
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
                    if(cruton.isChecked() == true){
                        ordenMail += "Crutones\n";
                    }
                    if(frit.isChecked() == true){
                        ordenMail += "Frituras\n";
                    }

                         SharedPreferences saveOrder = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
                         SharedPreferences.Editor editor = saveOrder.edit();
                         editor.putString("saveOrderSalad", ordenEnsalada + "\n");
                         editor.putInt("saveCostSalad", Integer.parseInt(String.valueOf(precioEnsalada)));
                            //Aqui se guarda globalmente la orden para el mail
                         editor.putString("saveMailSalad", ordenMail);
                         editor.apply();
                         Toast.makeText(SaladActivity.this, "Producto agregado", Toast.LENGTH_LONG).show();
                         startActivity(goToCheckout);


                } else if (med.isChecked() == false && grande.isChecked() == false){
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Seleccione el tamaño de su ensalada", Toast.LENGTH_LONG).show();
                    return;

                } else if ((med.isChecked() == true || grande.isChecked() == true) && (quesoP.isChecked() == false && quesoM.isChecked() == false && pollo.isChecked() == false && surimi.isChecked() == false && atun.isChecked() == false && jamon.isChecked() == false && salchicha.isChecked() == false)) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Seleccione la proteína para su ensalada", Toast.LENGTH_LONG).show();
                    return;
                } else if ((med.isChecked() == true || grande.isChecked() == true) && (quesoP.isChecked() == true || quesoM.isChecked() == true || pollo.isChecked() == true || surimi.isChecked() == true || atun.isChecked() == true || jamon.isChecked() == true || salchicha.isChecked() == true) && acumBarraFria != 4){
                    Context context = getApplicationContext();
                    Toast.makeText(context,"Debe seleccionar 4 ingredientes de barra fría" , Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Context context = getApplicationContext();
                    Toast.makeText(context,"Elija si desea crutones o frituras" , Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }

    public int checaIngredientes(){

        int acumBarraFria = 0;



        if(acumBarraFria == 5){
            Context context = getApplicationContext();
            Toast.makeText(context, "El límite de barra fría es 4", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }
    }
}
