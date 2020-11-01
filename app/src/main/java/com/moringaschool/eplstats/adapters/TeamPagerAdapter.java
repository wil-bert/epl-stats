package com.moringaschool.eplstats.adapters;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import com.moringaschool.eplstats.models.ChooseCompetition;
import com.moringaschool.eplstats.models.Competition_;
import com.moringaschool.eplstats.ui.TeamDetailFragment;

public  class TeamPagerAdapter extends FragmentPagerAdapter {
    private List<Competition_> mCompetitions;

    public TeamPagerAdapter(FragmentManager fm, int behavior, List<Competition_> competition) {
        super(fm, behavior);
        mCompetitions = competition;

    }

    @Override
    public int getCount() {
        return mCompetitions.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  mCompetitions.get(position).getName();
    }

    @Override
    public TeamDetailFragment getItem(int position) {
        return TeamDetailFragment.newInstance(mCompetitions.get(position));
    }
}
