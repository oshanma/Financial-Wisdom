package com.example.habit;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText hourlyRateEditText;
    private EditText taxRateEditText;
    private EditText targetAmountEditText;
    private Button datePickerButton;
    private TextView hoursTextView;

    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourlyRateEditText = findViewById(R.id.rate);
        taxRateEditText = findViewById(R.id.tax);
        targetAmountEditText = findViewById(R.id.hour);
        datePickerButton = findViewById(R.id.datePickerButton);
        hoursTextView = findViewById(R.id.hours);

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
    }

    // Rest of the code remains the same
    // ...

    private void showDatePicker() {
        DatePickerDialog datePicker = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    calendar.set(year, month, dayOfMonth);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy", Locale.US);
                    datePickerButton.setText(dateFormat.format(calendar.getTime()));
                    calculateAverageHours();
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePicker.getDatePicker().setMinDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void calculateAverageHours() {
        String hourlyRateStr = hourlyRateEditText.getText().toString();
        String taxRateStr = taxRateEditText.getText().toString();
        String targetAmountStr = targetAmountEditText.getText().toString();

        if (!hourlyRateStr.isEmpty() && !taxRateStr.isEmpty() && !targetAmountStr.isEmpty()) {
            double hourlyRate = Double.parseDouble(hourlyRateStr);
            double taxRate = Double.parseDouble(taxRateStr);
            double targetAmount = Double.parseDouble(targetAmountStr);

            int daysRemaining = daysRemainingUntilDeadline();
            double maxWeeklyHours = 168.0;

            if (daysRemaining > 0) {
                double hoursNeeded = (targetAmount / (hourlyRate * (1 - taxRate / 100)));
                double averageHours = hoursNeeded / (daysRemaining / 7);

                DecimalFormat df = new DecimalFormat("#.##");
                if (averageHours <= maxWeeklyHours) {
                    hoursTextView.setText("Average Hours per week: " + df.format(averageHours));
                } else {
                    hoursTextView.setText("Your hourly rate is low for the target");
                }
            } else {
                hoursTextView.setText("Deadline has already passed");
            }
        }
    }

    private int daysRemainingUntilDeadline() {
        Calendar currentDate = Calendar.getInstance();
        long timeInMillisDifference = calendar.getTimeInMillis() - currentDate.getTimeInMillis();
        return (int) (timeInMillisDifference / (1000 * 60 * 60 * 24));
    }
}
