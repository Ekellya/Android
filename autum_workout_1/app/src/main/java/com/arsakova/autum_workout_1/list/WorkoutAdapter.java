package com.arsakova.autum_workout_1.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.model.Workout;
import com.arsakova.autum_workout_1.model.WorkoutList;
import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutViewHolder>{
    List<Workout> workoutList = WorkoutList.getInstance().getWorkouts();

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.activity_workout_list_item,
                viewGroup,
                false
        );
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int index) {
        Workout workout = workoutList.get(index);
        workoutViewHolder.bindView(workoutList.get(index), index);
    }

    @Override
    public int getItemCount() {
        return workoutList!=null ? workoutList.size():0;
    }
}
