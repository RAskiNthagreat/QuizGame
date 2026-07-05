package tests;

import dao.ScoreDAO;
import models.Score;

import java.sql.Timestamp;
import java.util.List;

public class ScoreDAOTest {

    public static void main(String[] args) {

        ScoreDAO dao = new ScoreDAO();

        Score score = new Score(
                0,
                "Raskin",
                8,
                "Easy",
                new Timestamp(System.currentTimeMillis())
        );

        if (dao.saveScore(score)) {

            System.out.println("Score saved.");

        } else {

            System.out.println("Save failed.");

        }

        System.out.println();

        List<Score> scores = dao.getTopScores();

        for (Score s : scores) {

            System.out.println(s);

        }

    }

}