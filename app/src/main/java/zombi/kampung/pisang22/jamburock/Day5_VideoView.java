package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Day5_VideoView extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day5_video_view);

        videoView = findViewById(R.id.videoView);

        // media controller
        MediaController controller = new MediaController(this );

        // include video
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jj));

        // include media controller
        videoView.setMediaController(controller);

        // start video
        videoView.start();
    }
}