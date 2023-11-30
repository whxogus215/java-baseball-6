package baseball.dto;

public enum ResultType {

    ALL_STRIKE(true, "게임 세트 종료"),
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
