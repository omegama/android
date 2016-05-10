package itesm.mx.food_station_project;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
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
import android.widget.ImageButton;
import android.widget.Toast;

public class CombosActivity extends FragmentActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combos);

        context = getApplicationContext();


        ImageButton backBtn = (ImageButton) findViewById(R.id.backCombo);
        Button mitadGE = (Button)findViewById(R.id.buttonGE);
        Button mitadGS = (Button)findViewById(R.id.buttonGS);
        Button mitadES = (Button)findViewById(R.id.buttonES);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CombosActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        mitadGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                MitadGEActivity dialogGE = new MitadGEActivity();
                dialogGE.show(manager, "dialogGE");
            }
        });

        mitadGS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                MitadGSActivity dialogGS = new MitadGSActivity();
                dialogGS.show(manager, "dialogGS");
            }
        });

        mitadES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                MitadESActivity dialogES = new MitadESActivity();
                dialogES.show(manager, "dialogES");
            }
        });

    }
}