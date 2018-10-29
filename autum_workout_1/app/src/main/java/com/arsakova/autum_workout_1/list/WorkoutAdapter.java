package com.arsakova.autum_workout_1.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.interfaces.OnListItemClickListener;
import com.arsakova.autum_workout_1.model.Workout;
import com.arsakova.autum_workout_1.model.WorkoutList;
import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutViewHolder>{
    private List<Workout> workoutList = WorkoutList.getInstance().getWorkouts();
private OnListItemClickListener itemClickListener;

public WorkoutAdapter (OnListItemClickListener itemClickListener){
    this.itemClickListener = itemClickListener;
}

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_item,
                viewGroup,
                false
        );
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int index) {
                workoutViewHolder.bindView(workoutList.get(index), index, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return workoutList!=null ? workoutList.size():0;
    }
}
