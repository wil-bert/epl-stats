package com.moringaschool.eplstats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeamsActivity extends AppCompatActivity {
    private String[] teams = new String[] {"Arsenal", "Chelsea", "Tottenham", "Liverpool","Everton", "Leeds", "Aston Villa", "Burnley",
    "New Castle", "Manchester City", "Manchester United"};
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        mListView.setAdapter(adapter);
    }
}