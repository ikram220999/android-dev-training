package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// sharedpreference

public class Day7_Shared_Preferences extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etEmail;
    Button btnSave, btnGet;

    // create object sharedpreferences
    SharedPreferences sharedPref;
    final String SP_FILE = "shared_pref_file";
    String name_key = "name_key", email_key = "email_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day7_shared_preferences);

        etName = findViewById(R.id.etNameSp);
        etEmail = findViewById(R.id.etEmailSp);
        btnSave = findViewById(R.id.btnSaveSp);
        btnGet = findViewById(R.id.btnGetSp);

        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);

        // initialize object sharedprof
        sharedPref = getSharedPreferences(SP_FILE, MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSaveSp:
                String nameStr = etName.getText().toString(),
                        emailStr = etEmail.getText().toString();

                // create object editor -insert data into shared preference file
                SharedPreferences.Editor editor = sharedPref.edit();

                // save the data into sp
                editor.putString(name_key, nameStr);
                editor.putString(email_key, emailStr);

                // call commit()  to execute operation
                editor.commit();

                // clear all data in edittext
                etName.setText("");
                etEmail.setText("");
                break;
            case R.id.btnGetSp:

                etName.setText(sharedPref.getString(name_key, ""));
                etEmail.setText(sharedPref.getString(email_key,""));
                break;

        }
    }
}