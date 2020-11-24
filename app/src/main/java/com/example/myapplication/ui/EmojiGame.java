package com.example.myapplication.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.data.Card;
import com.example.myapplication.data.Game;

import java.util.List;

public class EmojiGame {
    private final Game <String> game;

    public EmojiGame(){
        List<String> content = List.of("🎃", "👹","\uD83D\uDE44", "\uD83D\uDE18", "\uD83D\uDE01");
        game = new Game<>(content);
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public void close(Card<String> card) {
        game.close(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
