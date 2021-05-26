package bowling.domain.state;

import bowling.domain.Score;
import bowling.exception.CannotPitchingException;

public class Gutter implements State {
    private final static String DISPLAY_RESULT = "-|-";
    private final static int SCORE_AND_LEFT = 0;

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
        return new Score(SCORE_AND_LEFT, SCORE_AND_LEFT);
    }
}
