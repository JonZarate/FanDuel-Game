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
import com.jonzarate.fanduelgame.data.model.History;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GamePlayerViewHolder> {

    private History history;

    public GameAdapter() {

    }

    public void updateGame(History history) {
        this.history = history;
    }

    @NonNull
    @Override
    public GamePlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_game_player, parent, false);

        return new GamePlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamePlayerViewHolder holder, int position) {
        holder.setGame(getPlayerName(position), getPlayerImage(position));
    }

    private String getPlayerImage(int position) {
        switch (position) {
            case 0:
                return history.getImg0();

            case 1:
                return history.getImg1();

            case 2:
                return history.getImg2();

            case 3:
                return history.getImg3();
        }
        return null;
    }

    private String getPlayerName(int position) {
        switch (position) {
            case 0:
                return history.getName0();

            case 1:
                return history.getName1();

            case 2:
                return history.getName2();

            case 3:
                return history.getName3();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return (history == null) ? 0 : 4;
    }

    class GamePlayerViewHolder extends RecyclerView.ViewHolder {

        private final RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_person);

        private ImageView image;
        private TextView name;

        GamePlayerViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.game_player_img);
            name = itemView.findViewById(R.id.game_player_name);
        }

        void setGame(String name, String image) {
            this.name.setText(name);
            Glide.with(itemView)
                    .setDefaultRequestOptions(options)
                    .load(image)
                    .into(this.image);
        }
    }
}

