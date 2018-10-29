package com.arsakova.autum_workout_1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arsakova.autum_workout_1.R;
import com.arsakova.autum_workout_1.interfaces.OnListItemClickListener;
import com.arsakova.autum_workout_1.list.WorkoutAdapter;

public class WorkoutListFragment extends Fragment {
    public static final String TAG = "WorkoutListFragment";
    private RecyclerView recyclerView;
    private OnListItemClickListener listener;

    @Override
    public void onAttach(Context context) {
        if (context instanceof OnListItemClickListener) {
            listener = (OnListItemClickListener) context;
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout_list, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new WorkoutAdapter(listener));
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
