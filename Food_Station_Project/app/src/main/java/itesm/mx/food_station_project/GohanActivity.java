package itesm.mx.food_station_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;


public class GohanActivity extends AppCompatActivity {

    RadioButton tampico, verde, california, nori, teri;
    String ordenGohan, ordenMail = "", ordenExtra = "";
    Integer costoGohan, costoIExtras;
    CheckBox quesoC, surimi, chipotle, californiaCheck, tampicoCheck, pollo, atun, aguacate, pepino, teriyakiCheck, noriCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gohan);

        ordenGohan = "";
        costoGohan = 0;
        costoIExtras = 0;
        tampico = (RadioButton)findViewById(R.id.radioTampico);
        verde = (RadioButton)findViewById(R.id.radioVerde);
        california = (RadioButton)findViewById(R.id.radioCalifornia);
        nori = (RadioButton)findViewById(R.id.radioNori);
        teri = (RadioButton)findViewById(R.id.radioTeriyaki);

        quesoC = (CheckBox)findViewById(R.id.checkCrema);
        surimi = (CheckBox)findViewById(R.id.checkSurimi);
        chipotle = (CheckBox)findViewById(R.id.checkChipotle);
        californiaCheck = (CheckBox)findViewById(R.id.checkCalifornia);
        tampicoCheck = (CheckBox)findViewById(R.id.checkTampico);
        pollo = (CheckBox)findViewById(R.id.checkPollo);
        atun = (CheckBox)findViewById(R.id.checkAtun);
        aguacate = (CheckBox)findViewById(R.id.checkAgucate);
        pepino = (CheckBox)findViewById(R.id.checkPepino);
        teriyakiCheck = (CheckBox)findViewById(R.id.checkTeriyaki);
        noriCheck = (CheckBox)findViewById(R.id.checkNori);


        //Logica para que solo se pueda seleccionar un RadioButton, se tuvo que hacer porque estan en diferentes layouts
        tampico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampico.setChecked(true);
                verde.setChecked(false);
                california.setChecked(false);
                nori.setChecked(false);
                teri.setChecked(false);
            }
        });
        verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampico.setChecked(false);
                verde.setChecked(true);
                california.setChecked(false);
                nori.setChecked(false);
                teri.setChecked(false);
            }
        });
        california.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampico.setChecked(false);
                verde.setChecked(false);
                california.setChecked(true);
                nori.setChecked(false);
                teri.setChecked(false);
            }
        });
        nori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampico.setChecked(false);
                verde.setChecked(false);
                california.setChecked(false);
                nori.setChecked(true);
                teri.setChecked(false);
            }
        });
        teri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampico.setChecked(false);
                verde.setChecked(false);
                california.setChecked(false);
                nori.setChecked(false);
                teri.setChecked(true);
            }
        });




        ImageButton backBtn = (ImageButton) findViewById(R.id.backFood);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GohanActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        //Boton para ir al checkout
        ImageButton totalBtn = (ImageButton) findViewById(R.id.totalFood);
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCheckout = new Intent(GohanActivity.this, CheckoutActivity.class);
                if(tampico.isChecked() == true || verde.isChecked() == true || nori.isChecked() == true || teri.isChecked() == true || california.isChecked() == true){
                    if(tampico.isChecked() == true){
                        ordenGohan += "Gohan tampico";
                        costoGohan += 32;
                        ordenMail += "Gohan tampico\n";
                    }
                    if(verde.isChecked() == true){
                        ordenGohan +="Gohan verde";
                        costoGohan += 30;
                        ordenMail += "Gohan verde\n";
                    }
                    if(california.isChecked() == true){
                        ordenGohan +="Gohan california";
                        costoGohan += 32;
                        ordenMail += "Gohan california\n";
                    }
                    if(nori.isChecked() == true){
                        ordenGohan +="Gohan Nori";
                        costoGohan += 28;
                        ordenMail += "Gohan nori\n";
                    }
                    if(teri.isChecked() == true){
                        ordenGohan +="Gohan teriyaki";
                        costoGohan += 35;
                        ordenMail += "Gohan teriyaki\n";
                    }

                    if(quesoC.isChecked() == true){
                        costoIExtras +=5;
                        ordenMail += "Queso crema extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(chipotle.isChecked() == true){
                        costoIExtras +=5;
                        ordenMail += "Chipotle extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(aguacate.isChecked() == true){
                        costoIExtras +=5;
                        ordenMail += "Aguacate extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(pepino.isChecked() == true){
                        costoIExtras +=5;
                        ordenMail += "Pepino extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(teriyakiCheck.isChecked() == true){
                        costoIExtras +=5;
                        ordenMail += "Salsa teriyaki extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(noriCheck.isChecked() == true){
                        costoIExtras +=5;
                        ordenMail += "Nori extra\n";
                        ordenExtra = "I. Extras\n";
                    }

                    if(surimi.isChecked() == true){
                        costoIExtras +=8;
                        ordenMail += "Surimi extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(californiaCheck.isChecked() == true){
                        costoIExtras +=8;
                        ordenMail += "California extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(tampicoCheck.isChecked() == true){
                        costoIExtras +=8;
                        ordenMail += "Tampico extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(pollo.isChecked() == true){
                        costoIExtras +=8;
                        ordenMail += "Pollo extra\n";
                        ordenExtra = "I. Extras\n";
                    }
                    if(atun.isChecked() == true){
                        costoIExtras +=8;
                        ordenMail += "Atún extra\n";
                        ordenExtra = "I. Extras\n";
                    }


                    SharedPreferences saveOrder = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = saveOrder.edit();

                    editor.putString("saveOrder", ordenGohan + "\n");
                    editor.putInt("saveCost", Integer.parseInt(String.valueOf(costoGohan)));

                    editor.putString("saveIngredients", ordenExtra);
                    editor.putInt("saveIngredientsCost", Integer.parseInt(String.valueOf(costoIExtras)));
                    //Aqui se manda la orden para el mail al checkout
                    editor.putString("saveMailGohan", ordenMail);

                    editor.apply();

                    Toast.makeText(GohanActivity.this,"Producto agregado", Toast.LENGTH_LONG).show();
                    startActivity(goToCheckout);
                } else {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Seleccione un estilo de Gohan", Toast.LENGTH_LONG).show();
                    return;
                }


            }
        });


    }
}
