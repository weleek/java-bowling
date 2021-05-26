package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.state.Ready;
import bowling.domain.state.State;

public abstract class Frame {
    public State state;

    abstract public void pitching(int downPin);
    abstract public boolean isEndFrame();
    abstract public String getFrameResult();
    abstract public Score getScore();
}
