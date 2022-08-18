package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Order_Detail extends AppCompatActivity implements View.OnClickListener {

    TextView tvOrder;
    Button btnOrderAgain, btnMainMenu, btnRating;
    RatingBar rtRating;
    McDonny myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);

        tvOrder = findViewById(R.id.tvOrder);
        btnOrderAgain = findViewById(R.id.btnOrderAgain);
        btnMainMenu = findViewById(R.id.btnMainMenu);
        btnRating = findViewById(R.id.btnRating);
        rtRating = findViewById(R.id.rtRating);

        btnOrderAgain.setOnClickListener(this);
        btnMainMenu.setOnClickListener(this);
        btnRating.setOnClickListener(this);

        myOrder = (McDonny) getIntent().getSerializableExtra("kunci");

        if(myOrder == null) {
            myOrder = new McDonny();
        }

        String displayText = "Combo Meal : " + myOrder.combo_meal
                + "\n\nCombo Size : " + myOrder.combo_size
                + "\n\nQuantiy : " + myOrder.quantity
                + "\n\nAdd-ons : \n";

        // enhanced for-loop to get the items for arrayList
        for (String arrayItem : myOrder.add_on) {
            displayText += " - " + arrayItem + "\n";
        }

        DecimalFormat df = new DecimalFormat("0.00");

        // concat total price
        displayText += "\nTotal Price : RM " + df.format(myOrder.calculatePrice(myOrder.quantity));

        //display textview
        tvOrder.setText(displayText);

    }

    @Override
    public void onClick(View view) {

        Intent myIntent = null;

        switch (view.getId()) {
            case R.id.btnOrderAgain:
                myIntent = new Intent(this, List_menu.class);
                startActivity(myIntent);
                break;
            case R.id.btnMainMenu:
                myIntent = new Intent(this, Main_Menu.class);
                startActivity(myIntent);
                break;
            case R.id.btnRating:

                //get rating value
                String strRating = String.valueOf(rtRating.getRating());

                // display the rating value in toast
                Toast.makeText(this, strRating, Toast.LENGTH_SHORT).show();
                break;
        }


    }
}