package bowling.domain.state;

import bowling.domain.DownPin;
import bowling.domain.Score;
import bowling.exception.CannotPitchingException;

public class Miss implements State {
    private final static String SEPARATOR = "|";
    private final static int LEFT = 0;

    private final DownPin firstPin;
    private final DownPin secondPin;

    public Miss(int firstPin, int secondPin) {
        this.firstPin = new DownPin(firstPin);
        this.secondPin = new DownPin(secondPin);
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
        return firstPin + SEPARATOR + secondPin;
    }

    @Override
    public Score getScore() {
        return new Score(firstPin.count() + secondPin.count(), LEFT);
    }
}
