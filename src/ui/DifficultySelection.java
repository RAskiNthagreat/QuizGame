package ui;

import javax.swing.*;
import java.awt.*;

public class DifficultySelection extends JFrame {

    private JTextField playerNameField;
    private JComboBox<String> difficultyComboBox;
    private JButton startButton;
    private JButton backButton;

    public DifficultySelection() {

        setTitle("Select Difficulty");

        setSize(450, 300);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setResizable(false);

        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Player Name:"));

        playerNameField = new JTextField();

        panel.add(playerNameField);

        panel.add(new JLabel("Difficulty:"));

        difficultyComboBox =
                new JComboBox<>(new String[]{"Easy","Medium","Hard"});

        panel.add(difficultyComboBox);

        startButton = new JButton("Start");

        backButton = new JButton("Back");

        panel.add(startButton);

        panel.add(backButton);

        add(panel);

    }

}