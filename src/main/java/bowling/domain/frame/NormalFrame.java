package bowling.domain.frame;

public class NormalFrame extends Frame {

    @Override
    public void pitching(int downPin) {
        if (state.isContinue()) {
            state.pitching(downPin);
        }
    }

    @Override
    public boolean isEndFrame() {
        return state.isFinished();
    }

    @Override
    public String getFrameResult() {
        return state.getResult();
    }

}
