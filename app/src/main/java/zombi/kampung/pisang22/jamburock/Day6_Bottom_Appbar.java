package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class Day6_Bottom_Appbar extends AppCompatActivity {


    BottomAppBar bottom_appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day6_bottom_appbar);


        bottom_appbar = findViewById(R.id.bottom_appbar);


        // set listener
        bottom_appbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.setting:
                        Toast.makeText(getApplicationContext(), "Setting..", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.camera:
                        Toast.makeText(getApplicationContext(), "Camera..", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.contact:
                        Toast.makeText(getApplicationContext(), "Contact..", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}