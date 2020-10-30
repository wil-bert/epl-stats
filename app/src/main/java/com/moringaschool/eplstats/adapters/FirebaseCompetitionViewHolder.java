package com.moringaschool.eplstats.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.eplstats.Constants;
import com.moringaschool.eplstats.R;
import com.moringaschool.eplstats.models.Competition_;
import com.moringaschool.eplstats.ui.TeamDetailActivity;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;


public class FirebaseCompetitionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseCompetitionViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCompetition(Competition_ competition) {
        TextView nameTextView = (TextView) mView.findViewById(R.id.competitionName);

        nameTextView.setText(competition.getName());
    }


    @Override
    public void onClick(View v) {
        final ArrayList<Competition_> competition_s = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SEARCHED_COMPETITION);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    competition_s.add(snapshot.getValue(Competition_.class));
                }
                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, TeamDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("competitions", Parcels.wrap(competition_s));

                mContext.startActivity(intent);

            }

            @Override
            public void onCancelled( DatabaseError error) {
            }
        });

    }
}
