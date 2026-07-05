package tests;

import models.Question;
import services.QuizManager;

public class QuizManagerTest {

    public static void main(String[] args) {

        QuizManager quiz = new QuizManager("Raskin", "Easy");

        while (!quiz.isQuizFinished()) {

            Question q = quiz.getCurrentQuestion();

            System.out.println(q.getQuestion());

            quiz.checkAnswer("A");

            quiz.nextQuestion();
        }

        System.out.println("----------------");

        System.out.println("Score: " + quiz.getScore());

        System.out.println("Correct: " + quiz.getCorrectAnswers());

        System.out.println("Incorrect: " + quiz.getIncorrectAnswers());

    }

}