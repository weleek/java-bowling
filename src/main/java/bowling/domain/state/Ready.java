package bowling.domain.state;

import bowling.domain.Score;

public class Ready implements State {
    private final static int STRIKE_PIN_COUNT = 10;
    private final static String DISPLAY_RESULT = "";

    @Override
    public State pitching(int downPin) {
        if (downPin == STRIKE_PIN_COUNT) {
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
        return DISPLAY_RESULT;
    }

    @Override
    public Score getScore() {
        return null;
    }

}
