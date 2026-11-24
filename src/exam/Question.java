package exam;

public final class Question {
    private final String text;
    private final String correctAnswer;

    public Question(String text, String correctAnswer) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Текст вопроса не может быть пустым");
        }
        if (correctAnswer == null || correctAnswer.isBlank()) {
            throw new IllegalArgumentException("Правильный ответ не может быть пустым");
        }

        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}