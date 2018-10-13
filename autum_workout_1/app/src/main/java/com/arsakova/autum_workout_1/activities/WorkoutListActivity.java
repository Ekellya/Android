package com.arsakova.autum_workout_1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.arsakova.autum_workout_1.R;

public class WorkoutListActivity extends AppCompatActivity {
    private Button buttonLiftingTheRod;
    private Button buttonPullUps;
    private Button buttonJogging;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        initGUI();
    }

    private void initGUI() {
        buttonLiftingTheRod = findViewById(R.id.lifting_the_rod_button);
        buttonPullUps = findViewById(R.id.pull_ups_button);
//        buttonJogging = findViewById(R.id.jogging_button);

        buttonPullUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(WorkoutListActivity.this, "   ", Toast.LENGTH_SHORT).show();
                Intent startWorkoutDetailPullUpsActivity = new Intent(WorkoutListActivity.this, WorkoutDetailPullUpsActivity.class);
                startActivity(startWorkoutDetailPullUpsActivity);
            }
        });
        buttonLiftingTheRod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(WorkoutListActivity.this, "   ", Toast.LENGTH_SHORT).show();
                Intent startWorkoutDetailLiftingTheRodActivity = new Intent(WorkoutListActivity.this, WorkoutDetailLiftingTheRodActivity.class);
                startActivity(startWorkoutDetailLiftingTheRodActivity);
            }
        });
        buttonJogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(WorkoutListActivity.this, "   ", Toast.LENGTH_SHORT).show();
                Intent startWorkoutDetailLiftingTheRodActivity = new Intent(WorkoutListActivity.this, WorkoutDetailJoggingActivity.class);
                startActivity(startWorkoutDetailLiftingTheRodActivity);
            }
        });
    }
}
