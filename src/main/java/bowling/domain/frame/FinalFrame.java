package bowling.domain.frame;

import bowling.domain.state.State;

import java.util.ArrayList;
import java.util.List;

public class FinalFrame extends Frame {
    private List<State> states = new ArrayList<>();

    @Override
    public void pitching(int downPin) {

    }

    @Override
    public boolean isEndFrame() {
        return false;
    }

    @Override
    public String getFrameResult() {
        return null;
    }
}
