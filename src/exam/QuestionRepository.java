package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionRepository {
    private final List<Question> questions;
    private int currentIndex;

    public QuestionRepository() {
        this.questions = createExamQuestions();
        this.currentIndex = 0;
    }

    private List<Question> createExamQuestions() {
        List<Question> result = new ArrayList<>();

        result.add(new Question(
                "Что такое компилятор в Java?",
                "программа, переводящая исходный код в байт-код"
        ));

        result.add(new Question(
                "Какое ключевое слово используется для создания объекта класса?",
                "new"
        ));

        result.add(new Question(
                "Какой тип данных в Java хранит целые числа?",
                "int"
        ));

        result.add(new Question(
                "Как называется точка входа в Java-программу?",
                "main"
        ));

        result.add(new Question(
                "Какое ключевое слово означает наследование класса?",
                "extends"
        ));

        result.add(new Question(
                "Какой модификатор доступа делает член класса доступным только внутри этого класса?",
                "private"
        ));

        result.add(new Question(
                "Какая коллекция Java хранит уникальные элементы?",
                "set"
        ));

        result.add(new Question(
                "Какое исключение возникает при обращении к несуществующему индексу массива?",
                "arrayindexoutofboundsexception"
        ));

        return Collections.unmodifiableList(result);
    }

    public Question getNextQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("Список вопросов пуст");
        }

        Question question = questions.get(currentIndex);
        currentIndex = (currentIndex + 1) % questions.size();
        return question;
    }

    public int getQuestionCount() {
        return questions.size();
    }
}