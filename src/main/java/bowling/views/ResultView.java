package bowling.views;

import bowling.domain.*;
import bowling.domain.frame.Frame;
import bowling.domain.frame.Frames;
import bowling.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private final static String STRIKE = "X";
    private final static String SPARE = "/";
    private final static String GUTTER = "-";
    private final static String SEPARATOR = "|";
    private final static int GUTTER_PIN_COUNT = 0;

    private final static int FIRST_ROUND = 0;
    private final static int FINAL_ROUND = 10;
    private final static int FIRST_STATE = 1;
    private final static int FINAL_STATE = 3;

    private final static int FIRST_INDEX = 0;
    private final static int FRAME_WIDTH = 6;
    private final static int FRAME_WIDTH_HALF = 2;

    private final static String SCORE_TITLE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";
    private final static String BLANK = "    ";
    private final static String ENTER = System.lineSeparator();

    private ResultView() {}

    private static String getStateOrName(String result) {
        int rightPadding = (FRAME_WIDTH - result.length()) / FRAME_WIDTH_HALF;
        int leftPadding = FRAME_WIDTH - result.length() - rightPadding;
        return SEPARATOR +
                StringUtils.generateBlank(leftPadding) +
                result +
                StringUtils.generateBlank(rightPadding);
    }

    private static String getBlankFrameStates() {
        StringBuilder result = new StringBuilder();
        for (int i = ResultView.FIRST_ROUND; i < FINAL_ROUND; i++) {
            result.append(getStateOrName(BLANK));
        }
        return result.toString();
    }

    public static String frameResult(Player player, Frames frames) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getStateOrName(player.name()));
        for (Frame frame: frames.frames()) {
            stringBuilder.append(getStateOrName(frame.getFrameResult()));
        }
        return stringBuilder + SEPARATOR + ENTER;
    }

    public static void showScoreBoard(Player player, Frames frames) {
        System.out.println(SCORE_TITLE +
                ENTER +
                frameResult(player, frames));
    }

    public static void showScoreBoard(Player player) {
        String stringBuilder = SCORE_TITLE +
                ENTER +
                getStateOrName(player.name()) +
                getBlankFrameStates() +
                SEPARATOR +
                ENTER;
        System.out.println(stringBuilder);
    }

}
