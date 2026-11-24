package exam;

public final class DialogResponse {
    private final String message;
    private final boolean isCorrect;

    public DialogResponse(String message, boolean isCorrect) {
        this.message = message;
        this.isCorrect = isCorrect;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}