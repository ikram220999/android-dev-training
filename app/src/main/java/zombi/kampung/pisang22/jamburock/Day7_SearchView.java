package zombi.kampung.pisang22.jamburock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Day7_SearchView extends AppCompatActivity {

    ListView lvData;
    ArrayAdapter<String> adapter;
    ArrayList<String> myList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day7_search_view);

        lvData = findViewById(R.id.lvData2);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        //initialize arraylist
        myList = new ArrayList<>();

        //create dataset
        myList.add("Makan2");
        myList.add("Minum3");
        myList.add("Makan3");
        myList.add("Minum2");
        myList.add("Nasi-Goreng");
        myList.add("Goreng-Ikan");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);

        lvData.setAdapter(adapter);


    }
    //create search menu
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        //inflate menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchview_menu, menu);

        //initialize  menu item
        MenuItem searchviewItem = menu.findItem(R.id.search_bar);

        //get search view item
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchviewItem);

        //set listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (myList.contains(s)){
                    adapter.getFilter().filter(s);
                }else {
                    Toast.makeText(Day7_SearchView.this, "Data not Found 404", Toast.LENGTH_SHORT).show();
                    //getapplicationcontext
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}