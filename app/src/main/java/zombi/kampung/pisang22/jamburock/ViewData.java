package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewData extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_data);

        tvData = findViewById(R.id.tvDataa);

        // get data from intent
        Intent i = getIntent();
        Bundle b = i.getExtras();

        tvData.setText(b.getString("kunci"));

    }
}