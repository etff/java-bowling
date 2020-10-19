package bowling.domain.score;

public class Score {
    private int score;
    private int leftCount;

    private Score(int score, int leftCount) {
        this.score = score;
        this.leftCount = leftCount;
    }

    public static Score ofMiss(int score) {
        return new Score(score, 0);
    }

    public static Score ofStrike() {
        return new Score(10, 2);
    }

    public static Score ofSpare() {
        return new Score(10, 1);
    }

    public Score calculate(int point) {
        if (leftCount != 0) {
            return new Score(score += point, leftCount - 1);
        }
        return this;
    }

    public int getScore() {
        if (!canCalculate()) {
            throw new IllegalArgumentException("점수를 계산할 수 없습니다.");
        }
        return this.score;
    }

    public boolean canCalculate() {
        return leftCount == 0;
    }

}
