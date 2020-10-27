package com.moringaschool.eplstats.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.eplstats.Constants;
import com.moringaschool.eplstats.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.findTeamButton)
    Button mFindTeamButton;
    @BindView(R.id.appNameTextView)
    TextView mTeamTextView;
    @BindView(R.id.savedCompetitionsButton) Button mSavedCompetitionsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mFindTeamButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mFindTeamButton) {
            Intent intent = new Intent(MainActivity.this, TeamsListActivity.class);
            String team = mFindTeamButton.getText().toString();
            intent.putExtra("team", team);
            startActivity(intent);

        } else if (v == mSavedCompetitionsButton) {
            Intent intent = new Intent(MainActivity.this, SavedCompetitionActivity.class);
            startActivity(intent);
        }


    }

}
