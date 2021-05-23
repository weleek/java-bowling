package bowling.domain.state;

public class Strike implements State {

    @Override
    public State pitching(int downPin) {
        throw new RuntimeException("더 이상 투구 할 수 없습니다.");
    }

    @Override
    public boolean isContinue() {
        return false;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public String getResult() {
        return "X";
    }
}
