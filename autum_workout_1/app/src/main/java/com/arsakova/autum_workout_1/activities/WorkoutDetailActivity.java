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
import android.widget.SeekBar;
import android.widget.TextView;
import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.model.Workout;
import com.arsakova.autum_workout_1.model.WorkoutList;

public class WorkoutDetailActivity extends AppCompatActivity {

        public static final String TAG = "DetailActivity";
        private TextView title;
        private TextView recordDate;
        private TextView recordRepsCount;
        private TextView recordWeight;
        private TextView description;
        private TextView weight;
        private ImageView image;
        private SeekBar weightSeekBar;
        private EditText repsCountEditText;
        private Button saveRecordButton;
        private ImageButton shareButton;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Configuration config = new Configuration();
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            setContentView(R.layout.activity_workout_detail);
            Workout workout = WorkoutList.getInstance().getWorkouts().get(getIntent().getIntExtra("workout_index",0));
            initGUI(workout);
            addListeners(workout);
            Log.d(TAG, "Вызван onCreate()");
        }

    private void addListeners(final Workout workout) {
            weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    weight.setText(String.valueOf(progress));
                    workout.setRecordWeight(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            saveRecordButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recordWeight.setText(String.valueOf(workout.getRecordWeight()));
                    workout.setRecordRepsCount(Integer.parseInt(repsCountEditText.getText().toString()));
                    recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
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

        private void initGUI(Workout workout) {
            title = findViewById(R.id.workout_detail_title);
            title.setText(workout.getTitle());
            recordDate = findViewById(R.id.workout_detail_record_date);
            recordDate.setText(workout.getFormattedRecordDate());
            recordRepsCount = findViewById(R.id.workout_detail_record_reps_count);
            recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
            recordWeight = findViewById(R.id.workout_detail_record_weight);
            recordWeight.setText(String.valueOf(workout.getRecordWeight()));
            description = findViewById(R.id.workout_detail_description);
            description.setText(workout.getDescription());
            weight = findViewById(R.id.workout_detail_weight);
            weightSeekBar = findViewById(R.id.workout_detail_weight_seek_bar);
            repsCountEditText = findViewById(R.id.workout_detail_reps_count_edit_text);
            saveRecordButton = findViewById(R.id.workout_detail_save_button);
            shareButton = findViewById(R.id.button_share);
        }
    }



