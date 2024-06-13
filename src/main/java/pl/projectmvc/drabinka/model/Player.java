package pl.projectmvc.drabinka.model;

public class Player {
    String namePlayer;
    int rank;

    public Player(String namePlayer, int rank) {
        this.namePlayer = namePlayer;
        this.rank = rank;

    }

    @Override
    public String toString() {
        return  namePlayer + " | " + rank;
    }
    public String getNamePlayer() {
        return namePlayer;
    }
    public int getRank() {
        return rank;
    }
}