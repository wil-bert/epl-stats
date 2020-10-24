package com.moringaschool.eplstats.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.eplstats.Constants;
import com.moringaschool.eplstats.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.findTeamButton)
    Button mFindTeamButton;
    @BindView(R.id.findLoginButton)
    Button mFindLoginButton;
    @BindView(R.id.appNameTextView)
    TextView mTeamTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindTeamButton.setOnClickListener(this);
        mFindLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindTeamButton) {
            Intent intent = new Intent(MainActivity.this, TeamsListActivity.class);
            String team = mFindTeamButton.getText().toString();
            intent.putExtra("team", team);
            startActivity(intent);


        } else if (v == mFindLoginButton) {
            Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
            String login = mFindLoginButton.getText().toString();
            intent1.putExtra("login", login);
            startActivity(intent1);
        }
    }

    private void addToSharedpreferencess(String competition) {
        mEditor.putString(Constants.PREFERENCES_COMPETITION_KEY, competition).apply();
    }
}
