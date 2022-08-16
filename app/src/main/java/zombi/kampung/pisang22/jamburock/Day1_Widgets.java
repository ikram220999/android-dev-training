package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

//how to call resource :
//R.[resource_type].[resource_name/file]
//R.layout.day1_widgets:
//R.drawable.mypic


// step 1 : class declaration
public class Day1_Widgets extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    // step 2 : variables declaration
    EditText etName, etStudNo;
    Spinner spCourse;
    RadioGroup rgMode;
    RadioButton rbFull, rbPart;
    CheckBox cbTerm;
    Button btnSubmit, btnReset;
    TextView tvDisplay;
    String strStudInfo, strCourse, strFull, strPart;


    // step 3 : override onCreate()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //step 4 : call the layout using setContentView()
        setContentView(R.layout.day1_widgets);

        //step 5 : call the widget from the layout

        etName = findViewById(R.id.etName);
        etStudNo = findViewById(R.id.etStudNo);
        spCourse = findViewById(R.id.spCourse);
        rgMode = findViewById(R.id.rgMode);
        rbFull = findViewById(R.id.rbFull);
        rbPart = findViewById(R.id.rbPart);
        cbTerm = findViewById(R.id.cbTerm);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);
        tvDisplay = findViewById(R.id.tvDisplay);


        //step 6 : set listener for the widgets
        btnSubmit.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        spCourse.setOnItemSelectedListener(this);
        rgMode.setOnCheckedChangeListener(this);
        cbTerm.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
        // implementation for button - btnsubmit, btnreset
        // get the input from edittext

        String strName = etName.getText().toString(),
                strStudNo = etStudNo.getText().toString();

        // display input in textview
        switch (view.getId()) {
            case R.id.btnSubmit:

                //checking form cannot be empty
                if (strName.equals("") || strStudNo.equals("")) {
                    Snackbar mySnackbar = Snackbar.make(view, "please fill in the form", 2000);

                    mySnackbar.show();
                } else {
                    //display input in textview
                    strStudInfo = "- Student info -\nStudent Name : " + strName + "\nStudent Number : "
                            + strStudNo + "\n" + "Course : " + strCourse;

                    if ( rbFull.isChecked()) {
                        strStudInfo += "\nStudy Mode : "  + strFull;
                    }else{
                        strStudInfo += "\nStudy Mode : " + strPart + "\n";
                    }
                    tvDisplay.setText(strStudInfo);
                }

                break;
            case R.id.btnReset:
                // reset form and display
                tvDisplay.setText("");
                etName.setText("");
                etStudNo.setText("");
                spCourse.setSelection(0);
                rgMode.clearCheck();
                cbTerm.setChecked(false);
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // get the value from the items from the spinner

        strCourse = adapterView.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        // i = id radiobutton yg ada dlm radiogroup

        switch (i) {
            case R.id.rbFull:
                //dptkan text value radio tu
                strFull = rbFull.getText().toString();
                break;
            case R.id.rbPart:
                strPart = rbPart.getText().toString();
                break;
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Toast myToast;
        if (b) {
            myToast = Toast.makeText(this, "You have agreed to our T&C",
                    Toast.LENGTH_SHORT);
        }else{
            myToast = Toast.makeText(this, "You must agreed to our T&C",
                    Toast.LENGTH_SHORT);
        }

        //change position of the Toast
        //by default - toast will be displayed at bottom screen
        myToast.setGravity(Gravity.TOP, 0, 100);

        myToast.show();
    }
}