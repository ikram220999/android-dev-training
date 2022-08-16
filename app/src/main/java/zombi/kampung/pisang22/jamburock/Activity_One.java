package zombi.kampung.pisang22.jamburock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_One extends AppCompatActivity{

    Button btnAct1;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        btnAct1 = findViewById(R.id.btnAct1);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actTwo = new Intent(Activity_One.this, Activity_Two.class);
                startActivityIfNeeded(actTwo, 999999999); //requestcode = 0-99999999999 = +ve no
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            //get data from intent
            Bundle almari = data.getExtras();

            // display text in textview
            String strData = almari.getString("ikram");
            tvDisplay.setText(strData);
        }
    }
}