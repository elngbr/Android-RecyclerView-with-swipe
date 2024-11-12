package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;

import com.example.myapplication.R;
import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.model.Movie;
import com.example.myapplication.model.GenreEnum;
import com.example.myapplication.model.ParentalApprovalEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie);

        // find the recycler view...withou find it's null
        RecyclerView recyclerView = findViewById(R.id.rwMovie);
        //set a layout to it
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // create a list of objects from class m movies
        List<Movie> movieList = new ArrayList<>();

        // HARDCODE MOVIES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        movieList.add(new Movie(
                "Filantropica",
                new java.util.Date(),
                120,
                true,
                4.8f,
                GenreEnum.COMEDY,
                160000000.0,
                "filantropica_poster",
                R.drawable.filantropica,
                ParentalApprovalEnum.P
        ));
        movieList.add(new Movie(
                "Trandafirul Galben",
                new java.util.Date(),
                130,
                true,
                4.9f,
                GenreEnum.ACTION,
                185000000.0,
                "trandafirul_galben_poster",
                R.drawable.trandafirul_galben,
                ParentalApprovalEnum.PG
        ));
        movieList.add(new Movie(
                "BD la munte si la mare",
                new java.util.Date(),
                110,
                false,
                4.7f,
                GenreEnum.COMEDY,
                55000000.0,
                "bd_la_munte_si_la_mare_poster",
                R.drawable.bd_la_munte_si_la_mare,
                ParentalApprovalEnum.R
        ));
        movieList.add(new Movie(
                "Un pas in umbra serafimilor",
                new java.util.Date(),
                150,
                true,
                4.7f,
                GenreEnum.DRAMA,
                55000000.0,
                "default_poster",
                R.drawable.default_poster,
                ParentalApprovalEnum.NC17
        ));


        ////go and create a movie adapter
        // create an instance of  it
        MovieAdapter movieAdapter = new MovieAdapter(movieList);

        //set the insatnce as adapter to the recycler view
        recyclerView.setAdapter(movieAdapter);

        // create an inten touch helper ...
        //only write ItemTouchHelper sth = new ItemTouchHelper(new ItemTouchHelper...then intellisense comes in
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false; //we domnt handle this..it does not have to actually be swiped away
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // create an instance of a movie you gonna use in toast
                //this is exctly the instacne youare going to use in toast....
                // that what get(viewHolder.getAdapterPosition()) does
                Movie movie = movieList.get(viewHolder.getAdapterPosition());


                String movieDetails = "Film swiped: " + movie.getTitle() + "\n" +
                        "Genre: " + movie.getGenre() + "\n" +
                        "Rating: " + movie.getRating() + "\n" +
                        "Budget: $" + movie.getBudget() + "\n" +
                        "Duration: " + movie.getDuration() + " mins" + "\n" +
                        "Parental Approval: " + movie.getApproval();

                Toast.makeText(MovieActivity.this, movieDetails, Toast.LENGTH_LONG).show();

                // dont forget there's an observer...you have to notify
                movieAdapter.notifyItemChanged(viewHolder.getAdapterPosition());
            }
        });

        // attach the  "swipe recognizer" to the reciclerView
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
