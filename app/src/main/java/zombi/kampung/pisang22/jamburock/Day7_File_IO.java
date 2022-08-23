package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Day7_File_IO extends AppCompatActivity implements View.OnClickListener {


    EditText etFilenameWrite, etFilenameRead, etText;
    Button btnWrite, btnRead;
    TextView tvDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day7_file_io);

        etFilenameWrite = findViewById(R.id.etFilenameWrite);
        etFilenameRead = findViewById(R.id.etFilenameRead);
        etText = findViewById(R.id.etText);
        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        tvDisplayText = findViewById(R.id.tvDisplayText);

        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWrite:

                String fname = etFilenameWrite.getText().toString(),
                        ftext = etText.getText().toString();

                // set mode to MODE_PRIVATE - default mode
                // - can only be accessed by the calling app
                // to allow read/write
                try {
                    FileOutputStream fileout = openFileOutput(fname, MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);

                    // write text into file
                    outputWriter.write(ftext);
                    outputWriter.close();

                    // display toast to inform users the status
                    Toast.makeText(this, "File successfully saved",
                            Toast.LENGTH_SHORT).show();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btnRead:

                String fnameRead = etFilenameRead.getText().toString();
                try {
                    FileInputStream finput = openFileInput(fnameRead);

                    int c;
                    String temp = "";

                    // start raad text in file by character and pass the whole text to temp
                    while ((c = finput.read()) != -1) {
                        temp += Character.toString((char) c);
                    }

                    // display text in textview
                    tvDisplayText.setText(temp);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}