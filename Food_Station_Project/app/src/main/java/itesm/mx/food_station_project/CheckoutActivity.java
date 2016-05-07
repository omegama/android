package itesm.mx.food_station_project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    ImageButton continueBtn, eraseBtn;
    Button payBtn;
    TextView ordenGohan, totalOrden, costoGohan;
    String extraGohan, extraSalad, textoBebidas, textoIExtras, textoGE, textoES, textoGS;
    String mailGohan, mailSalad, mailDrinks, mailCombo1, mailCombo2, mailCombo3;
    Integer extraCostoGohan, extraCostoSalad, extraBebidas, costoIExtras, costoGE, costoES, costoGS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        final Context context = getApplicationContext();
        continueBtn = (ImageButton)findViewById(R.id.continueButton);
        payBtn = (Button)findViewById(R.id.checkoutButton);
        eraseBtn = (ImageButton)findViewById(R.id.eraseButton);

        ordenGohan = (TextView)findViewById(R.id.textOrden);
        costoGohan = (TextView)findViewById(R.id.textCostGohan);
        //totalOrden = (TextView)findViewById(R.id.textTotal);

        //Recibir todas las ordenes
        SharedPreferences saveOrder = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);

        extraGohan = saveOrder.getString("saveOrder", "");
        extraCostoGohan = Integer.parseInt(saveOrder.getString("saveCost", "0"));
        textoIExtras = saveOrder.getString("saveIngredients", "");
        costoIExtras = Integer.parseInt(saveOrder.getString("saveIngredientsCost", "0"));

        extraBebidas = Integer.parseInt(saveOrder.getString("saveDrinks", "0"));
        textoBebidas = saveOrder.getString("saveTextDrinks", "");

        extraSalad = saveOrder.getString("saveOrderSalad", "");
        extraCostoSalad = Integer.parseInt(saveOrder.getString("saveCostSalad", "0"));

        textoGE = saveOrder.getString("GEorden", "");
        costoGE = Integer.parseInt(saveOrder.getString("GEcosto", "0"));

        textoES = saveOrder.getString("ESorden", "");
        costoES = Integer.parseInt(saveOrder.getString("EScosto", "0"));

        textoGS = saveOrder.getString("GSorden", "");
        costoGS = Integer.parseInt(saveOrder.getString("GScosto", "0"));

        //AQUI RECIBE LAS ORDENES PARA EL MAIL...
        mailGohan = saveOrder.getString("saveMailGohan", "");
        mailSalad = saveOrder.getString("saveMailSalad", "");
        mailDrinks = saveOrder.getString("saveMailDrinks", "");
        mailCombo1 = saveOrder.getString("mailCombo1", "");
        mailCombo2 = saveOrder.getString("mailCombo2", "");
        mailCombo3 = saveOrder.getString("mailCombo3", "");






        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueBuying = new Intent(CheckoutActivity.this, MenuActivity.class);
                startActivity(continueBuying);
            }
        });

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enviar a la API de paypal para realizar pago

                //Limpia la orden al ir a PayPal chanse esto no es necesario aun, no se como funcione el mail
                context.getSharedPreferences("orderInfo", 0).edit().clear().commit();
                Toast.makeText(context, "Gracias por su compra", Toast.LENGTH_LONG).show();

            }
        });

        eraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eraseOrder = new Intent(CheckoutActivity.this, MenuActivity.class);
                //Limpiar la orden
                context.getSharedPreferences("orderInfo", 0).edit().clear().commit();
                Toast.makeText(context, "Se ha borrado su orden", Toast.LENGTH_LONG).show();
                startActivity(eraseOrder);

            }
        });

        //Calculo del total de la orden
        Integer ordenTotal = extraCostoGohan + extraCostoSalad + extraBebidas + costoIExtras + costoGE + costoES + costoGS;

        //Impresion de elementos en la orden
        costoGohan.setText("Precio\n" + "$" + extraCostoGohan.toString() + "\n$" + costoIExtras.toString()+ "\n$" + extraCostoSalad.toString() + "\n$" + extraBebidas.toString() + "\n$" + costoGE.toString() + "\n$" + costoES.toString() + "\n$" + costoGS.toString()  + "\n\n$" + ordenTotal.toString());
        ordenGohan.setText("Orden\n" + extraGohan + "\n" + textoIExtras +  "\n" + extraSalad + "\n" + textoBebidas  + "\n" + textoGE + "\n" + textoES + "\n" + textoGS + "\n" );
        //totalOrden.setText("$" + ordenTotal.toString());
    }
}
