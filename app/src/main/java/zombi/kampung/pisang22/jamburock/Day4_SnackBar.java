package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Day4_SnackBar extends AppCompatActivity implements View.OnClickListener {

    CoordinatorLayout coordinatorLayout;
    Button btnDefault, btnWithAction, btnCustomized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4_snack_bar);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        btnDefault =findViewById(R.id.btnDefault);
        btnWithAction = findViewById(R.id.btnWithAction);
        btnCustomized = findViewById(R.id.btnCustomized);

        btnDefault.setOnClickListener(this);
        btnWithAction.setOnClickListener(this);
        btnCustomized.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Snackbar snackbar = null;

        switch (view.getId()) {
            case R.id.btnDefault:
                snackbar = Snackbar.make(coordinatorLayout, "This is a default Snackbar", BaseTransientBottomBar.LENGTH_LONG);
                break;
            case R.id.btnWithAction:

                snackbar = Snackbar.make(coordinatorLayout, "This is a snackbar with action ", BaseTransientBottomBar.LENGTH_LONG);

                snackbar.setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Try again ... ",
                                Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.btnCustomized:
                snackbar = Snackbar.make(coordinatorLayout, " This is customized snackbar", Snackbar.LENGTH_SHORT);

                snackbar.setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Try again ... ",
                                Toast.LENGTH_LONG).show();
                    }
                });

                // change text color for action
                snackbar.setActionTextColor(Color.RED);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);

                // add icon
                View icon = snackbar.getView();
                TextView textview = icon.findViewById(com.google.android.material.R.id.snackbar_text);
                textview.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.star_big_on,
                        0,0,0);
                break;

        }

        snackbar.show();
    }
}