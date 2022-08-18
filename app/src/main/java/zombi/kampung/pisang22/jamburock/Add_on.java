package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Add_on extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    CheckBox chkSayoq, chkSos, chkCheese, chkRoti;
    Button btnAddOn;

    McDonny myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_on);

        chkSayoq = findViewById(R.id.chkSayoq);
        chkSos = findViewById(R.id.chkSos);
        chkCheese = findViewById(R.id.chkCheese);
        chkRoti = findViewById(R.id.chkRoti);
        btnAddOn = findViewById(R.id.btnAddOn);

        btnAddOn.setOnClickListener(this);
        chkSayoq.setOnCheckedChangeListener(this);
        chkSos.setOnCheckedChangeListener(this);
        chkCheese.setOnCheckedChangeListener(this);
        chkRoti.setOnCheckedChangeListener(this);

        myOrder = (McDonny) getIntent().getSerializableExtra("kunci");

        if (myOrder == null) {
            myOrder = new McDonny();
        }
    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(this, Order_Detail.class);
        myIntent.putExtra("kunci", myOrder);
        startActivity(myIntent);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.chkSayoq:
                if(b) {
                    myOrder.add_on.add(chkSayoq.getText().toString());
                }else{
                    myOrder.add_on.remove(myOrder.add_on.indexOf(chkSayoq.getText().toString()));
                }
                break;
            case R.id.chkSos:
                if(b) {
                    myOrder.add_on.add(chkSos.getText().toString());
                }else{
                    myOrder.add_on.remove(myOrder.add_on.indexOf(chkSos.getText().toString()));
                }
                break;
            case R.id.chkCheese:
                if(b) {
                    myOrder.add_on.add(chkCheese.getText().toString());
                }else{
                    myOrder.add_on.remove(myOrder.add_on.indexOf(chkCheese.getText().toString()));
                }
                break;
            case R.id.chkRoti:
                if(b) {
                    myOrder.add_on.add(chkRoti.getText().toString());
                }else{
                    myOrder.add_on.remove(myOrder.add_on.indexOf(chkRoti.getText().toString()));
                }
                break;

        }
    }
}