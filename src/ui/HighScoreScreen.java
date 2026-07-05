package ui;

import dao.ScoreDAO;
import models.Score;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class HighScoreScreen extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JButton refreshButton;
    private JButton backButton;

    public HighScoreScreen() {

        setTitle("High Scores");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        initUI();
        loadScores();

        setVisible(true);
    }

    private void initUI() {

        setLayout(new BorderLayout());

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Player");
        model.addColumn("Score");
        model.addColumn("Difficulty");
        model.addColumn("Date");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        refreshButton = new JButton("Refresh");
        backButton = new JButton("Back");

        bottomPanel.add(refreshButton);
        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);

        refreshButton.addActionListener(e -> loadScores());

        backButton.addActionListener(e -> {
            new MainMenu();
            dispose();
        });
    }

    private void loadScores() {

        model.setRowCount(0);

        ScoreDAO dao = new ScoreDAO();

        List<Score> scores = dao.getTopScores();

        for (Score s : scores) {

            model.addRow(new Object[]{
                    s.getId(),
                    s.getPlayerName(),
                    s.getScore(),
                    s.getDifficulty(),
                    s.getDatePlayed()
            });
        }
    }
}