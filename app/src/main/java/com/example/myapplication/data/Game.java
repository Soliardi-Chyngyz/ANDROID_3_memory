package com.example.myapplication.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {
    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> content) {
        for (int i = 0; i < content.size(); i++) {
            cards.add(new Card<>(false, false, content.get(i), i * 2));
            cards.add(new Card<>(false, false, content.get(i), i * 2 + 1));
        }
        Collections.shuffle(cards);
    }


    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp())
            checkPairs(card);
    }

    private void checkPairs(Card<CardContent> card) {
        for (Card<CardContent> anotherCard : cards) {
            if (anotherCard.isFaceUp() && anotherCard.getId() != card.getId()) {
                if (anotherCard.getContent().equals(card.getContent())) {
                    anotherCard.setMatched(true);
                    card.setMatched(true);
                } else {
                    card.setFaceUp(false);
                    anotherCard.setFaceUp(false);
                }

            }
        }
        removePair();
    }

    private void removePair() {
        List<Card<CardContent>> newList = new ArrayList<>(cards);
        for (Card<CardContent> card : cards) {
            if (card.isMatched())
                newList.remove(card);
        }
        cards.clear();
        cards.addAll(newList);
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }
}
