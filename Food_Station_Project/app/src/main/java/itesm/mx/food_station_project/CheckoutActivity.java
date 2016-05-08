package itesm.mx.food_station_project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    Integer extraCostoGohan, extraCostoSalad, extraBebidas, costoIExtras, costoGE, costoES, costoGS, ordenTotal;
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
        extraCostoGohan = (saveOrder.getInt("saveCost", 0));
        textoIExtras = saveOrder.getString("saveIngredients", "");
        costoIExtras = (saveOrder.getInt("saveIngredientsCost", 0));

        extraBebidas = (saveOrder.getInt("saveDrinks", 0));
        textoBebidas = saveOrder.getString("saveTextDrinks", "");

        extraSalad = saveOrder.getString("saveOrderSalad", "");
        extraCostoSalad = (saveOrder.getInt("saveCostSalad", 0));

        textoGE = saveOrder.getString("GEorden", "");
        costoGE = (saveOrder.getInt("GEcosto", 0));

        textoES = saveOrder.getString("ESorden", "");
        costoES = (saveOrder.getInt("EScosto", 0));

        textoGS = saveOrder.getString("GSorden", "");
        costoGS = (saveOrder.getInt("GScosto", 0));

        //AQUI RECIBE LAS ORDENES PARA EL MAIL...
        mailGohan = saveOrder.getString("saveMailGohan", "");
        mailSalad = saveOrder.getString("saveMailSalad", "");
        mailDrinks = saveOrder.getString("saveMailDrinks", "");
        mailCombo1 = saveOrder.getString("mailCombo1", "");
        mailCombo2 = saveOrder.getString("mailCombo2", "");
        mailCombo3 = saveOrder.getString("mailCombo3", "");

        final String fullOrderMail = mailGohan + mailSalad + mailDrinks + mailCombo1 + mailCombo2 + mailCombo3;




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

                if(fullOrderMail.matches("")){
                    Toast.makeText(context, "Su orden no tiene elementos", Toast.LENGTH_LONG).show();
                } else {
                    Intent sendOrder = new Intent(Intent.ACTION_SEND);
                    sendOrder.setData(Uri.parse("mailto:"));
                    String to[] = {"food.station.qro@gmail.com"};
                    sendOrder.putExtra(Intent.EXTRA_EMAIL, to);
                    sendOrder.putExtra(Intent.EXTRA_SUBJECT, "Nueva orden");
                    sendOrder.putExtra(Intent.EXTRA_TEXT, fullOrderMail + "\nTotal pagado: $" + ordenTotal.toString());
                    sendOrder.setType("message/rfc822");
                    startActivity(Intent.createChooser(sendOrder, "Send email"));
                    context.getSharedPreferences("orderInfo", 0).edit().clear().commit();
                }
                /*
                //Limpia la orden al ir a PayPal chanse esto no es necesario aun, no se como funcione el mail
                Intent goToMenu = new Intent(CheckoutActivity.this, MenuActivity.class);
                context.getSharedPreferences("orderInfo", 0).edit().clear().commit();
                Toast.makeText(context, "Gracias por hacer su pedido", Toast.LENGTH_LONG).show();
                startActivity(goToMenu);
                */

            }
        });

        eraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eraseOrder = new Intent(CheckoutActivity.this, MenuActivity.class);

                if(fullOrderMail.matches("")){
                    Toast.makeText(context, "No existe orden para borrar", Toast.LENGTH_LONG).show();
                    startActivity(eraseOrder);
                }else {
                    //Limpiar la orden
                    context.getSharedPreferences("orderInfo", 0).edit().clear().commit();
                    Toast.makeText(context, "Se ha borrado su orden", Toast.LENGTH_LONG).show();
                    startActivity(eraseOrder);
                }
            }
        });

        //Calculo del total de la orden
         ordenTotal = extraCostoGohan + extraCostoSalad + extraBebidas + costoIExtras + costoGE + costoES + costoGS;
              //

        String costoGohanCambio = extraCostoGohan.toString();
        String extrasCambio = costoIExtras.toString();
        String costoSalad = extraCostoSalad.toString();
        String cambioBebida = extraBebidas.toString();
        String combo1Cambio = costoGE.toString();
        String combo2Cambio = costoGS.toString();
        String combo3Cambio = costoES.toString();

        if (costoGohanCambio.matches("0")){
            costoGohanCambio = "";
        } else {
            costoGohanCambio = "$" +  extraCostoGohan.toString() + "\n";

        }

        if(extrasCambio.matches("0")){
            extrasCambio = "";
        } else {
            extrasCambio = "$" +  costoIExtras.toString() + "\n";
        }

        if (costoSalad.matches("0")){
            costoSalad = "";
        } else {
            costoSalad = "$" + extraCostoSalad.toString() + "\n";
        }

        if (cambioBebida.matches("0")){
            cambioBebida = "";
        } else {
            cambioBebida = "$" + extraBebidas.toString() + "\n";
        }

        if (combo1Cambio.matches("0")){
                combo1Cambio = "";
        } else {
            combo1Cambio = "$" + costoGE.toString() + "\n";
        }

        if (combo2Cambio.matches("0")){
            combo2Cambio = "";
        } else {
            combo2Cambio = "$" + costoGS.toString() + "\n";
        }

        if (combo3Cambio.matches("0")){
            combo3Cambio = "";
        } else {
            combo3Cambio = "$" + costoES.toString() + "\n";
        }

        //Impresion de elementos en la orden
        costoGohan.setText("Precio\n\n" +  costoGohanCambio + extrasCambio + costoSalad + cambioBebida + combo1Cambio + combo2Cambio + combo3Cambio + "\n$" + ordenTotal.toString());
                //+  costoIExtras.toString() + extraCostoSalad.toString()+ extraBebidas.toString()  + costoGE.toString() + costoES.toString()  + costoGS.toString()  + "\n\n$" + ordenTotal.toString());
        ordenGohan.setText("Orden\n\n" + extraGohan + textoIExtras + extraSalad + textoBebidas + textoGE + textoGS +  textoES + "\n"  + "Total" + "\n" );
        //totalOrden.setText("$" + ordenTotal.toString());
    }
}
