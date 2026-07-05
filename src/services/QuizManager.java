package services;

import dao.QuestionDAO;
import models.Question;

import java.util.List;

public class QuizManager {

    private String playerName;
    private String difficulty;

    private List<Question> questions;

    private int currentQuestionIndex;
    private int score;
    private int correctAnswers;
    private int incorrectAnswers;

    public QuizManager(String playerName, String difficulty) {

        this.playerName = playerName;
        this.difficulty = difficulty;

        QuestionDAO questionDAO = new QuestionDAO();

        questions = questionDAO.getQuestionsByDifficulty(difficulty);

        if (questions.size() > 10) {
            questions = questions.subList(0, 10);
        }

        currentQuestionIndex = 0;
        score = 0;
        correctAnswers = 0;
        incorrectAnswers = 0;
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public boolean checkAnswer(String answer) {

        Question question = getCurrentQuestion();

        if (question == null) {
            return false;
        }

        if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            score++;
            correctAnswers++;
            return true;
        } else {
            incorrectAnswers++;
            return false;
        }
    }

    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public boolean isQuizFinished() {
        return currentQuestionIndex >= questions.size();
    }

    public int getScore() {
        return score;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionIndex + 1;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getDifficulty() {
        return difficulty;
    }
}