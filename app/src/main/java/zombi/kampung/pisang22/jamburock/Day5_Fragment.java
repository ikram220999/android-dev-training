package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Day5_Fragment extends AppCompatActivity {

    ViewPager2 view_pager;
    TabLayout tabLayout;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day5_fragment);

        view_pager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabLayout);

        // initialize adapter object
        adapter = new ViewPagerAdapter(this);

        // set up adapter
        view_pager.setAdapter(adapter);

        // attach adapter & fragment title to tablayot
        new TabLayoutMediator(tabLayout, view_pager,
                ((tab, position) -> tab.setText(adapter.fragment_title[position]))).attach();
    }
}