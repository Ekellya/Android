package com.arsakova.autum_workout_1.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.interfaces.OnListItemClickListener;
import com.arsakova.autum_workout_1.model.Workout;
import com.squareup.picasso.Picasso;

class WorkoutViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView recordDate;
    private TextView recordRepsCount;
    private TextView recordWeight;
    private TextView description;
    private CardView cardView;
    private ImageView image;

    public WorkoutViewHolder(@NonNull final View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.list_item_title_text_view);
        description = itemView.findViewById(R.id.list_item_description_text_view);
        recordDate = itemView.findViewById(R.id.list_item_record_date);
        recordRepsCount = itemView.findViewById(R.id.list_item_record_repscount);
        recordWeight = itemView.findViewById(R.id.list_item_record_weight);
        cardView = itemView.findViewById(R.id.card_view);
        image = itemView.findViewById(R.id.list_item_image_view);
    }

    public void bindView(Workout workout, final int index, final OnListItemClickListener itemClickListener) {
        title.setText(workout.getTitle());
        description.setText(workout.getDescription());
        recordWeight.setText(String.valueOf(workout.getRecordWeight()));
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
        recordDate.setText(workout.getFormattedRecordDate());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onListItemClickListener(index);
            }
        });
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(image);
    }
}