package com.arsakova.autum_workout_1.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.fragments.WorkoutDetailFragment;
import com.arsakova.autum_workout_1.fragments.WorkoutListFragment;
import com.arsakova.autum_workout_1.interfaces.OnListItemClickListener;
import com.arsakova.autum_workout_1.model.Workout;

public class MainActivity extends AppCompatActivity implements OnListItemClickListener {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkoutListFragment listFragment = new WorkoutListFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, listFragment);
        transaction.commit();
    }

    @Override
    public void onListItemClickListener(int i) {
        WorkoutDetailFragment detailFragment = WorkoutDetailFragment.initFragment(i);
        fragmentManager.beginTransaction().add(R.id.container, detailFragment).addToBackStack("").commit();
    }
}
