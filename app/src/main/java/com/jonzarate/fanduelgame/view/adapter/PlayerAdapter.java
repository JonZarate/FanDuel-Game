package com.jonzarate.fanduelgame.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.data.model.Player;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> players;

    public PlayerAdapter() {

    }

    public void updatePlayer(List<Player> players){
        this.players = players;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_player, parent, false);

        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        holder.setPlayer(players.get(position));
    }

    @Override
    public int getItemCount() {
        return (players == null) ? 0 : players.size();
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {

        private final RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_person);

        private ImageView image;
        private TextView name, fppg;

        public PlayerViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.player_img);
            name = itemView.findViewById(R.id.player_name);
            fppg = itemView.findViewById(R.id.player_fppg);
        }

        void setPlayer(Player player) {
            Glide.with(this.itemView)
                    .setDefaultRequestOptions(options)
                    .load(player.imageUrl)
                    .into(image);

            name.setText(player.getFirstName());
            fppg.setText(String.valueOf(player.getFppg()));
        }
    }

}
