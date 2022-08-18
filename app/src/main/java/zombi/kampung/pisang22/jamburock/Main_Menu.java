package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Menu extends AppCompatActivity implements View.OnClickListener {

    Button btnGo, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        btnGo = findViewById(R.id.btnGo);
        btnCancel = findViewById(R.id.btnCancel);

        btnGo.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent myIntent = null;

        switch (view.getId()) {
            case R.id.btnGo:
                myIntent = new Intent(this, List_menu.class);
                break;
            case R.id.btnCancel:
                myIntent = new Intent(this, List_Activity.class);
                finish();
                break;
        }

        startActivity(myIntent);
    }
}