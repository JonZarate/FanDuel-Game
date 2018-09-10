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

    public interface OnPlayerClickListener {
        void onPlayerClick(int position);
    }

    private OnPlayerClickListener listener;
    private History history;

    public GameAdapter(OnPlayerClickListener listener) {
        this.listener = listener;
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

        return new GamePlayerViewHolder(view, listener);
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

        private View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerListener.onPlayerClick(getAdapterPosition());
            }
        };

        private final RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_person);

        private OnPlayerClickListener playerListener;

        private ImageView image;
        private TextView name;

        GamePlayerViewHolder(View itemView, OnPlayerClickListener playerListener) {
            super(itemView);

            image = itemView.findViewById(R.id.game_player_img);
            name = itemView.findViewById(R.id.game_player_name);

            this.playerListener = playerListener;

            itemView.setOnClickListener(this.clickListener);
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

