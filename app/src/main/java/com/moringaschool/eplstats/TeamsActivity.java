package com.moringaschool.eplstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsActivity extends AppCompatActivity {
    private static final String TAG = TeamsActivity.class.getSimpleName();
    @BindView(R.id.teamTextView) TextView mTeamListView;
    @BindView(R.id.listView) ListView mListView;
//    private TextView mTeamListView;
    private String[] teams = new String[] {"Arsenal", "Chelsea", "Tottenham", "Liverpool","Everton", "Leeds", "Aston Villa", "Burnley",
    "New Castle", "Manchester City", "Manchester United", "West Ham", "Southermpton", "Crystal Palace", "Wolves", "Brighton", "Full Ham", "West Brom"};
//    private ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);

//        mListView = (ListView) findViewById(R.id.listView);
//        mTeamListView = (TextView) findViewById(R.id.teamTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, teams);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String teams = ((TextView)view).getText().toString();
                Toast.makeText(TeamsActivity.this, teams, Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();
        String teams = intent.getStringExtra("teams");
        mTeamListView.setText("Pick your favourite team " + teams);

        FootballApi client = FootballClient.getClient();

        Call<ChooseTeamResponse> call = client.getTeam(teams, "teams");

        call.enqueue(new Callback<ChooseTeamResponse>() {
            @Override
            public void onResponse(Call<ChooseTeamResponse> call, Response<ChooseTeamResponse> response) {
                if (response.isSuccessful()) {
//                    List<Team> teamList = response.body().getName();
//                    String[] teams = new String[teamList.size()];

//                    for (int i = 0; i < teams.length; i++) {
//                        teams[i] = teamList.get(i).getName();
//                    }

                }
            }

            @Override
            public void onFailure(Call<ChooseTeamResponse> call, Throwable t) {

            }
        });


    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mListView.setVisibility(View.VISIBLE);
        mLocationTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }


}

