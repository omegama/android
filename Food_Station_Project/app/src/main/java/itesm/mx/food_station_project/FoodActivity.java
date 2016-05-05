package itesm.mx.food_station_project;

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

        Button backBtn = (Button) findViewById(R.id.backFood);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        ImageButton gohanBtn = (ImageButton)findViewById(R.id.gohanButton);
        gohanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGohan = new Intent (FoodActivity.this, GohanActivity.class);
                startActivity(goToGohan);
            }
        });

        ImageButton saladBtn = (ImageButton)findViewById(R.id.saladButton);
        saladBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSalad = new Intent(FoodActivity.this, SaladActivity.class);
                startActivity(goToSalad);
            }
        });
    }
}