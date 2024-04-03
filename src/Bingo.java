class Bingo {
    private BingoCard card;

    public BingoGame() {
        card = new BingoCard();
    }

    public void play() {
        System.out.println("Welcome to Bingo!");
        card.printCard();
    }
}

