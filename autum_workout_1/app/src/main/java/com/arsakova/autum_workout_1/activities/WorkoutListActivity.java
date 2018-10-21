package com.arsakova.autum_workout_1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.arsakova.autum_workout_1.R;

public class WorkoutListActivity extends AppCompatActivity {
    public static final String TAG = "WorkoutListActivity";
    private Button buttonLiftingTheRod;
    private Button buttonPullUps;
    private Button buttonJogging;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list_item);

//        setContentView(R.layout.activity_workout_list);
//        initGUI();
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

    private void initGUI() {
        buttonLiftingTheRod = findViewById(R.id.lifting_the_rod_button);
        buttonPullUps = findViewById(R.id.pull_ups_button);
        buttonJogging = findViewById(R.id.jogging_button);

        buttonPullUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startWorkoutDetailPullUpsActivity = new Intent(WorkoutListActivity.this, WorkoutDetailPullUpsActivity.class);
                startActivity(startWorkoutDetailPullUpsActivity);
            }
        });
        buttonLiftingTheRod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startWorkoutDetailLiftingTheRodActivity = new Intent(WorkoutListActivity.this, WorkoutDetailLiftingTheRodActivity.class);
                startActivity(startWorkoutDetailLiftingTheRodActivity);
            }
        });
        buttonJogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startWorkoutDetailLiftingTheRodActivity = new Intent(WorkoutListActivity.this, WorkoutDetailJoggingActivity.class);
                startActivity(startWorkoutDetailLiftingTheRodActivity);
            }
        });
    }
}
