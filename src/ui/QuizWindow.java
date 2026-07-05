package ui;

import models.Question;
import services.QuizManager;

import javax.swing.*;
import java.awt.*;

public class QuizWindow extends JFrame {

    private QuizManager quizManager;

    private JLabel questionNumberLabel;
    private JLabel scoreLabel;
    private JTextArea questionArea;

    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;

    private ButtonGroup buttonGroup;

    private JButton nextButton;

    public QuizWindow(String playerName, String difficulty) {

        quizManager = new QuizManager(playerName, difficulty);

        setTitle("Quiz Game");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        initializeComponents();

        loadQuestion();

        setVisible(true);
    }

    private void initializeComponents() {

        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new GridLayout(1, 2));

        questionNumberLabel = new JLabel();
        scoreLabel = new JLabel();

        topPanel.add(questionNumberLabel);
        topPanel.add(scoreLabel);

        add(topPanel, BorderLayout.NORTH);

        questionArea = new JTextArea();
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setFont(new Font("Arial", Font.PLAIN, 18));

        add(questionArea, BorderLayout.CENTER);

        JPanel optionsPanel = new JPanel(new GridLayout(5, 1));

        buttonGroup = new ButtonGroup();

        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();

        buttonGroup.add(optionA);
        buttonGroup.add(optionB);
        buttonGroup.add(optionC);
        buttonGroup.add(optionD);

        optionsPanel.add(optionA);
        optionsPanel.add(optionB);
        optionsPanel.add(optionC);
        optionsPanel.add(optionD);

        nextButton = new JButton("Next");

        optionsPanel.add(nextButton);

        add(optionsPanel, BorderLayout.SOUTH);

        nextButton.addActionListener(e -> checkAnswerAndContinue());
    }

    private void loadQuestion() {

        Question q = quizManager.getCurrentQuestion();

        if (q == null) {
            return;
        }

        questionNumberLabel.setText(
                "Question " +
                        quizManager.getCurrentQuestionNumber() +
                        "/" +
                        quizManager.getTotalQuestions());

        scoreLabel.setText("Score: " + quizManager.getScore());

        questionArea.setText(q.getQuestion());

        optionA.setText("A. " + q.getOptionA());
        optionB.setText("B. " + q.getOptionB());
        optionC.setText("C. " + q.getOptionC());
        optionD.setText("D. " + q.getOptionD());

        buttonGroup.clearSelection();
    }

    private void checkAnswerAndContinue() {

        String selectedAnswer = null;

        if (optionA.isSelected()) {
            selectedAnswer = "A";
        } else if (optionB.isSelected()) {
            selectedAnswer = "B";
        } else if (optionC.isSelected()) {
            selectedAnswer = "C";
        } else if (optionD.isSelected()) {
            selectedAnswer = "D";
        }

        if (selectedAnswer == null) {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
            return;
        }

        quizManager.checkAnswer(selectedAnswer);

        quizManager.nextQuestion();

        if (quizManager.isQuizFinished()) {

            new ui.ResultScreen(
                quizManager.getPlayerName(),
                quizManager.getDifficulty(),
                quizManager.getScore(),
                quizManager.getCorrectAnswers(),
                quizManager.getIncorrectAnswers()
            );

            dispose();
            return;
        }

        loadQuestion();
    }
}