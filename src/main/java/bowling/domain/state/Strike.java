package bowling.domain.state;

import bowling.domain.Score;
import bowling.exception.CannotPitchingException;

public class Strike implements State {
    private final static String DISPLAY_RESULT = "X";
    private final static int SCORE = 10;
    private final static int LEFT = 2;

    @Override
    public State pitching(int downPin) {
        throw new CannotPitchingException();
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
        return DISPLAY_RESULT;
    }

    @Override
    public Score getScore() {
        return new Score(SCORE, LEFT);
    }
}
