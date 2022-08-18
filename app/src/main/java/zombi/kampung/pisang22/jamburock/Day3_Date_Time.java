package zombi.kampung.pisang22.jamburock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class Day3_Date_Time extends AppCompatActivity implements CalendarView.OnDateChangeListener, TimePicker.OnTimeChangedListener {

    TextView tvDate, tvTime;
    CalendarView cvDate;
    TimePicker tpTime;

    // create object of DateFormat class - to format data and time display
    DateFormat df1 = DateFormat.getDateInstance(),
            df2 =  DateFormat.getTimeInstance();

    // create object of calendar class - to have access to fields : DAY_OF_MONTH, MONTH, YEAR
    Calendar cal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day3_date_time);

        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        cvDate = findViewById(R.id.cvDate);
        tpTime = findViewById(R.id.tpTime);

        cvDate.setOnDateChangeListener(this);
        tpTime.setOnTimeChangedListener(this);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
        //i -> year, i1 -> month, i2 -> date of month
        cal.set(Calendar.YEAR, i);
        cal.set(Calendar.MONTH, i1);
        cal.set(Calendar.DAY_OF_MONTH, i2);

        //display the values
        tvDate.setText(df1.format(cal.getTime()));
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        cal.set(Calendar.HOUR, i);
        cal.set(Calendar.MINUTE, i1);

        tvTime.setText(df2.format(cal.getTime()));
    }
}