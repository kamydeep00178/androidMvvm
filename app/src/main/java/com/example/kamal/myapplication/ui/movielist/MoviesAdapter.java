package com.example.kamal.myapplication.ui.movielist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamal.myapplication.R;
import com.example.kamal.myapplication.model.MovieModel;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by kamal on 8/2/18.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<MovieModel.DataModel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }


    public MoviesAdapter(List<MovieModel.DataModel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieModel.DataModel movie = moviesList.get(position);
        holder.name.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}