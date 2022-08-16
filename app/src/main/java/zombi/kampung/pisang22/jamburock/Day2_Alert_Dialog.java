package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//s1
public class Day2_Alert_Dialog extends AppCompatActivity implements View.OnClickListener {

    //s2
    Button btnDialog, btnAlert;

    //s3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //s4
        setContentView(R.layout.activity_day2_alert_dialog);

        //s5 : find widget
        btnDialog = findViewById(R.id.btnDialog);
        btnAlert = findViewById(R.id.btnAlert);

        //s6 : set listener
        btnDialog.setOnClickListener(this);
        btnAlert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDialog:

                Dialog myDialog = new Dialog( this);

                myDialog.setTitle("Warning");

                TextView msg = new TextView(this);
                msg.setText("PLease wear a mask");
                myDialog.setContentView(msg);

                myDialog.show();
                break;
            case R.id.btnAlert:

                AlertDialog.Builder myAlert = new AlertDialog.Builder(this);

                myAlert.setIcon(R.drawable.ic_launcher_foreground);

                myAlert.setTitle("Warning");

                myAlert.setMessage("Are you sure you want to quit ?");

                myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Day2_Alert_Dialog.this.finish();
                    }
                });

                myAlert.setNegativeButton("No", null);

                myAlert.show();

                break;
        }
    }
}