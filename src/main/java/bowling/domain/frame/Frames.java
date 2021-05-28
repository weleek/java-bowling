package bowling.domain.frame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Frames {
    private final static int FINAL_FRAME  = 10;
    private final static int FIRST_FRAME  = 1;
    private final static int MIN_SIZE = 0;
    private final static int PREVIOUS_INDEX = 1;

    private final List<Frame> frames = new ArrayList<>();
    private int currentRound = 1;

    public Frames() {
        addFrame();
    }

    private void addFrame() {
        if (frames.size() <= MIN_SIZE) {
            setFirstFrame();
        }
        IntStream.range(FIRST_FRAME, FINAL_FRAME)
                .forEach(i -> frames.add(frames.get(i - PREVIOUS_INDEX).next()));
    }

    private void setFirstFrame() {
        if (frames.size() > MIN_SIZE) {
            throw new RuntimeException("이미 생성된 프레임이 존재 합니다.");
        }
        frames.add(new NormalFrame(FIRST_FRAME));
    }

    public int currentRound() {
        return currentRound;
    }

    public void adjustRound() {
        if (isEndCurrentFrame()) {
            this.currentRound++;
        }
    }

    public void rollingBowl(int pinCount) {
        frames.get(currentRound)
                .pitching(pinCount);
    }

    public boolean isEndCurrentFrame() {
        return frames.get(currentRound)
                .isEndFrame();
    }

    public boolean isEndFrames() {
        return frames.get(FINAL_FRAME)
                .isEndFrame();
    }

    public List<Frame> frames() {
        return Collections.unmodifiableList(frames);
    }

    @Override
    public String toString() {
        return "Frames{" +
                "frames=" + frames +
                ", round=" + currentRound +
                '}';
    }
}
