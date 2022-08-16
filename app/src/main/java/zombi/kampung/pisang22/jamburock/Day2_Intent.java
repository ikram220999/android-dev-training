package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Day2_Intent extends AppCompatActivity implements View.OnClickListener {


    Button btnImplicit, btnExplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day2_intent);

        btnImplicit = findViewById(R.id.btnImplicit);
        btnExplicit = findViewById(R.id.btnExplicit);

        btnImplicit.setOnClickListener(this);
        btnExplicit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnImplicit:

                Intent implicitIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456788"));
                startActivity(implicitIntent);

                break;

            case R.id.btnExplicit:
//
//                Intent explicitIntent = new Intent("android.intent.action.WIDGETS");
//                startActivity(explicitIntent);
//
                Intent explicitIntent = new Intent(Day2_Intent.this, Day1_Widgets.class);
                startActivity(explicitIntent);


                break;
        }
    }
}