package com.arsakova.autum_workout_1.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.model.Workout;

import java.util.Date;

public class WorkoutDetailJoggingActivity extends AppCompatActivity {


    private TextView title;
    private TextView recordDate;
    private TextView description;

    private ImageView image;

//    private EditText repsCountEditText;
    private Button saveRecordButton;
    Workout workout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = new Configuration();
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_workout_detail_jogging);
        workout = new Workout("jogging","frrr" , 0, new Date(), 0);
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
    }



    private void saveRecord() {

//        workout.setRecordRepsCount(Integer.parseInt(repsCountEditText.getText().toString()));
//        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
    }

    private void initGUI(Workout workout) {

        title = findViewById(R.id.workout_detail_title);
        title.setText(workout.getTitle());
        recordDate = findViewById(R.id.workout_detail_record_date);
        recordDate.setText(workout.getFormattedRecordDate());
        description = findViewById(R.id.workout_detail_description);
        description.setText(workout.getDescription());

//        repsCountEditText = findViewById(R.id.workout_detail_reps_count_edit_text);
        saveRecordButton = findViewById(R.id.workout_detail_save_button);
    }

}


// добавить переменную расстояние и время
// информативно выводить среднюю скорость
//