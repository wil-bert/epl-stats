package com.moringaschool.eplstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsActivity extends AppCompatActivity {
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

    }
}