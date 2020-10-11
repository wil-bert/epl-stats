package com.moringaschool.eplstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.reflect.Type;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.findTeamButton)Button mFindTeamButton;
    @BindView(R.id.appNameTextView) EditText mAppNameTextView;
    @BindView(R.id.teamTextView) TextView mTeamTextView;
//    private static final String TAG = MainActivity.class.getSimpleName();
//    private Button mFindTeamButton;
//    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mAppNameTextView = findViewById(R.id.appNameTextView);
//        mFindTeamButton = (Button)findViewById(R.id.findTeamButton);
        mFindTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TeamsActivity.class);
                String team = mFindTeamButton.getText().toString();
                intent.putExtra("team", team);
                startActivity(intent);
            }
        });
    }
}