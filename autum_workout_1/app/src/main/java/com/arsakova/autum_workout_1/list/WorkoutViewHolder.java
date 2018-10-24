package com.arsakova.autum_workout_1.list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.activities.WorkoutDetailActivity;

import com.arsakova.autum_workout_1.model.Workout;

class WorkoutViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private TextView recordDate;
    private TextView recordRepsCount;
    private TextView recordWeight;
    private TextView description;
    private CardView cardView;


    public WorkoutViewHolder(@NonNull final View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.list_item_title_text_view);
        description = itemView.findViewById(R.id.list_item_description_text_view);
        recordDate = itemView.findViewById(R.id.list_item_record_date);
        recordRepsCount= itemView.findViewById(R.id.list_item_record_repscount);
        recordWeight= itemView.findViewById(R.id.list_item_record_weight);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void bindView(Workout workout, final int index){
        title.setText(workout.getTitle());
        description.setText(workout.getDescription());
        recordWeight.setText(String.valueOf(workout.getRecordWeight()));
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
        recordDate.setText(workout.getFormattedRecordDate());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = itemView.getContext();
                Intent intent = new Intent(context ,WorkoutDetailActivity.class);
                intent.putExtra("workout_index", index);
                context.startActivity(intent);
            }
        });
    }

}