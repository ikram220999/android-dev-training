package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class size_menu extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    RadioGroup rgSize;
    RadioButton rbSmall, rbMedium, rbLarge;
    Button btnSize;

    McDonny myOrder;

    TextView tvSeekSize;
    SeekBar sbSize;
    int seekValue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.size_menu);

        rgSize = findViewById(R.id.rgSize);
        rbSmall = findViewById(R.id.rbSmall);
        rbMedium = findViewById(R.id.rbMedium);
        rbLarge = findViewById(R.id.rbLarge);
        btnSize = findViewById(R.id.btnSize);
        sbSize = findViewById(R.id.sbSize);
        tvSeekSize = findViewById(R.id.tvSeekSize);

        btnSize.setOnClickListener(this);
        rgSize.setOnCheckedChangeListener(this);
        sbSize.setOnSeekBarChangeListener(this);

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
//        switch (i) {
//            case R.id.rbSmall:
//                myOrder.combo_size = rbSmall.getText().toString();
//                break;
//            case R.id.rbMedium:
//                myOrder.combo_size = rbMedium.getText().toString();
//
//                break;
//            case R.id.rbLarge:
//                myOrder.combo_size = rbLarge.getText().toString();
//                break;
//
//        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        seekValue = i;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(seekValue == 0) {
            tvSeekSize.setText("Small RM 2.50");
            myOrder.combo_size = "Small RM 2.50";

        } else if (seekValue == 1) {
            tvSeekSize.setText("Medium RM 4.00");
            myOrder.combo_size = "Medium RM 4.00";
        } else {
            tvSeekSize.setText("Large RM 6.00");
            myOrder.combo_size = "Large RM 6.00";

        }
    }
}