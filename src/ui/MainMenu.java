package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    private JButton startButton;
    private JButton highScoreButton;
    private JButton instructionsButton;
    private JButton exitButton;

    public MainMenu() {

        setTitle("Java Quiz Game");

        setSize(500, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 1, 15, 15));

        panel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel title = new JLabel("JAVA QUIZ GAME");

        title.setHorizontalAlignment(SwingConstants.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 26));

        startButton = new JButton("Start Quiz");

        highScoreButton = new JButton("High Scores");

        instructionsButton = new JButton("Instructions");

        exitButton = new JButton("Exit");

        panel.add(title);

        panel.add(startButton);

        panel.add(highScoreButton);

        panel.add(instructionsButton);

        panel.add(exitButton);

        add(panel);
        exitButton.addActionListener(e -> System.exit(0));

        startButton.addActionListener(e -> {

    new DifficultySelection();

    dispose();

});

    }

}