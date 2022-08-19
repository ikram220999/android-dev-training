package zombi.kampung.pisang22.jamburock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

// menu = android resource
// menu can only be access by activities that inflate/embed  the menu
//  type of menu:
// 1. flow menu - usually use for setting
// 2. context menu - appears when users long click on item
// 3. pop up menu - appears when users click on a button

public class Day4_Menu extends AppCompatActivity implements View.OnClickListener {

    ListView lvList;
    Button btnPopup;
    ImageView ivImage;
    ConstraintLayout myLayout;
    Toolbar toolbar;

    ArrayList<String> listview_Item; // array to store items for listview
    ArrayAdapter<String> adapter; // to display items in listview


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4_menu);

        lvList = findViewById(R.id.lvList);
        btnPopup = findViewById(R.id.btnPopUp);
        ivImage = findViewById(R.id.ivImage);
        myLayout = findViewById(R.id.myLayout);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);

        btnPopup.setOnClickListener(this);

        // initialize arrayList
        listview_Item = new ArrayList<>();

        // create items for listview
        listview_Item.add("Baju");
        listview_Item.add("Seluar");
        listview_Item.add("Skirt");
        listview_Item.add("Shawl");
        listview_Item.add("Kasut");

        //set up adapter for listview
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,
                listview_Item);

        // attach adapter to listview
        lvList.setAdapter(adapter);

        // register context menu of listview
        registerForContextMenu(lvList);


        // calling this activity's function to
        // use ActionBar utility methods
//        ActionBar actionBar = getSupportActionBar();
//
//        // methods to display the icon in the ActionBar
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);

    }

    @Override
    public void onClick(View view) {
        // inflate menu

        // create popup menu
        PopupMenu pop = new PopupMenu(getApplicationContext(), view);

        //inflate pop up menu from resource
        pop.getMenuInflater().inflate(R.menu.pop_up_menu, pop.getMenu());

        // set listener
        PopUpMenuEventHandler handler = new PopUpMenuEventHandler(getApplicationContext());
        pop.setOnMenuItemClickListener(handler);

        // show popup menu
        pop.show();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        //inflate flow menu into activity
        getMenuInflater().inflate(R.menu.flow_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Toast.makeText(getApplicationContext(),"Setting...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.other:
                Toast.makeText(getApplicationContext(),"Other...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.up:
                // increase size imageview
                ivImage.getLayoutParams().height = 400;
                ivImage.getLayoutParams().width = 400;
                ivImage.requestLayout();
                break;
            case R.id.down:
                ivImage.getLayoutParams().height = 200;
                ivImage.getLayoutParams().width = 200;
                ivImage.requestLayout();
                break;
            case R.id.red:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                myLayout.setBackgroundColor(Color.RED);

                break;
            case R.id.green:

                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                myLayout.setBackgroundColor(Color.GREEN);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // inflate context menu
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // set listener for context menu

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // to access to field position
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.delete:
                // remove item from arraylist
                listview_Item.remove(info.position);

                // notify the changes to listview
                // listview will refresh the list items
                adapter.notifyDataSetChanged();

                // notify user about changes - Toast, snackbar
                Toast.makeText(getApplicationContext(), "Item successfully deleted", Toast.LENGTH_SHORT).show();

                break;

            case R.id.add:
                break;
        }

        return super.onContextItemSelected(item);
    }
}