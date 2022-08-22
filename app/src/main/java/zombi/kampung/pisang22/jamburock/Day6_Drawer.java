package zombi.kampung.pisang22.jamburock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Day6_Drawer extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navView;
    ActionBarDrawerToggle togglebtn;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day6_drawer);

        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.navigation_view);

        // create toggle buton
        togglebtn = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close);

        // add toggle button ito drawer layout
        drawerLayout.setDrawerListener(togglebtn);

        // sync state
        togglebtn.syncState();

        // to create back button to return to home when toggle btn is clicked
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set listener for nav view to make the menu item functioning

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.sent_mail:
                        Toast.makeText(getApplicationContext(),"Sent Mail.. ",
                                Toast.LENGTH_SHORT ).show();

                        // hide nav
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.outbox:
                        Toast.makeText(getApplicationContext(),"Outbox.. ",
                                Toast.LENGTH_SHORT ).show();

                        // hide nav
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.spam_mail:
                        Toast.makeText(getApplicationContext(),"Spam mail.. ",
                                Toast.LENGTH_SHORT ).show();

                        // hide nav
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.calendar2:
                        Toast.makeText(getApplicationContext(),"Calendar drawer.. ",
                                Toast.LENGTH_SHORT ).show();

                        // hide nav
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.contact2:
                        Toast.makeText(getApplicationContext(),"Contact drawer.. ",
                                Toast.LENGTH_SHORT ).show();

                        // hide nav
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.setting2:
                        Toast.makeText(getApplicationContext(),"Seting drawer.. ",
                                Toast.LENGTH_SHORT ).show();

                        // hide nav
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (togglebtn.onOptionsItemSelected()) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}