package bowling.domain.frame;

import bowling.domain.KnockDownPins;
import bowling.domain.Pitching;
import bowling.domain.pitchings.Pitchings;

public abstract class Frame {
    private final Pitchings pitchings;
    private int score;

    public Frame(Pitchings pitchings) {
        this.pitchings = pitchings;
        score = 0;
    }

    abstract public Frame initNextFrame();

    public void setKnockDownPins(KnockDownPins knockDownPins) {
        pitchings.addPitching(knockDownPins);
    }

    public Pitchings getPitchings() {
        return pitchings;
    }

    public boolean isEnd() {
        return pitchings.isEnd();
    }

    public abstract Integer getScore();

    public abstract Pitching getNextPitching();

    public abstract Pitching getNextAndNextPitching();
}
