package bowling.domain.state;

import bowling.domain.DownPin;
import bowling.domain.Score;

public class Other implements State {
    private final static int SPARE_PIN_COUNT = 10;
    private final static int GUTTER_PIN_COUNT = 0;

    private final DownPin downPin;

    public Other(int downPin) {
        this.downPin = new DownPin(downPin);
    }

    @Override
    public State pitching(int downPin) {
        DownPin secondDownPin = new DownPin(downPin);
        if (this.downPin.count() + secondDownPin.count() == SPARE_PIN_COUNT) {
            return new Spare(this.downPin.count());
        }
        if (this.downPin.count() + secondDownPin.count() == GUTTER_PIN_COUNT) {
            return new Gutter();
        }
        return new Miss(this.downPin.count(), secondDownPin.count());
    }

    @Override
    public boolean isContinue() {
        return true;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String getResult() {
        return String.valueOf(downPin.count());
    }

    @Override
    public Score getScore() {
        return null;
    }
}
