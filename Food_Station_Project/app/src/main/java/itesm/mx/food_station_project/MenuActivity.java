package itesm.mx.food_station_project;

import android.content.Intent;
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
        Button goToOrder = (Button)findViewById(R.id.buttonCheckout);

        goToFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui hay que poner el intent para que vaya a la actividad de Food
                Intent intent = new Intent (MenuActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        goToDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui hay que poner el intent para que vaya a la actividad de Drinks
                Intent intent = new Intent (MenuActivity.this, DrinksActivity.class);
                startActivity(intent);
            }
        });

        goToCombos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui hay que poner el intent para que vaya a la actividad de Combos
                Intent intent = new Intent (MenuActivity.this, CombosActivity.class);
                startActivity(intent);
            }
        });
        goToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui hay que poner el intent para que vaya a la actividad de Combos
                Intent intent = new Intent (MenuActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
