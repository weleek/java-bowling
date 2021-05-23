package bowling.domain.state;

public interface State {
    State pitching(int downPin);
    boolean isContinue();
    boolean isFinished();
    String getResult();
}
