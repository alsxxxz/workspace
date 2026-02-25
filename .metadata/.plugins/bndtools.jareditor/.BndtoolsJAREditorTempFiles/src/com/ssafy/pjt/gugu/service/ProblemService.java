package com.ssafy.pjt.gugu.service;

import java.util.Random;

import com.ssafy.pjt.gugu.dto.Problem;

public class ProblemService {
    private static ProblemService service = new ProblemService();

    private ProblemService() {
    }

    public static ProblemService getService() {
        return service;
    }

    public Problem makeProblem() {
        Random rand = new Random();
        int num1 = rand.nextInt(9) + 1;
        int num2 = rand.nextInt(9) + 1;
        return new Problem(num1, num2, num1 * num2);
    }

    public boolean isCorrect(Problem problem, int userAnswer) {
        return problem.correctAnswer()==userAnswer;
    }
}
