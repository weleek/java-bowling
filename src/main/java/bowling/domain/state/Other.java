package bowling.domain.state;

import bowling.domain.DownPin;

public class Other implements State {
    private final DownPin downPin;

    public Other(int downPin) {
        this.downPin = new DownPin(downPin);
    }

    @Override
    public State pitching(int downPin) {
        DownPin secondDownPin = new DownPin(downPin);
        if (this.downPin.count() + secondDownPin.count() == 10) {
            return new Spare(this.downPin.count());
        }
        if (this.downPin.count() + secondDownPin.count() == 0) {
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
}
