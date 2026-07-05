package ui;

import dao.ScoreDAO;
import models.Score;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;

public class ResultScreen extends JFrame {

    private JLabel resultLabel;
    private JLabel scoreLabel;
    private JLabel correctLabel;
    private JLabel incorrectLabel;

    private JButton saveButton;
    private JButton exitButton;

    private String playerName;
    private String difficulty;
    private int score;
    private int correct;
    private int incorrect;

    public ResultScreen(String playerName, String difficulty,
                        int score, int correct, int incorrect) {

        this.playerName = playerName;
        this.difficulty = difficulty;
        this.score = score;
        this.correct = correct;
        this.incorrect = incorrect;

        setTitle("Quiz Result");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initUI();

        setVisible(true);
    }

    private void initUI() {

        setLayout(new GridLayout(6, 1, 10, 10));

        resultLabel = new JLabel("Quiz Completed!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));

        scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);
        correctLabel = new JLabel("Correct: " + correct, SwingConstants.CENTER);
        incorrectLabel = new JLabel("Incorrect: " + incorrect, SwingConstants.CENTER);

        saveButton = new JButton("Save Score");
        exitButton = new JButton("Exit");

        add(resultLabel);
        add(scoreLabel);
        add(correctLabel);
        add(incorrectLabel);
        add(saveButton);
        add(exitButton);

        saveButton.addActionListener(e -> saveScore());

        exitButton.addActionListener(e -> System.exit(0));
    }

    private void saveScore() {

        Score s = new Score(
                0,
                playerName,
                score,
                difficulty,
                new Timestamp(System.currentTimeMillis())
        );

        ScoreDAO dao = new ScoreDAO();

        boolean success = dao.saveScore(s);

        if (success) {
            JOptionPane.showMessageDialog(this, "Score saved!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save score!");
        }

        saveButton.setEnabled(false);
    }
}