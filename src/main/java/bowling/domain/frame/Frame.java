package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.state.Ready;
import bowling.domain.state.State;

import java.util.Objects;

public abstract class Frame {
    public Frame nextFrame;
    public State state;
    public int round;

    abstract public void pitching(int downPin);
    abstract public boolean isEndFrame();
    abstract public String getFrameResult();
    abstract public Score getScore();
    abstract public Frame next();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return round == frame.round && Objects.equals(nextFrame, frame.nextFrame) && Objects.equals(state, frame.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextFrame, state, round);
    }

    @Override
    public String toString() {
        return "Frame{" +
                "state=" + state +
                ", round=" + round +
                '}';
    }
}
