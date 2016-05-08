package itesm.mx.food_station_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FoodActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);

       final Context context = getApplicationContext();

        ImageButton backBtn = (ImageButton) findViewById(R.id.backFood);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        Button gohanBtn = (Button)findViewById(R.id.gohanButton);
        gohanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGohan = new Intent (FoodActivity.this, GohanActivity.class);
                startActivity(goToGohan);
            }
        });

        Button saladBtn = (Button)findViewById(R.id.saladButton);
        saladBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSalad = new Intent(FoodActivity.this, SaladActivity.class);
                startActivity(goToSalad);
            }
        });

        Button comboButton = (Button)findViewById(R.id.buttonCombo);
        comboButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCombo = new Intent(FoodActivity.this, CombosActivity.class);
                startActivity(goToCombo);
            }
        });
    }
}