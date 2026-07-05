package models;

import java.sql.Timestamp;

public class Score {

    private int id;
    private String playerName;
    private int score;
    private String difficulty;
    private Timestamp datePlayed;

    // Default Constructor
    public Score() {
    }

    // Parameterized Constructor
    public Score(int id, String playerName, int score,
                 String difficulty, Timestamp datePlayed) {

        this.id = id;
        this.playerName = playerName;
        this.score = score;
        this.difficulty = difficulty;
        this.datePlayed = datePlayed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Timestamp getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Timestamp datePlayed) {
        this.datePlayed = datePlayed;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", score=" + score +
                ", difficulty='" + difficulty + '\'' +
                ", datePlayed=" + datePlayed +
                '}';
    }
}