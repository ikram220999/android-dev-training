package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Two extends AppCompatActivity {


    EditText etData;
    Button btnAct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        etData = findViewById(R.id.etData);
        btnAct2 = findViewById(R.id.btnAct2);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actone = new Intent();

                String strData = etData.getText().toString();

                actone.putExtra("ikram", strData);

                setResult(RESULT_OK, actone);

                finish();
            }
        });
    }
}