package main;

import dao.QuestionDAO;
import models.Question;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuestionDAO dao = new QuestionDAO();

        List<Question> questions =
                dao.getQuestionsByDifficulty("Easy");

        System.out.println("Easy Questions Found: "
                + questions.size());

        for (Question question : questions) {

            System.out.println("---------------------------");

            System.out.println(question.getQuestion());

            System.out.println("A. " + question.getOptionA());

            System.out.println("B. " + question.getOptionB());

            System.out.println("C. " + question.getOptionC());

            System.out.println("D. " + question.getOptionD());

        }

    }

}