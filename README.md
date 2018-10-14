# Demo App

## Source

Deck implementation: ```src/main/java/com/casino/blackjack/domain/Deck.java```
REST API implemenation: ```src/main/java/com/casino/blackjack/web/DeckController.java```

## Requirements

  - JDK >= 1.8

## Running

  - ```./gradlew bootRun```

## User Guide

  - Open browser at http://localhost:8080/

## API

```POST /deck/_deal_one_card``` Deal one card from the deck.

```POST /deck/_new``` Creates a new deck.

```POST /deck/_shuffle``` Shuffle cards in the deck.
