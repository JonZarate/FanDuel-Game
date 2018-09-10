package com.jonzarate.fanduelgame.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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

    private boolean fppgVisible;
    private int positionSelected, positionHighestFppgPlayer;

    public GameAdapter(OnPlayerClickListener listener) {
        this.listener = listener;
    }

    public void updateGame(History history) {
        this.history = history;
        fppgVisible = false;
        positionSelected = -1;
        positionHighestFppgPlayer = -1;
    }

    public void setFppgVisible(boolean fppgVisible) {
        this.fppgVisible = fppgVisible;
    }

    public void setBorders(int positionSelected, int positionHighestFppgPlayer) {
        this.positionSelected = positionSelected;
        this.positionHighestFppgPlayer = positionHighestFppgPlayer;
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
        holder.setGame(
                getPlayerName(position), getPlayerImage(position), getPlayerFppg(position));
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

    private float getPlayerFppg(int position) {
        switch (position) {
            case 0:
                return history.getFppg0();

            case 1:
                return history.getFppg1();

            case 2:
                return history.getFppg2();

            case 3:
                return history.getFppg3();
        }
        return 0;
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
        private TextView name, fppg;

        GamePlayerViewHolder(View itemView, OnPlayerClickListener playerListener) {
            super(itemView);

            image = itemView.findViewById(R.id.game_player_img);
            name = itemView.findViewById(R.id.game_player_name);
            fppg = itemView.findViewById(R.id.game_player_fppg);

            this.playerListener = playerListener;

            itemView.setOnClickListener(this.clickListener);
        }

        void setGame(String name, String image, float fppg) {
            if (fppgVisible)
                this.fppg.setVisibility(View.VISIBLE);
            else
                this.fppg.setVisibility(View.GONE);

            setData(name, image, fppg);
            setBorder();
        }

        private void setData(String name, String image, float fppg){
            this.name.setText(name);
            this.fppg.setText(String.valueOf(fppg));
            Glide.with(itemView)
                    .setDefaultRequestOptions(options)
                    .load(image)
                    .into(this.image);
        }

        private void setBorder() {
            CardView card = (CardView) itemView;
            if (positionHighestFppgPlayer == getAdapterPosition()
                    && positionSelected == getAdapterPosition()) {
                card.setBackgroundResource(R.drawable.border_selected_winner);
            } else if (positionHighestFppgPlayer == getAdapterPosition()) {
                card.setBackgroundResource(R.drawable.border_winner);
            } else if (positionSelected == getAdapterPosition()) {
                card.setBackgroundResource(R.drawable.border_selected);
            } else {
                card.setBackgroundResource(R.drawable.border_unselected);
            }
        }
    }
}

