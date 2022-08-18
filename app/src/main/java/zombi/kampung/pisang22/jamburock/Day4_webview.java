package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Day4_webview extends AppCompatActivity {

    WebView wvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4_webview);

        wvWeb = findViewById(R.id.wvWeb);


        wvWeb.loadUrl("http://www.google.com");
    }
}