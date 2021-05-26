package bowling.domain.frame;

import bowling.domain.Score;
import bowling.exception.CannotPitchingException;

public class NormalFrame extends Frame {
    private final static int FINAL_FRAME = 10;

    @Override
    public void pitching(int downPin) {
        if (!state.isContinue()) {
            throw new CannotPitchingException();
        }
        state = state.pitching(downPin);
    }

    @Override
    public boolean isEndFrame() {
        return state.isFinished();
    }

    @Override
    public String getFrameResult() {
        return state.getResult();
    }

    @Override
    public Score getScore() {

        return null;
    }

}
