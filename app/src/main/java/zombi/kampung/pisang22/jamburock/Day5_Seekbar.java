package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Day5_Seekbar extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    TextView tvText, tvProgress;
    SeekBar seek_bar;

    int progressValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day5_seekbar);

        tvProgress = findViewById(R.id.tvProgress);
        tvText = findViewById(R.id.tvText);
        seek_bar = findViewById(R.id.seek_bar);

        seek_bar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        progressValue = i;
        // change text size = i
        tvText.setTextSize(i);

        if(progressValue % 3 == 0) {
            tvText.setTextColor(Color.BLUE);
        } else if ( progressValue % 2 == 0 ) {
            tvText.setTextColor(Color.RED);
        } else if ( progressValue % 5 == 0) {
            tvText.setTextColor(Color.GREEN);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // auto called when user touch seekbar
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // display progress value in textview
        tvProgress.setText( progressValue + "/" + seek_bar.getMax());
    }
}