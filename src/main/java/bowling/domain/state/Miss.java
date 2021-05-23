package bowling.domain.state;

public class Miss implements State {
    private final int firstPin;
    private final int secondPin;

    public Miss(int firstPin, int secondPin) {
        this.firstPin = firstPin;
        this.secondPin = secondPin;
    }

    @Override
    public boolean isContinue() {
        return false;
    }

    @Override
    public State pitching(int downPin) {
        throw new RuntimeException("더 이상 투구 할 수 없습니다.");
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public String getResult() {
        return firstPin + "|" + secondPin;
    }
}
