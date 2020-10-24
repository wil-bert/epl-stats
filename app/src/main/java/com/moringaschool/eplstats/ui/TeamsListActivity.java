package com.moringaschool.eplstats.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.eplstats.adapters.TeamListAdapter;
import com.moringaschool.eplstats.R;
import com.moringaschool.eplstats.models.ChooseCompetition;
import com.moringaschool.eplstats.models.Competition_;
import com.moringaschool.eplstats.network.FootballClient;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeamsListActivity extends AppCompatActivity {
    private static final String TAG = TeamsListActivity.class.getSimpleName();
    public List<Competition_> competitions;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mError;
    private TeamListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);


//        Intent intent = getIntent();
//
//        final String team = intent.getStringExtra("teams");



        Call<ChooseCompetition> call = FootballClient.getClient().getCompetitions();
        call.enqueue(new Callback<ChooseCompetition>() {
            @Override
            public void onResponse(Call<ChooseCompetition> call, Response<ChooseCompetition> response) {
                if (response.isSuccessful()) {
                    competitions = response.body().getCompetitions();
                    mAdapter = new TeamListAdapter(TeamsListActivity.this, competitions);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TeamsListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showSuccessfulMessage();
                }
                else {
                    showUnsuccessfulMessage();
                }

            }


            @Override
            public void onFailure(Call<ChooseCompetition> call, Throwable t) {
                Log.d(TAG, "Here is the problem", t);
                showFailureMessage();

            }
        });
    }




        private void showFailureMessage () {
            mError.setText("Something went wrong. Please check your Internet connection and try again later");
            mError.setVisibility(View.VISIBLE);
        }

        private void showUnsuccessfulMessage () {
            mError.setText("Something went wrong. Please try again later");
            mError.setVisibility(View.VISIBLE);
        }

    private void showSuccessfulMessage() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }



}

