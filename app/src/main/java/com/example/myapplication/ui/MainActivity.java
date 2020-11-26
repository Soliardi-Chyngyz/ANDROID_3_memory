package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.data.Card;

public class MainActivity extends AppCompatActivity implements EmojiGameAdapter.CardCallBack {
    private RecyclerView emojiRecycler;
    private EmojiGameAdapter emojiGameAdapter;
    private EmojiGame emojiGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiRecycler = findViewById(R.id.rv_cards);
        emojiRecycler.setLayoutManager(new GridLayoutManager(this, 4));
        emojiGame = new EmojiGame();

        emojiRecycler.setOnClickListener(view -> {

        });

        emojiGameAdapter = new EmojiGameAdapter(emojiGame, this);
        emojiRecycler.setAdapter(emojiGameAdapter);
    }

    @Override
    public void choose(Card<String> card) {
        emojiGame.choose(card);
        emojiGameAdapter.notifyDataSetChanged();
    }
}