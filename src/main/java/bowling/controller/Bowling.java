package bowling.controller;

import bowling.domain.Player;
import bowling.views.InputView;
import bowling.views.ResultView;

public class Bowling {
    public void run() {
        Player player = Player.from(InputView.playerName());
    }
}
