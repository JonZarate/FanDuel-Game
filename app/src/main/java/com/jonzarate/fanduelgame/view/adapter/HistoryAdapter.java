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

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<History> history;

    public HistoryAdapter() {

    }

    public void updateHistory(List<History> history){
        this.history = history;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_history, parent, false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.setHistory(history.get(position));
    }

    @Override
    public int getItemCount() {
        return (history == null) ? 0 : history.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        private final RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_person);

        private ImageView image0, image1, image2, image3;
        private TextView name0, name1, name2, name3;
        private TextView fppg0, fppg1, fppg2, fppg3;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            image0 = itemView.findViewById(R.id.player_history_img0);
            name0 = itemView.findViewById(R.id.player_history_name0);
            fppg0 = itemView.findViewById(R.id.player_history_fppg0);
            image1 = itemView.findViewById(R.id.player_history_img1);
            name1 = itemView.findViewById(R.id.player_history_name1);
            fppg1 = itemView.findViewById(R.id.player_history_fppg1);
            image2 = itemView.findViewById(R.id.player_history_img2);
            name2 = itemView.findViewById(R.id.player_history_name2);
            fppg2 = itemView.findViewById(R.id.player_history_fppg2);
            image3 = itemView.findViewById(R.id.player_history_img3);
            name3 = itemView.findViewById(R.id.player_history_name3);
            fppg3 = itemView.findViewById(R.id.player_history_fppg3);
        }

        void setHistory(History history) {
            setBackground(history);
            setPlayerData(history.getName0(), history.getFppg0(), history.getImg0(), name0, fppg0, image0);
            setPlayerData(history.getName1(), history.getFppg1(), history.getImg1(), name1, fppg1, image1);
            setPlayerData(history.getName2(), history.getFppg2(), history.getImg2(), name2, fppg2, image2);
            setPlayerData(history.getName3(), history.getFppg3(), history.getImg3(), name3, fppg3, image3);
        }

        private void setPlayerData(String name, float fppg, String imageUrl, TextView nameView, TextView fppgView, ImageView imageView) {
            Glide.with(this.itemView)
                    .setDefaultRequestOptions(options)
                    .load(imageUrl)
                    .into(imageView);

            nameView.setText(name);
            fppgView.setText(String.valueOf(fppg));
        }

        private void setBackground(History history) {
            image0.setBackground(null);
            image1.setBackground(null);
            image2.setBackground(null);
            image3.setBackground(null);

            int positionHighestFppgPlayer = history.getHigherFppgPlayer();
            int positionSelected = history.getUserChoice();

            if (positionHighestFppgPlayer ==  positionSelected) {
                getImageViewByIndex(positionSelected).setBackgroundResource(R.drawable.border_selected_winner);
            } else {
                getImageViewByIndex(positionHighestFppgPlayer).setBackgroundResource(R.drawable.border_winner);
                getImageViewByIndex(positionSelected).setBackgroundResource(R.drawable.border_selected);
            }
        }

        private ImageView getImageViewByIndex(int index) {
            switch (index) {
                case 0: return image0;
                case 1: return image1;
                case 2: return image2;
                case 3: return image3;
            }
            return null;
        }
    }

}
