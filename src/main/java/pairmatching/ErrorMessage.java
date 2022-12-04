package pairmatching;

public enum ErrorMessage {
    INPUT_FUNCTION("[ERROR] 기능은 1, 2, 3, Q만 입력 가능합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
