package sharukh.bottomslidingdtpicker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.badoualy.datepicker.DatePickerTimeline;

import java.util.Calendar;

public class BottomSlidingDateTimePicker extends BottomSheetDialogFragment {

    private static final String TAG = "BottomSlidingDateTime";
    private static final String INPUT_TITLE = "Title";
    private Calendar selectedCal;
    private OnDateTimeSetListener dateTimeSetListener;

    public static BottomSlidingDateTimePicker newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(INPUT_TITLE, title);
        BottomSlidingDateTimePicker fragment = new BottomSlidingDateTimePicker();
        fragment.setArguments(args);
        return fragment;
    }

    public void setOnDateTimeSetListener(OnDateTimeSetListener onDateTimeSetListener) {
        if (onDateTimeSetListener != null) {
            this.dateTimeSetListener = onDateTimeSetListener;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_date_time_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = "";
        if (getArguments() != null) {
            title = getArguments().getString(INPUT_TITLE);
        }

        final TextView selected_date_time = view.findViewById(R.id.selected_date_time);
        selected_date_time.setText(title);

        selectedCal = Calendar.getInstance();

        DatePickerTimeline date_picker = view.findViewById(R.id.date_picker);

        date_picker.setFirstVisibleDate(selectedCal.get(Calendar.YEAR), selectedCal.get(Calendar.MONTH), selectedCal.get(Calendar.DAY_OF_MONTH));

        date_picker.setOnDateSelectedListener(new DatePickerTimeline.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day, int index) {
                selectedCal.set(Calendar.YEAR, year);
                selectedCal.set(Calendar.MONTH, month);
                selectedCal.set(Calendar.DAY_OF_MONTH, day);
            }
        });


        TimeAdapter adapter = new TimeAdapter(selectedCal.get(Calendar.HOUR_OF_DAY), new TimeAdapter.OnTimeSelectedListener() {
            @Override
            public void onTimeSelected(int hourOfTheDay) {
                selectedCal.set(Calendar.HOUR_OF_DAY, hourOfTheDay);
            }
        });

        RecyclerView time_recycler = view.findViewById(R.id.time_picker);
        time_recycler.scrollToPosition(selectedCal.get(Calendar.HOUR_OF_DAY));
        time_recycler.setAdapter(adapter);


        Button done_button = view.findViewById(R.id.picker_done);
        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateTimeSetListener.onDateTimeSelected(selectedCal);
                dismissAllowingStateLoss();
            }
        });


    }

    public interface OnDateTimeSetListener {
        void onDateTimeSelected(Calendar selectedDateTime);
    }
}
