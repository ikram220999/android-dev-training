package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class List_menu extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    RadioGroup rgMeal;
    RadioButton rbAyam, rbDaging, rbArnab, rbUnta;
    EditText etQuantity;
    Button btnMeal;

    McDonny myOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_menu);

        rgMeal = findViewById(R.id.rgMeal);
        rbAyam = findViewById(R.id.rbAyam);
        rbDaging = findViewById(R.id.rbDaging);
        rbArnab = findViewById(R.id.rbArnab);
        rbUnta = findViewById(R.id.rbUnta);
        etQuantity = findViewById(R.id.etQuantity);
        btnMeal = findViewById(R.id.btnMeal);

        btnMeal.setOnClickListener(this);
        rgMeal.setOnCheckedChangeListener(this);

        myOrder = (McDonny) getIntent().getSerializableExtra("kunci");

        if (myOrder == null) {
            myOrder = new McDonny();
        }

    }

    @Override
    public void onClick(View view) {
        myOrder.quantity = Integer.parseInt(etQuantity.getText().toString());

        Intent myIntent = new Intent(this, size_menu.class);

        //assign myOrder to myIntent
        myIntent.putExtra("kunci", myOrder);

        startActivity(myIntent);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case  R.id.rbAyam:
                myOrder.combo_meal = rbAyam.getText().toString();
                break;
            case  R.id.rbDaging:
                myOrder.combo_meal = rbDaging.getText().toString();
                break;
            case  R.id.rbArnab:
                myOrder.combo_meal = rbArnab.getText().toString();
                break;
            case  R.id.rbUnta:
                myOrder.combo_meal = rbUnta.getText().toString();
                break;

        }
    }


}