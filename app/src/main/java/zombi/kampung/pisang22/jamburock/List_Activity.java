package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List_Activity extends ListActivity {

    //create an array to hold all activity name/classname
    String[] activityName = {"Day1_Widgets", "Day2_Intent", "Day2_Alert_Dialog", "Activity_One",
            "Main_Menu", "Day3_Date_Time", "Day4_webview", "Day4_SnackBar", "Day4_Menu",
            "Day5_Seekbar", "Day5_VideoView", "Day5_Fragment", "Day6_RecyclerView", "Day6_Bottom_Appbar",
            "Day6_Drawer", "Day7_SearchView", "Day7_File_IO", "Day7_Shared_Preferences", "Day7_SQLite"
            };

    //activityName[0] = "Day1_Widgets

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create our own layout
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, activityName);

        // display the layout
        setListAdapter(myAdapter);


    }

    // set listener for the listview

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // get the value of the item that has been clicked based on position
        String clickValue = activityName[position]; // [0] -> "Day1_Widgets"

        // convert string clickValue from String -> Class
        try {
            Class className = Class.forName("zombi.kampung.pisang22.jamburock." + clickValue);
            Intent myIntent = new Intent(this, className);
            startActivity(myIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "Activity not found!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}