package zombi.kampung.pisang22.jamburock;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    // create array for fragment title
    String[] fragment_title = {"Fragment 1", "Fragment 2", "Fragment 3"};

    // constructor
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
            // masukkan fragment 1
                return new Fragment_1();
            case 1:
                return new Fragment_2();
            case 2:
                return new Fragment_3();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
