package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

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

        btnPopup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}