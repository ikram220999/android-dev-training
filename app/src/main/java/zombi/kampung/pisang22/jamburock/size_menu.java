package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class size_menu extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    RadioGroup rgSize;
    RadioButton rbSmall, rbMedium, rbLarge;
    Button btnSize;

    McDonny myOrder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.size_menu);

        rgSize = findViewById(R.id.rgSize);
        rbSmall = findViewById(R.id.rbSmall);
        rbMedium = findViewById(R.id.rbMedium);
        rbLarge = findViewById(R.id.rbLarge);
        btnSize = findViewById(R.id.btnSize);

        btnSize.setOnClickListener(this);
        rgSize.setOnCheckedChangeListener(this);

        myOrder = (McDonny) getIntent().getSerializableExtra("kunci");

        if (myOrder == null) {
            myOrder = new McDonny();
        }

    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(this, Add_on.class);
        myIntent.putExtra("kunci", myOrder);
        startActivity(myIntent);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rbSmall:
                myOrder.combo_size = rbSmall.getText().toString();
                break;
            case R.id.rbMedium:
                myOrder.combo_size = rbMedium.getText().toString();

                break;
            case R.id.rbLarge:
                myOrder.combo_size = rbLarge.getText().toString();
                break;

        }
    }
}