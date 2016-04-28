package itesm.mx.food_station_project;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CombosActivity extends FragmentActivity implements MitadGEActivity.CustomDialogListener, MitadGSActivity.CustomDialogListener, MitadESActivity.CustomDialogListener {
    Context context;
    android.app.FragmentTransaction createFragment;
    MitadGEActivity gohanEnsaladaFragment;
    MitadGSActivity gohanSandwichFragment;
    MitadESActivity sandwichEnsaladaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combos);

        context = getApplicationContext();


        Button backBtn = (Button) findViewById(R.id.backCombo);
        Button mitadGE = (Button)findViewById(R.id.buttonGE);
        Button totalBtn = (Button) findViewById(R.id.totalCombo);
        Button mitadGS = (Button)findViewById(R.id.buttonGS);
        Button mitadES = (Button)findViewById(R.id.buttonES);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CombosActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        totalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTotal = new Intent(CombosActivity.this, CheckoutActivity.class);
                startActivity(goToTotal);
            }
        });

        mitadGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFragment = getFragmentManager().beginTransaction();
                gohanEnsaladaFragment = new MitadGEActivity();
                gohanEnsaladaFragment.show(createFragment, "dialog");
            }
        });

        mitadGS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFragment = getFragmentManager().beginTransaction();
                gohanSandwichFragment = new MitadGSActivity();
                gohanSandwichFragment.show(createFragment, "dialog");
            }
        });

        mitadES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFragment = getFragmentManager().beginTransaction();
                sandwichEnsaladaFragment = new MitadESActivity();
                sandwichEnsaladaFragment.show(createFragment, "dialog");
            }
        });

    }
    public void onDialogPositiveClick(DialogFragment dialog) {
        /*
        EditText userEditText = (EditText)dialog.getDialog().findViewById(R.id.username);
        String username = userEditText.getText().toString();
        Intent newIntent = new Intent(getApplicationContext(), CheckoutActivity.class);
        newIntent.putExtra("name", username);
        startActivity(newIntent);
        */
    }

}