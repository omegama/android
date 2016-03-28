package itesm.mx.food_station_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button goToFood = (Button) findViewById(R.id.buttonFood);
        Button goToDrinks = (Button) findViewById(R.id.buttonDrinks);
        Button goToCombos = (Button) findViewById(R.id.buttonCombos);

        goToFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui hay que poner el intent para que vaya a la actividad de Food
            }
        });

        goToDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui hay que poner el intent para que vaya a la actividad de Drinks
            }
        });

        goToCombos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui hay que poner el intent para que vaya a la actividad de Combos
            }
        });
    }
}
