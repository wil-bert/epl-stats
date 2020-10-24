package com.moringaschool.eplstats.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyTeamsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mCompetitions;

    public MyTeamsArrayAdapter(Context mContext, int resources, String[] mCompetitions) {
        super(mContext, resources);
        this.mContext = mContext;
        this.mCompetitions = mCompetitions;
    }

    @Override
    public Object getItem(int position) {
        String teams = mCompetitions[position];
        return String.format(teams);

    }

    @Override
    public int getCount() {
        return mCompetitions.length;
    }
}
