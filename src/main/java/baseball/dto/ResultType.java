package baseball.dto;

public enum ResultType {

    ALL_STRIKE(true, "게임 세트 종료"),
    BALL_AND_STRIKE(false, "볼과 스트라이크 존재"),
    ONLY_STRIKE(false, "스트라이크만 존재"),
    ONLY_BALL(false, "볼만 존재"),
    NOTHING(false, "낫싱"),
    NOT_END(false, "게임 계속 진행");

    private boolean isEnd;
    private String detail;

    ResultType(boolean isEnd, String detail) {
        this.isEnd = isEnd;
        this.detail = detail;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
