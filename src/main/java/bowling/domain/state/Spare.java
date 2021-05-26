package bowling.domain.state;

import bowling.domain.DownPin;
import bowling.domain.Score;
import bowling.exception.CannotPitchingException;

public class Spare implements State {
    private final static String DISPLAY_RESULT = "|/";
    private final static int SCORE = 10;
    private final static int LEFT = 1;
    private final DownPin downPin;

    public Spare(int downPin) {
        this.downPin = new DownPin(downPin);
    }

    @Override
    public boolean isContinue() {
        return false;
    }

    @Override
    public State pitching(int downPin) {
        throw new CannotPitchingException();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public String getResult() {
        return downPin.count() + DISPLAY_RESULT;
    }

    @Override
    public Score getScore() {
        return new Score(SCORE, LEFT);
    }
}
