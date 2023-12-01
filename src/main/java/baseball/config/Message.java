package baseball.config;

public enum Message {

    REQUEST_INPUT("숫자를 입력해주세요 : ");

    private String detail;

    Message(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
