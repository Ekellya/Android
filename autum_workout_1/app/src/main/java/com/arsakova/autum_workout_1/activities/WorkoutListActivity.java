package com.arsakova.autum_workout_1.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.list.WorkoutAdapter;

public class WorkoutListActivity extends AppCompatActivity {
    public static final String TAG = "WorkoutListActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new WorkoutAdapter());
        Log.d(TAG, "Вызван onCreate()");
    }


}
