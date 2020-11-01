package com.moringaschool.eplstats.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.moringaschool.eplstats.Constants;
import com.moringaschool.eplstats.adapters.TeamListAdapter;
import com.moringaschool.eplstats.R;
import com.moringaschool.eplstats.models.ChooseCompetition;
import com.moringaschool.eplstats.models.Competition_;
import com.moringaschool.eplstats.network.FootballApi;
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
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentName;


    private static final String TAG = TeamsListActivity.class.getSimpleName();
    public List<Competition_> competition;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mError;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    private TeamListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);

        final Intent intent = getIntent();
        String user = intent.getStringExtra("user");

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentName = mSharedPreferences.getString(Constants.PREFERENCES_COMPETITION_KEY, null);

        if (mRecentName != null) {
            getCompetitions(mRecentName);
        }


        FootballApi client = FootballClient.getClient();

        Call<ChooseCompetition> call = FootballClient.getClient().getCompetitions();
        call.enqueue(new Callback<ChooseCompetition>() {
            @Override
            public void onResponse(Call<ChooseCompetition> call, Response<ChooseCompetition> response) {
                if (response.isSuccessful()) {
                    hideProgressBar();
                    competition = response.body().getCompetitions();
                    mAdapter = new TeamListAdapter(TeamsListActivity.this, competition);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TeamsListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showSuccessfulMessage();
                    Log.e(TAG, "check");
                }
                else {
                    showUnsuccessfulMessage();
                }

            }

            @Override
            public void onFailure(Call<ChooseCompetition> call, Throwable t) {
                Log.d(TAG, "Here is the problem", t);
                hideProgressBar();
                showFailureMessage();

            }
        });


    }

    private void getCompetitions(String competition) {
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

    private void addToSharedPreferences(String competition) {
        mEditor.putString(Constants.PREFERENCES_COMPETITION_KEY, competition).apply();
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                addToSharedPreferences(query);
                getCompetitions(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}

