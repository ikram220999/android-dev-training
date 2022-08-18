package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Day4_webview extends AppCompatActivity {

    WebView wvWeb;
    Button btnGoto;
    EditText etGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4_webview);

        wvWeb = findViewById(R.id.wvWeb);
        btnGoto = findViewById(R.id.btnGoto);
        etGo = findViewById(R.id.etGo);

        //prevent android from starting chrome
        // set this webview as teh client
        wvWeb.setWebViewClient(new WebViewClient());

        btnGoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String go = "https://www.";
                go += etGo.getText().toString();
                go += ".com";
                wvWeb.loadUrl(go);

            }
        });

        // load browser on webview
//        wvWeb.loadUrl("http://www.google.com");

        wvWeb.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //check which button has been clicked
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    // check if browser has history
                    if (wvWeb.canGoBack() == true) {
                        wvWeb.goBack();
                    } else {
                        Intent myIntent = new Intent(this, List_Activity.class);

                        startActivity(myIntent);
                        finish();
                    }

                    return true;

            }
        }
        return super.onKeyDown(keyCode, event);
    }
}