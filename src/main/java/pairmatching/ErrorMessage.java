package pairmatching;

public enum ErrorMessage {
    INPUT_FUNCTION("[ERROR] 기능은 1, 2, 3, Q만 입력 가능합니다."),
    INPUT_COURSE_LEVEL_MISSION("[ERROR] 과정, 레벨, 미션을 제대로 입력해주세요."),
    NOT_EXIST_FILE("[ERROR] 파일이 존재 하지 않습니다."),
    NOT_EXIST_RESULT("[ERROR] 매칭 이력이 없습니다."),
    INPUT_YES_OR_NO("[ERROR] 네 또는 아니오 입력 가능합니다."),
    PRINT_MATCHING_FAIL("[ERROR] 매칭에 실패하였습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
