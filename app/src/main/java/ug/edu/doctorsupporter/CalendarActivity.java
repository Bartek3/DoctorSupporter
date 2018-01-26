package ug.edu.doctorsupporter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarActivity extends AppCompatActivity {

    CalendarView CalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        CalendarView = findViewById(R.id.CalendarView);

        CalendarView cv = this.findViewById(R.id.CalendarView);
        ViewGroup vg = (ViewGroup) cv.getChildAt(0);
        View month = vg.getChildAt(0);

        ViewGroup days = (ViewGroup) cv.getChildAt(0);
        View day = days.getChildAt(6);

        if(month instanceof TextView) {
            ((TextView)month).setTextColor(getResources().getColor(R.color.colorWhite));
        }

        if(day instanceof TextView) {
            ((TextView)day).setTextColor(getResources().getColor(R.color.colorWhite));
        }

        CalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "Nie masz żadnych zaplanowanych wydarzeń na ten dzień!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
