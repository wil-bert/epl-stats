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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findTeamButton)
    Button mFindTeamButton;
    @BindView(R.id.findLoginButton)
    Button mFindLoginButton;
    //    @BindView(R.id.appNameTextView) EditText mAppNameTextView;
    @BindView(R.id.appNameTextView)
    TextView mTeamTextView;
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
        mFindTeamButton.setOnClickListener(this);
        mFindLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindTeamButton) {
            Intent intent = new Intent(MainActivity.this, TeamsActivity.class);
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
}
