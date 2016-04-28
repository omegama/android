package itesm.mx.food_station_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks);

        Button backBtn = (Button) findViewById(R.id.backDrink);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(DrinksActivity.this, MenuActivity.class);
                startActivity(goToMenu);
            }
        });
        Button totalBtn = (Button) findViewById(R.id.totalDrink);
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTotal = new Intent(DrinksActivity.this, CheckoutActivity.class);
                startActivity(goToTotal);
            }
        });
    }
}