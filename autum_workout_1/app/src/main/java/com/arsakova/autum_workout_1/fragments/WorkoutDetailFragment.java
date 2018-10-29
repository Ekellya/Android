package com.arsakova.autum_workout_1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.model.Workout;
import com.arsakova.autum_workout_1.model.WorkoutList;
import com.squareup.picasso.Picasso;

public class WorkoutDetailFragment extends Fragment {

        public static final String TAG = "DetailActivity";
        private static final String WORKOUT_INDEX = "workoutIndex";
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

        public static WorkoutDetailFragment initFragment(int workoutIndex){
            WorkoutDetailFragment fragment = new WorkoutDetailFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(WORKOUT_INDEX, workoutIndex);
            fragment.setArguments(arguments);
            return fragment;
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout_detail, container, false);
        Workout workout = WorkoutList.getInstance().getWorkouts().get( getArguments().getInt(WORKOUT_INDEX));
        initGUI(root, workout);
        addListeners(workout);
        return root;
    }

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
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
                    if(sendIntent.resolveActivity(getActivity().getPackageManager()) != null){
                        startActivity(sendIntent);
                    }
                }
            });
        }

        private void initGUI(View view, Workout workout) {
            title = view.findViewById(R.id.workout_detail_title);
            title.setText(workout.getTitle());
            recordDate = view.findViewById(R.id.workout_detail_record_date);
            recordDate.setText(workout.getFormattedRecordDate());
            recordRepsCount = view.findViewById(R.id.workout_detail_record_reps_count);
            recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
            recordWeight = view.findViewById(R.id.workout_detail_record_weight);
            recordWeight.setText(String.valueOf(workout.getRecordWeight()));
            description = view.findViewById(R.id.workout_detail_description);
            description.setText(workout.getDescription());
            weight = view.findViewById(R.id.workout_detail_weight);
            weightSeekBar = view.findViewById(R.id.workout_detail_weight_seek_bar);
            repsCountEditText = view.findViewById(R.id.workout_detail_reps_count_edit_text);
            saveRecordButton = view.findViewById(R.id.workout_detail_save_button);
            shareButton = view.findViewById(R.id.button_share);
            image = view.findViewById(R.id.workout_detail_image_view);
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(image);
        }
    }



