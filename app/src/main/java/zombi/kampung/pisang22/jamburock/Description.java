package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Description extends AppCompatActivity {

    ImageView ivImage;
    TextView tvTitle, tvDesc;
    int image;
    String title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        ivImage = findViewById(R.id.ivimage);
        tvTitle = findViewById(R.id.tvTitle);
        tvDesc = findViewById(R.id.tvDesc);

        // create methods to get data from intent
        getData();
        displayData();
    }

    private void getData() {
        // check if intent has data or not
        if (getIntent().hasExtra("key_title") && getIntent().hasExtra("key_desc")
                && getIntent().hasExtra("key_image")) {

            // if has dat, get the data
            title = getIntent().getStringExtra("key_title");
            description = getIntent().getStringExtra("key_desc");
            image = getIntent().getIntExtra("key_image", 1);
        }
        else {
            Toast.makeText(this, "No data found !", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayData() {
       // display data
        tvTitle.setText(title);
        tvDesc.setText(description);
        ivImage.setImageResource(image);

    }
}