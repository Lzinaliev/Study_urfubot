package exam;

import java.util.Scanner;

public class ConsoleDialog {
    private final ExamDialog examDialog;
    private final Scanner scanner;

    public ConsoleDialog(ExamDialog examDialog, Scanner scanner) {
        if (examDialog == null) {
            throw new IllegalArgumentException("Диалог не может быть null");
        }
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner не может быть null");
        }

        this.examDialog = examDialog;
        this.scanner = scanner;
    }

    public void start() {
        print(examDialog.getGreeting());
        print(examDialog.getNextQuestion());

        while (true) {
            String userInput = scanner.nextLine();

            DialogResponse response = examDialog.handleUserInput(userInput);
            print(response.getMessage());

            if (!response.isCorrect()) {
                print(examDialog.getNextQuestion());
            } else {
                print(examDialog.getNextQuestion());
            }

            print(examDialog.getStatistics());
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}