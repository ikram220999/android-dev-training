package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Day4_ProgressBar extends AppCompatActivity {

    // step2
    ImageView ivBg;
    ProgressBar pbProgress;
    TextView tvStatus;
    Handler handler = new Handler();
    int progressStatus = 0;
    MediaPlayer lagu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4_progress_bar);

        pbProgress = findViewById(R.id.pbProgress);
        tvStatus = findViewById(R.id.tvStatus);
        ivBg = findViewById(R.id.ivBg);

        // initialize lagu
        lagu = MediaPlayer.create(this, R.raw.bg_sound);

        // start lagu
        lagu.start();

        // create new thread to run progressbar & lagu
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus++;

                    // update progress status in textview
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // set progress status
                            pbProgress.setProgress(progressStatus);

                            // show
                            tvStatus.setText(progressStatus + " %");
                            // tvStatus.setText(progressStatus + "/" + pbProgress.getMax());

                            if(progressStatus % 2 == 0 ){
                                ivBg.setScaleX(-1);

                            } else {
                                ivBg.setScaleX(1);

                            }

                            // check if progress reach 100 , start list activity
                            if (progressStatus == 100) {
                                Intent myIntent = new Intent(Day4_ProgressBar.this, List_Activity.class);
                                startActivity(myIntent);

                            }
                        }
                    }); // end of handler.post()
                    // update progress status every 200 ms
                    // 1000 milisecond  = 1 second
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }).start(); // start thread
    } // end of onCreate()

    @Override
    protected void onPause() {
        super.onPause();
        lagu.stop();
        finish();
    }
}