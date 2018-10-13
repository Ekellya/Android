package com.arsakova.autum_workout_1.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.model.Workout;

import java.util.Date;

public class WorkoutDetailPullUpsActivity extends AppCompatActivity {

    private TextView title;
    private TextView recordDate;
    private TextView recordRepsCount;
    private TextView description;
    private ImageView image;
    private EditText repsCountEditText;
    private Button saveRecordButton;
    private ImageButton shareButton;
    Workout workout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = new Configuration();
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_workout_detail_pull_ups);
        workout = new Workout("Pull ups", "x", 0, new Date(), 0);
        initGUI(workout);
        addListeners();

    }

    private void addListeners() {
        saveRecordButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecord();
            }
        });
        shareButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareRecord();
            }
        });
    }

    private void shareRecord() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Поделиться");
        sendIntent.setType("text/plain");
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }


    private void saveRecord() {
        workout.setRecordRepsCount(Integer.parseInt(repsCountEditText.getText().toString()));
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
    }

    private void initGUI(Workout workout) {

        title = findViewById(R.id.workout_detail_title);
        title.setText(workout.getTitle());
        recordDate = findViewById(R.id.workout_detail_record_date);
        recordDate.setText(workout.getFormattedRecordDate());
        recordRepsCount = findViewById(R.id.workout_detail_record_reps_count);
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
        description = findViewById(R.id.workout_detail_description);
        description.setText(workout.getDescription());

        repsCountEditText = findViewById(R.id.workout_detail_reps_count_edit_text);
        saveRecordButton = findViewById(R.id.workout_detail_save_button);
        shareButton = findViewById(R.id.button_share);
    }
}


// сделать переменную подходов, добавить кнопку "добавить подход"
// с возможностью введения количества подтягиваний, отжиманий и тд.
// и выводить их сумму в инфо
// при нажатии на кнопку "сохранить" отправлять в рекорды сумму и самую длинную последовательность
