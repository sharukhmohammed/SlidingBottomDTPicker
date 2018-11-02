package sharukh.bottomslidingdtpickerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import sharukh.bottomslidingdtpicker.BottomSlidingDateTimePicker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView something = findViewById(R.id.something);

        BottomSlidingDateTimePicker bottomSlidingDateTimePicker = BottomSlidingDateTimePicker.newInstance("Title");

        bottomSlidingDateTimePicker.show(getSupportFragmentManager(), "SomeTAG");

        bottomSlidingDateTimePicker.setOnDateTimeSetListener(new BottomSlidingDateTimePicker.OnDateTimeSetListener() {
            @Override
            public void onDateTimeSelected(Calendar selectedDateTime) {

                something.setText(selectedDateTime.getTime().toString());

            }
        });


    }
}
