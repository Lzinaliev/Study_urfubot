package exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuestionRepository questionRepository = new QuestionRepository();
        ExamDialog examDialog = new ExamDialog(questionRepository);

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleDialog consoleDialog = new ConsoleDialog(examDialog, scanner);
            consoleDialog.start();
        }
    }
}