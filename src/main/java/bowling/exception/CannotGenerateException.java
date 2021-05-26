package bowling.exception;

public class CannotGenerateException extends RuntimeException{
    private final static String value = "더 이상 생성 할 수 없습니다.";

    public CannotGenerateException() {
        super(value);
    }
}
