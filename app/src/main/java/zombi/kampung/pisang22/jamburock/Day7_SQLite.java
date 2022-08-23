package zombi.kampung.pisang22.jamburock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Day7_SQLite extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etPhone, etId;
    Button btnInsert, btnView, btnDelete, btnGetData, btnEdit;
    String allData = "";

    // initialize object of db handling
    DB_Handling entry = new DB_Handling(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day7_sqlite);

        etName = findViewById(R.id.etNameSql);
        etPhone = findViewById(R.id.etPhoneSql);
        etId = findViewById(R.id.etIdSql);
        btnInsert = findViewById(R.id.btnInsertSql);
        btnView = findViewById(R.id.btnViewSql);
        btnDelete = findViewById(R.id.btnDeleteSql);
        btnGetData =findViewById(R.id.btnGetDataSql);
        btnEdit = findViewById(R.id.btnEditSql);

        btnInsert.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnGetData.setOnClickListener(this);
        btnEdit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String strName = etName.getText().toString(),
                strTelno = etPhone.getText().toString(),
                strId = etId.getText().toString();

        int id;

        switch (view.getId()) {
            case R.id.btnInsertSql:
                entry.openDB();
                entry.insertData(strName, strTelno);
                entry.closeDB();

                Toast.makeText(this, "Data successfully inserted",
                        Toast.LENGTH_SHORT).show();

                etName.setText("");
                etPhone.setText("");
                etId.setText("");
                etName.setFocusable(true);

                break;
            case R.id.btnViewSql:
                entry.openDB();
                allData = entry.getAllData();
                entry.closeDB();

                // start new activity - viewData
                Intent myIntent = new Intent(this, ViewData.class);
                Bundle container = new Bundle();
                container.putString("kunci", allData);
                myIntent.putExtras(container);

                startActivity(myIntent);

                break;
            case R.id.btnDeleteSql:

                try {


                    id = Integer.parseInt(strId);

                    entry.openDB();
                    entry.deleteData(id);
                    entry.closeDB();

                    Toast.makeText(this, "Data succesfully updated",
                            Toast.LENGTH_SHORT).show();

                    etName.setText("");
                    etPhone.setText("");
                    etId.setText("");
                    etName.setFocusable(true);
                } catch (Exception e) {
                    Toast.makeText(this, "Invalid ID",
                            Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnGetDataSql:
                try {
                    id = Integer.parseInt(strId);

                    entry.openDB();

                    String nameStr = entry.getName(id),
                            telnoStr = entry.getTelNo(id);

                    entry.closeDB();

                    etName.setText(nameStr);
                    etPhone.setText(telnoStr);

                } catch (Exception e) {
                    Toast.makeText(this, "invalid id !",
                            Toast.LENGTH_SHORT).show();

                    etName.setText("");
                    etPhone.setText("");
                    etId.setText("");
                    etName.setFocusable(true);
                }

                break;
            case R.id.btnEditSql:
                try {


                    id = Integer.parseInt(strId);

                    entry.openDB();
                    entry.updateData(id, strName, strTelno);
                    entry.closeDB();

                    Toast.makeText(this, "Data succesfully updated",
                            Toast.LENGTH_SHORT).show();

                    etName.setText("");
                    etPhone.setText("");
                    etId.setText("");
                    etName.setFocusable(true);
                } catch (Exception e) {
                    Toast.makeText(this, "Invalid ID",
                            Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }
}