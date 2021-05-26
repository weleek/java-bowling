package bowling.controller;

import bowling.domain.Player;
import bowling.domain.frame.Frames;
import bowling.views.InputView;
import bowling.views.ResultView;

public class Bowling {
    public void run() {
        Player player = Player.from(InputView.playerName());
        ResultView.showScoreBoard(player);

        Frames frames = new Frames();
        while (!frames.isEndFrames()) {
            int pitching = InputView.pitchingNumber(frames.currentRound());
            frames.rollingBowl(pitching);
            ResultView.showScoreBoard(player, frames);
            frames.adjustRound();
        }
    }
}
