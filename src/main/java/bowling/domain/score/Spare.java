package bowling.domain.score;

import bowling.domain.point.Point;

public class Spare implements Score2 {
    private final Point point;

    public Spare(Point point) {
        this.point = point;
    }

    @Override
    public Score2 nextScore(Point point) {
        if (point.getPoint() == STRIKE) {
            return new Strike();
        }
        if (point.getPoint() == GUTTER) {
            return new Gutter();
        }
        return new Normal(point);
    }

    @Override
    public String getScore() {
        return "/";
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return true;
    }

    @Override
    public int getPoint() {
        return point.getPoint();
    }
}
