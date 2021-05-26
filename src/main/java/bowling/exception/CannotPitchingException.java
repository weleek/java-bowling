package bowling.exception;

public class CannotPitchingException extends RuntimeException {
    private final static String value = "더 이상 투구 할 수 없습니다.";

    public CannotPitchingException() {
        super(value);
    }
}
