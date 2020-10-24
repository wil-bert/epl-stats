package com.moringaschool.eplstats.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moringaschool.eplstats.R;
import com.moringaschool.eplstats.models.ChooseCompetition;
import com.moringaschool.eplstats.models.Competition_;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamDetailFragment extends Fragment {

    @BindView(R.id.teamNameTextView) TextView mNameLabel;



    private ChooseCompetition mCompetition;

    public TeamDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TeamDetailFragment newInstance(Competition_ competition) {
        TeamDetailFragment teamDetailFragment = new TeamDetailFragment();
        Bundle args = new Bundle();
        args.putString("teams", String.valueOf(Parcels.wrap(competition)));
        teamDetailFragment.setArguments(args);
        return teamDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCompetition = Parcels.unwrap(getArguments().getParcelable("teams"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_detail, container, false);
        ButterKnife.bind(this, view);

        mNameLabel.setText((CharSequence) mCompetition.getCompetitions());

        return view;

    }
}

