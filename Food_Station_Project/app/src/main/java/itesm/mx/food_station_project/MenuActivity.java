package itesm.mx.food_station_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton goToFood = (ImageButton) findViewById(R.id.buttonFood);
        ImageButton goToDrinks = (ImageButton) findViewById(R.id.buttonDrinks);
        ImageButton goToOrder = (ImageButton)findViewById(R.id.buttonCheckout);

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
