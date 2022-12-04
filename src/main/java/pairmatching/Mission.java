package pairmatching;

public enum Mission {
    CAR_GAME("자동차경주", "레벨1"),
    LOTTO("로또", "레벨1"),
    BASEBALL_GAME("숫자야구게임", "레벨1"),
    SHOPPING_BASKET("장바구니", "레벨2"),
    PAY("결제", "레벨2"),
    SUBWAY("지하철노선", "레벨2"),
    PERFORMANCE("성능개선", "레벨4"),
    RELEASE("배포", "레벨4");

    private String mission, level;

    Mission(String mission, String level) {
        this.mission = mission;
        this.level = level;
    }

    public String getMission() {
        return mission;
    }

    public String getLevel() {
        return level;
    }
}