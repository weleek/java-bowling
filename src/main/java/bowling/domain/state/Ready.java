package bowling.domain.state;

public class Ready implements State {

    @Override
    public State pitching(int downPin) {
        if (downPin == 10) {
            return new Strike();
        }
        return new Other(downPin);
    }

    @Override
    public boolean isContinue() {
        return true;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String getResult() {
        return "";
    }
}
