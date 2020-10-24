package com.moringaschool.eplstats.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.eplstats.R;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.moringaschool.eplstats.models.Competition_;
import com.moringaschool.eplstats.ui.TeamDetailFragment;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamViewHolder> {
    private List<Competition_> mCompetitions;
    private Context mContext;

    public TeamListAdapter(Context mcontext, List<Competition_> competitions) {

        mContext = mcontext;
        mCompetitions = competitions;
    }





    @Override
    public TeamViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_item, parent, false);
        TeamViewHolder viewHolder = new TeamViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeamListAdapter.TeamViewHolder holder, int position) {
        holder.bindTeams(mCompetitions.get(position));

    }

    @Override
    public int getItemCount() {
        return mCompetitions.size();
    }


    public class TeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.teamNameTextView)
        TextView mNameTextView;

        public TeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bindTeams(Competition_ competition_) {
            mNameTextView.setText(competition_.getName());

        }

        @Override
        public void onClick(View v){
            int itemPosition=  getLayoutPosition();
            Intent intent = new Intent(String.valueOf(TeamDetailFragment.class));
            intent.putExtra("position", itemPosition);
            intent.putExtra("teams", Parcels.wrap(mCompetitions));
        }
    }
}
