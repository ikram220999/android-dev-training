package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

// recycler view i a widget to display a large dataset by scrolling

public class Day6_RecyclerView extends AppCompatActivity {

    // declare variable
    RecyclerView recyclerView;
    String[] title, description;
    int[] images = {R.drawable.a, R.drawable.b, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day6_recyclerview);

        recyclerView = findViewById(R.id.recycler_view);

        // get the dataaset - array_title & array_description from strings.xml bind to title &
        // description
        title = getResources().getStringArray(R.array.array_title);
        description = getResources().getStringArray(R.array.array_description);

        // create object of class RecyclerViewAdapter - holds main layout for recyclerview
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(title, description, images, this);


        // attach adapter to recyclerview
        recyclerView.setAdapter(adapter);

        // set layout for recyclerview- macam mana nak paparkan item dalam dataset
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }
}