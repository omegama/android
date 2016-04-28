package itesm.mx.food_station_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SaladActivity extends AppCompatActivity {

    RadioButton med, grande, quesoP, quesoM, pollo, surimi, atun, jamon, salchicha, cruton, frit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);
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
                startActivity(goToCheckout);
            }
        });


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

    }
}
