package com.example.atry;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements CardsAdapter.OnItemClickListener {
    private RecyclerView recyclerViewMe;
    private RecyclerView recyclerViewComputer1;
    private RecyclerView recyclerViewComputer2;
    private RecyclerView  recyclerViewComputer3;
    private List<CardItem> CardsPlayed;
    private List<CardItem> cardItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_avtivity);

        recyclerViewComputer1 = findViewById(R.id.recyclerViewComp1);
        recyclerViewComputer2 = findViewById(R.id.recyclerViewComp2);
        recyclerViewComputer3 = findViewById(R.id.recyclerViewComp3);

        cardItems = new ArrayList<>();
        for (int suit = 0; suit < 4; suit++) {
            for (int i = 0; i < 13; i++) {
                CardItem cardItem = new CardItem();
                cardItem.setValue(i + 1);
                switch (suit) {
                    case 0:
                        cardItem.setSuit(Suit.CLUBS);
                        break;
                    case 1:
                        cardItem.setSuit(Suit.DIAMONDS);
                        break;
                    case 2:
                        cardItem.setSuit(Suit.SPADES);
                        break;
                    case 3:
                        cardItem.setSuit(Suit.HEARTS);
                        break;
                }
                cardItems.add(cardItem);
            }
        }

        shuffleDeck();

        //User Deck
        List<CardItem> cardItemsMe = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            int random = new Random().nextInt(cardItems.size());
            cardItemsMe.add(cardItems.get(random));
            cardItems.remove(random);
        }

        recyclerViewMe = findViewById(R.id.recyclerViewMe);
        recyclerViewMe.setLayoutManager(new GridLayoutManager
                (this, 13, RecyclerView.VERTICAL, false));
        recyclerViewMe.setAdapter(new CardsAdapter(cardItemsMe, this));

        //Computer 1 Deck
        List<CardItem> cardItemsComputer1 = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            int random = new Random().nextInt(cardItems.size());
            cardItemsComputer1.add(cardItems.get(random));
            cardItems.remove(random);
        }


        recyclerViewComputer1.setLayoutManager(new GridLayoutManager
                (this, 13, RecyclerView.HORIZONTAL, false));
        recyclerViewComputer1.setAdapter(new CardsAdapter(cardItemsComputer1, this));

        //Computer 2 Deck
        List<CardItem> cardItemsComputer2 = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            int random = new Random().nextInt(cardItems.size());
            cardItemsComputer2.add(cardItems.get(random));
            cardItems.remove(random);
        }

        recyclerViewComputer2.setLayoutManager(new GridLayoutManager
                (this, 13, RecyclerView.VERTICAL, false));
        recyclerViewComputer2.setAdapter(new CardsAdapter(cardItemsComputer2, this));

        //Computer 3 Deck
        List<CardItem> cardItemsComputer3 = new ArrayList<>();
        for(int i = 0; i < 13; i++){
            cardItemsComputer3.add(cardItems.get(i));
        }

        recyclerViewComputer3.setLayoutManager(new GridLayoutManager
                (this, 13, RecyclerView.HORIZONTAL, false));
        recyclerViewComputer3.setAdapter(new CardsAdapter(cardItemsComputer3, this));
    }

    @Override
    public void onClicked(CardItem cardItem, int position) {
        recyclerViewMe.scrollToPosition(position);

        TextView textTop = findViewById(R.id.textCardTopGame);
        TextView textBottom = findViewById(R.id.textCardBottomGame);
        ImageView imageTop = findViewById(R.id.imageCardTopGame);
        ImageView imageBottom = findViewById(R.id.imageCardBottomGame);
        ImageView imageCenter = findViewById(R.id.imageCardCenterGame);

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
    }

    private void shuffleDeck() {
        Collections.shuffle(cardItems);
    }


}