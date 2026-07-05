package dao;

import database.DatabaseConnection;
import models.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    public List<Question> getQuestionsByDifficulty(String difficulty) {

        List<Question> questions = new ArrayList<>();

        String sql = "SELECT * FROM questions WHERE difficulty = ? ORDER BY RAND()";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, difficulty);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Question question = new Question();

                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));
                question.setOptionA(resultSet.getString("option_a"));
                question.setOptionB(resultSet.getString("option_b"));
                question.setOptionC(resultSet.getString("option_c"));
                question.setOptionD(resultSet.getString("option_d"));
                question.setCorrectAnswer(resultSet.getString("correct_answer"));
                question.setDifficulty(resultSet.getString("difficulty"));
                question.setCategory(resultSet.getString("category"));

                questions.add(question);
            }

        } catch (SQLException e) {

            System.out.println("Error loading questions:");
            System.out.println(e.getMessage());

        }

        return questions;
    }

}