package sg.edu.rp.c346.id20032316.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etMobile;
    EditText etSize;
    CheckBox cbSmoking;
    DatePicker dp;
    TimePicker tp;
    Button btnSubmit;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etSize = findViewById(R.id.etPax);
        cbSmoking = findViewById(R.id.cbSmoking);
        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        dp.updateDate(2020, 5, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String mobile = etMobile.getText().toString();
                String paxsize = etSize.getText().toString();
                String area = "";

                if (cbSmoking.isChecked()) {
                    area = "smoking";
                } else {
                    area = "non-smoking";
                }


                String message = "Hi " + name + " (" + mobile + ")" + ", you have successfully made a reservation for " + paxsize + " people on " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear()
                        + " at " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + " in " + area + " area. ";

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etMobile.setText("");
                etSize.setText("");
                cbSmoking.setChecked(false);
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });


    }
}