package bowling.domain;

public class Score {
    private int score;
    private int left;

    public Score(int score, int left) {
        this.score = score;
        this.left = left;
    }

    public int getScore() {
        return this.score;
    }

    public boolean canCalucateScore() {
        return left == 0;
    }
}
