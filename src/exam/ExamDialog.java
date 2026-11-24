package exam;

public class ExamDialog {
    private static final String HELP_COMMAND = "\\help";

    private final QuestionRepository questionRepository;
    private Question currentQuestion;
    private int correctAnswers;
    private int totalAnswers;

    public ExamDialog(QuestionRepository questionRepository) {
        if (questionRepository == null) {
            throw new IllegalArgumentException("Хранилище вопросов не может быть null");
        }

        this.questionRepository = questionRepository;
    }

    public String getGreeting() {
        return """
                Здравствуйте! Я бот для подготовки к экзамену.

                Я задаю вопросы из экзаменационного билета и проверяю ваши ответы.
                Введите ответ текстом и нажмите Enter.

                В любой момент можно ввести команду \\help, чтобы снова увидеть справку.
                """;
    }

    public String getHelp() {
        return """
                Как со мной взаимодействовать:

                1. Я задаю вопрос по материалу экзамена.
                2. Вы вводите ответ в консоль.
                3. Я сообщаю, верен ли ответ, и при необходимости показываю правильный.
                4. После этого задаю следующий вопрос.

                Команды:
                \\help — показать справку;
                любой другой текст — считать его ответом на текущий вопрос.
                """;
    }

    public String getNextQuestion() {
        currentQuestion = questionRepository.getNextQuestion();
        return currentQuestion.getText();
    }

    public DialogResponse handleUserInput(String userInput) {
        if (userInput == null) {
            return new DialogResponse("Пожалуйста, введите ответ или команду \\help.", false);
        }

        String input = userInput.trim();

        if (HELP_COMMAND.equalsIgnoreCase(input)) {
            return new DialogResponse(getHelp(), false);
        }

        if (currentQuestion == null) {
            return new DialogResponse("Сначала получите вопрос.", false);
        }

        totalAnswers++;

        if (currentQuestion.isCorrect(input)) {
            correctAnswers++;
            return new DialogResponse(
                    "Верно! Следующий вопрос:",
                    true
            );
        }

        return new DialogResponse(
                "Неверно. Правильный ответ: " + currentQuestion.getCorrectAnswer()
                        + ". Следующий вопрос:",
                false
        );
    }

    public String getStatistics() {
        return "Отвечено вопросов: " + totalAnswers
                + ", правильных ответов: " + correctAnswers + ".";
    }
}