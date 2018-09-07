package com.jonzarate.fanduelgame.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.data.model.Team;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teams;

    public TeamAdapter() {

    }

    public void updateTeams(List<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_team, parent, false);

        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.setTeam(teams.get(position));
    }

    @Override
    public int getItemCount() {
        return (teams == null) ? 0 : teams.size();
    }


    class TeamViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        TeamViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.team_name);
        }

        void setTeam(Team team) {
            name.setText(team.getName());
        }
    }
}

