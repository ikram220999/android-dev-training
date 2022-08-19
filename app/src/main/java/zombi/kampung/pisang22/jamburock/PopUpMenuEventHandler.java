package zombi.kampung.pisang22.jamburock;

import android.content.Context;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopUpMenuEventHandler implements PopupMenu.OnMenuItemClickListener {

    // declare variable context
    Context ctx;

    //create consturctor


    public PopUpMenuEventHandler(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        // implementation for listener
        switch (menuItem.getItemId()) {
            case R.id.option_a:
                Toast.makeText(ctx, "Option A ..", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_b:
                Toast.makeText(ctx, "Option B ..", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
