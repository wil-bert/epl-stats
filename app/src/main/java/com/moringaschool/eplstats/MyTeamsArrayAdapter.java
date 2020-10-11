package com.moringaschool.eplstats;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyTeamsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mTeams;

    public MyTeamsArrayAdapter(Context mContext, int resources, String[] mTeams) {
        super(mContext, resources);
        this.mContext = mContext;
        this.mTeams = mTeams;
    }

    @Override
    public Object getItem(int position) {
        String teams = mTeams[position];
        return String.format(teams);

    }

    @Override
    public int getCount() {
        return mTeams.length;
    }
}
