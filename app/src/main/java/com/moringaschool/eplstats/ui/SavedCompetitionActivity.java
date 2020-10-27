package com.moringaschool.eplstats.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.eplstats.Constants;
import com.moringaschool.eplstats.R;
import com.moringaschool.eplstats.adapters.FirebaseCompetitionViewHolder;
import com.moringaschool.eplstats.models.Competition_;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedCompetitionActivity extends AppCompatActivity {
    private DatabaseReference mCompetitionReference;
    private FirebaseRecyclerAdapter<Competition_, FirebaseCompetitionViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);

        mCompetitionReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SEARCHED_COMPETITION);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Competition_> options = new FirebaseRecyclerOptions.Builder<Competition_>()
                .setQuery(mCompetitionReference, Competition_.class)
                .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Competition_, FirebaseCompetitionViewHolder>(options) {
            @Override
            protected void onBindViewHolder(FirebaseCompetitionViewHolder firebaseCompetitionViewHolder, int i, Competition_ competition_) {
                firebaseCompetitionViewHolder.bindCompetition(competition_);
            }

            @Override
            public FirebaseCompetitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_item, parent, false);
                return new FirebaseCompetitionViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}