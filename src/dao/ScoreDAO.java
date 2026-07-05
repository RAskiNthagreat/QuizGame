package dao;

import database.DatabaseConnection;
import models.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {

    public boolean saveScore(Score score) {

        String sql =
                "INSERT INTO scores(player_name, score, difficulty) VALUES (?, ?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, score.getPlayerName());
            statement.setInt(2, score.getScore());
            statement.setString(3, score.getDifficulty());

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            System.out.println("Error saving score:");
            System.out.println(e.getMessage());

            return false;
        }

    }

    public List<Score> getTopScores() {

        List<Score> scores = new ArrayList<>();

        String sql =
                "SELECT * FROM scores ORDER BY score DESC LIMIT 10";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Score score = new Score();

                score.setId(rs.getInt("id"));
                score.setPlayerName(rs.getString("player_name"));
                score.setScore(rs.getInt("score"));
                score.setDifficulty(rs.getString("difficulty"));
                score.setDatePlayed(rs.getTimestamp("date_played"));

                scores.add(score);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return scores;

    }

}