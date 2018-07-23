package com.example.kamal.myapplication.ui.movielist;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamal.myapplication.R;
import com.example.kamal.myapplication.model.MovieModel;
import com.example.kamal.myapplication.viewModel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamal on 8/2/18.
 */

public class MovieListFragment extends Fragment {

    private MovieListViewModel mViewModel;
    private List<MovieModel.DataModel> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.movie_list_fragment, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        mViewModel.init();
        mViewModel.getMovies().observe(this, new Observer<MovieModel>() {
            @Override
            public void onChanged(@Nullable MovieModel movieModels) {
                movieList.addAll(movieModels.getData());
                mAdapter.notifyDataSetChanged();
            }
        });
        }

}
