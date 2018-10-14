package com.arsakova.autum_workout_1.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.model.Workout;

import java.util.Date;

public class WorkoutDetailJoggingActivity extends AppCompatActivity {

    public static final String TAG = "JoggingActivity";
    private TextView title;
    private TextView recordDate;
    private TextView description;
    private ImageView image;
//    private EditText repsCountEditText;
    private Button saveRecordButton;
    private ImageButton shareButton;
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
        Log.d(TAG, "Вызван onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Вызван onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Вызван onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Вызван onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Вызван onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Вызван onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Вызван onDestroy()");
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

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Поделиться");
                sendIntent.setType("text/plain");

                if(sendIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(sendIntent);
                }
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
        shareButton = findViewById(R.id.button_share);
    }

}


// добавить переменную расстояние и время
// информативно выводить среднюю скорость
//