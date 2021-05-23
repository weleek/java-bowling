package bowling.domain.state;

public class Spare implements State {
    private final int downPin;

    public Spare(int downPin) {
        this.downPin = downPin;
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
        return false;
    }

    @Override
    public String getResult() {
        return downPin + "|/";
    }


}
