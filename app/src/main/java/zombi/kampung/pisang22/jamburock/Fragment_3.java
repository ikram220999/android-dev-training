package zombi.kampung.pisang22.jamburock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

// what is fragment
// - independant android component which can be used by activity
// - a fragment can be inflated/embedded into an activity
// - has its own life-cycle
// - Utilize TabLayout and ViewPagerAapter
// - pros:
// - flexibility : fragment can be added and removed
// - reusability : 1 fragment can be used by many activiies
// - 1 activity can have many fragments
// - support different layout for landscape & potrait
// - build single pane layout for phones,multipanelayout for tablets

public class Fragment_3 extends Fragment {

    public Fragment_3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
}