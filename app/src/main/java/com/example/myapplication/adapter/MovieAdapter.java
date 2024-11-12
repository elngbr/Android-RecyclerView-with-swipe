package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Movie;

import java.text.SimpleDateFormat;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    //you only create the class MovieAdapter
    //then you create the public static class MovieViewHolder extending recyclerView.viewHolder
    //define conrold meant to store data of your films
    //create in static class function
//    public MovieViewHolder(View itemView) {
//        super(itemView);
//
//        tvTitle = itemView.findViewById(R.id.tvTitle);
//        tvGenre = itemView.findViewById(R.id.tvGenre);
//        tvRating = itemView.findViewById(R.id.tvRating);
//        tvRelease = itemView.findViewById(R.id.tvRelease);
//        tvDuration = itemView.findViewById(R.id.tvDuration);
//        tvRecommended = itemView.findViewById(R.id.tvRecommended);
//        tvApproval = itemView.findViewById(R.id.tvApproval);
//        tvBudget = itemView.findViewById(R.id.tvBudget);
//        ivPoster = itemView.findViewById(R.id.ivPoster);
//    }   ////////////so that you actually retrieve the films

//    then you extend RecyclerView.Adapter<MovieAdapter>.MovieViewHolder

    //create the list of moveis

//    in the ctor of MovieAdaptor init the movie list


    //override
    //1. public MovieViewHolder onCreateViewHolder
    //2. public void onBindViewHolder //get the articular movie from position
    //set in the card the data of the moveis..bind..map movies from list to viewholder
    //3.public int getItemCount() //return zie of movie list
    private final List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);


        holder.tvTitle.setText(movie.getTitle());


        holder.tvGenre.setText("Genre: " + movie.getGenre().toString());


        holder.tvRating.setText("Rating: " + movie.getRating());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        holder.tvRelease.setText("Release: " + sdf.format(movie.getRelease()));

        holder.tvDuration.setText("Duration: " + movie.getDuration() + " min");

        //smarter..ternary operator
        holder.tvRecommended.setText(movie.getRecommended() ? "Recommended" : "Not Recommended");
//        if(movie.getRecommended())
//        {
//            holder.tvRecommended.setText("Recommended");
//        }
//        else {
//            holder.tvRecommended.setText("Not Recommended");
//        }


        holder.tvApproval.setText("Parental Approval: " + movie.getApproval().toString());


        holder.tvBudget.setText("Budget: $" + String.format("%.2f", movie.getBudget()));


        holder.ivPoster.setImageResource(movie.getPosterResId());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvGenre, tvRating, tvRelease, tvDuration, tvRecommended, tvApproval, tvBudget;
        ImageView ivPoster;

        public MovieViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvRelease = itemView.findViewById(R.id.tvRelease);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvRecommended = itemView.findViewById(R.id.tvRecommended);
            tvApproval = itemView.findViewById(R.id.tvApproval);
            tvBudget = itemView.findViewById(R.id.tvBudget);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }
    }
}
