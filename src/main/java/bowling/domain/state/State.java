package bowling.domain.state;

import bowling.domain.Score;

public interface State {
    State pitching(int downPin);
    boolean isContinue();
    boolean isFinished();
    String getResult();
    Score getScore();
}
