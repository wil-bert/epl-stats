package com.moringaschool.eplstats.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.eplstats.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.registerTextView)
    TextView mRegisterTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterTextView) {
            Intent intent = new Intent(LoginActivity.this, CreateAcountActivity.class);
            startActivity(intent);
            finish();
        }

    }
}