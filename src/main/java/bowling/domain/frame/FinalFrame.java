package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.state.Spare;
import bowling.domain.state.State;
import bowling.domain.state.Strike;
import bowling.exception.CannotPitchingException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FinalFrame extends Frame {
    private final static String DELIMITER = "|";
    private final static int DEFAULT_PITCHING_COUNT = 2;
    private final static int FULL_PITCHING_COUNT = 3;

    private final List<State> states = new ArrayList<>();
    @Override
    public void pitching(int downPin) {
        if (!isContinue()) {
            throw new CannotPitchingException();
        }
        states.add(state.pitching(downPin));
    }

    @Override
    public boolean isEndFrame() {
        return !isContinue();
    }

    @Override
    public String getFrameResult() {
        return states.stream()
                .map(State::getResult)
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public Score getScore() {
        return null;
    }

    private boolean isContinue() {
        return (states.size() < DEFAULT_PITCHING_COUNT || states.stream().anyMatch(this::isContainsStrikeOrSpare))
                && states.size() < FULL_PITCHING_COUNT;
    }

    private boolean isContainsStrikeOrSpare(Object o) {
        return o instanceof Strike || o instanceof Spare;
    }

}
