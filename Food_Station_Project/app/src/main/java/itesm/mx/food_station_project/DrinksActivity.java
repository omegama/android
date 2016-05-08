package itesm.mx.food_station_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class DrinksActivity extends AppCompatActivity {

    Spinner teHelado, teOscuro, refresco, agua6, agua1, vitamin, fuze, delValle, valleFrut, power;
    String orderMail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks);

        teHelado = (Spinner)findViewById(R.id.spinnerTe);
        teOscuro = (Spinner)findViewById(R.id.spinnerOscuro);
        refresco = (Spinner)findViewById(R.id.spinnerRefresco);
        agua6 = (Spinner)findViewById(R.id.spinnerAgua6);
        agua1 = (Spinner)findViewById(R.id.spinnerAgua1);
        vitamin = (Spinner)findViewById(R.id.spinnerVitamin);
        fuze = (Spinner)findViewById(R.id.spinnerFuze);
        delValle = (Spinner)findViewById(R.id.spinnerDelValle);
        valleFrut = (Spinner)findViewById(R.id.spinnerValleFrut);
        power = (Spinner)findViewById(R.id.spinnerPower);

        ImageButton backBtn = (ImageButton) findViewById(R.id.backDrink);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(DrinksActivity.this, MenuActivity.class);
                startActivity(goToMenu);
            }
        });
        final ImageButton totalBtn = (ImageButton) findViewById(R.id.totalDrink);
        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTotal = new Intent(DrinksActivity.this, CheckoutActivity.class);

                SharedPreferences saveOrder = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = saveOrder.edit();

                int totalDrink = 0;
                if(Integer.parseInt(teHelado.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(teHelado.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Te helado\n";
                }
                if(Integer.parseInt(teOscuro.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(teOscuro.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Te oscuro\n";
                }
                if(Integer.parseInt(refresco.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(refresco.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Refresco\n";
                }
                if(Integer.parseInt(agua6.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(agua6.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Agua de 600ml\n";
                }
                if(Integer.parseInt(agua1.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(agua1.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Agua de 1Lt\n";
                }
                if(Integer.parseInt(vitamin.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(vitamin.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Vitamin Water\n";
                }
                if(Integer.parseInt(fuze.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(fuze.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Fuze Tea\n";
                }
                if(Integer.parseInt(delValle.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(delValle.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Jugo del Valle\n";
                }
                if(Integer.parseInt(valleFrut.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(valleFrut.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Jugo del valle Frut\n";
                }
                if(Integer.parseInt(power.getSelectedItem().toString()) > 0){
                    int cant = Integer.parseInt(power.getSelectedItem().toString());
                    totalDrink += cant * 10;
                    orderMail = cant  + " - Powerade\n";
                }

                if(Integer.parseInt(power.getSelectedItem().toString()) <=0 && Integer.parseInt(valleFrut.getSelectedItem().toString()) <=0
                        &&Integer.parseInt(delValle.getSelectedItem().toString()) <=0 && Integer.parseInt(fuze.getSelectedItem().toString()) <=0
                        && Integer.parseInt(vitamin.getSelectedItem().toString()) <=0 && Integer.parseInt(agua1.getSelectedItem().toString()) <=0
                        && Integer.parseInt(agua6.getSelectedItem().toString()) <=0 &&Integer.parseInt(refresco.getSelectedItem().toString()) <=0
                        && Integer.parseInt(teHelado.getSelectedItem().toString()) <=0 && Integer.parseInt(teOscuro.getSelectedItem().toString()) <=0){
                    Context context = getApplicationContext();
                    Toast.makeText(context, "No seleccionó ninguna bebida", Toast.LENGTH_LONG).show();
                    return;
                }

                editor.putInt("saveDrinks", Integer.parseInt(String.valueOf(totalDrink)));
                editor.putString("saveTextDrinks", "Bebidas\n");
                editor.putString("saveMailDrinks", "\n" + orderMail);
                editor.apply();

                Toast.makeText(DrinksActivity.this, "Producto agregado", Toast.LENGTH_LONG).show();

                startActivity(goToTotal);
            }
        });
    }
}