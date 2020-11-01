package com.moringaschool.eplstats.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.eplstats.R;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import com.moringaschool.eplstats.adapters.TeamPagerAdapter;
import com.moringaschool.eplstats.models.Competition_;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private TeamPagerAdapter adapterViewPager;
    List<Competition_> mCompetitions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        ButterKnife.bind(this);

        mCompetitions = Parcels.unwrap(getIntent().getParcelableExtra("competition"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new TeamPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mCompetitions);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}