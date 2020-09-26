package bowling.domain.frame;

import bowling.domain.pin.Pin;
import bowling.domain.pin.Pins;
import bowling.domain.score.ScoreConverter;

import java.util.List;
import java.util.Objects;

public class NormalFrame implements Frame {
    private static final int FIRST_FRAME = 1;
    private static final int FINAL_FRAME = 10;

    private Pins pins;
    private int index;

    public NormalFrame(final int index) {
        this.pins = new Pins();
        this.index = index;
    }

    public static NormalFrame firstFrame() {
        return new NormalFrame(FIRST_FRAME);
    }

    @Override
    public void roll(int pin) {
        if (canRoll()) {
            pins.addPins(this, pin);
        }
    }

    @Override
    public boolean canRoll() {
        return pins.isPinReady(this);
    }

    @Override
    public boolean isGameOver() {
        return index != FINAL_FRAME;
    }

    @Override
    public int getTotal() {
        return this.pins.getTotalPins();
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public List<Pin> getPinInfo() {
        return pins.getPins();
    }

    @Override
    public Pins getPins() {
        return pins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NormalFrame)) return false;
        NormalFrame that = (NormalFrame) o;
        return getIndex() == that.getIndex() &&
                Objects.equals(getTotal(), that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotal(), getIndex());
    }

    @Override
    public String getScore() {
        return ScoreConverter.convert(this);
    }

}
