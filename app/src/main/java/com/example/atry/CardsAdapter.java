package com.example.atry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {
    private List<CardItem> cardItems;
    private OnItemClickListener onItemClickListener;


    public CardsAdapter(List<CardItem> cardItems, OnItemClickListener onItemClickListener) {
        this.cardItems = cardItems;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.setCard(cardItems.get(position));
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private TextView textTop;
        private TextView textBottom;
        private ImageView imageTop;
        private ImageView imageBottom;
        private ImageView imageCenter;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            textTop = itemView.findViewById(R.id.textCardTop);
            textBottom = itemView.findViewById(R.id.textCardBottom);
            imageTop = itemView.findViewById(R.id.imageCardTop);
            imageBottom = itemView.findViewById(R.id.imageCardBottom);
            imageCenter = itemView.findViewById(R.id.imageCardCenter);
        }

        public void setCard(CardItem cardItem) {
            if (cardItem.getValue() == 1) {
                textTop.setText("A");
                textBottom.setText("A");
            } else if (cardItem.getValue() == 11) {
                textTop.setText("J");
                textBottom.setText("J");
            } else if (cardItem.getValue() == 12) {
                textTop.setText("Q");
                textBottom.setText("Q");
            } else if (cardItem.getValue() == 13) {
                textTop.setText("K");
                textBottom.setText("K");
            } else {
                textTop.setText(String.valueOf(cardItem.getValue()));
                textBottom.setText(String.valueOf(cardItem.getValue()));
            }

            switch (cardItem.getSuit()) {
                case CLUBS:
                    imageTop.setImageResource(R.drawable.c);
                    imageBottom.setImageResource(R.drawable.c);
                    imageCenter.setImageResource(R.drawable.c);
                    break;
                case DIAMONDS:
                    imageTop.setImageResource(R.drawable.d);
                    imageBottom.setImageResource(R.drawable.d);
                    imageCenter.setImageResource(R.drawable.d);
                    break;
                case SPADES:
                    imageTop.setImageResource(R.drawable.s);
                    imageBottom.setImageResource(R.drawable.s);
                    imageCenter.setImageResource(R.drawable.s);
                    break;
                case HEARTS:
                    imageTop.setImageResource(R.drawable.h);
                    imageBottom.setImageResource(R.drawable.h);
                    imageCenter.setImageResource(R.drawable.h);
                    break;
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardItems.remove(cardItem);
                    notifyItemRemoved(getAdapterPosition());
                    onItemClickListener.onClicked(cardItem, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClicked(CardItem cardItem, int position);
    }
}
