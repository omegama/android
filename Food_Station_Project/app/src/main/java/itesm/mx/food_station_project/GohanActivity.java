package itesm.mx.food_station_project;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class GohanActivity extends AppCompatActivity {

    RadioButton tampico, verde, california, nori, teri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gohan);
        Button backBtn = (Button) findViewById(R.id.backFood);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GohanActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        //Boton para ir al checkout
        Button totalBtn = (Button) findViewById(R.id.totalFood);
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCheckout = new Intent(GohanActivity.this, CheckoutActivity.class);
                startActivity(goToCheckout);

            }
        });

        tampico = (RadioButton)findViewById(R.id.radioTampico);
        verde = (RadioButton)findViewById(R.id.radioVerde);
        california = (RadioButton)findViewById(R.id.radioCalifornia);
        nori = (RadioButton)findViewById(R.id.radioNori);
        teri = (RadioButton)findViewById(R.id.radioTeriyaki);

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


    }
}
