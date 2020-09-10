package bowling.domain.frame;

import bowling.domain.pin.Pins;

public class FinalFrame implements Frame {
    private static final int PINS_LIMIT = 10;
    private static final int CAN_ROLL_LIMIT = 2;
    private static final String ROLL_COUNT_ERRORS = "일반 게임에서는 두번만 던질 수 있습니다.";

    private Pins pins;
    private int index;

    public FinalFrame() {
        this.pins = new Pins();
        this.index = 10;
    }

    @Override
    public void roll(int pin) {

        if (isPinOverflowRolledOnce(pin)) {
            throw new IllegalArgumentException(ROLL_COUNT_ERRORS);
        }

        if (canRoll()) {
            pins.addPins(pin);
        }
    }

    private boolean isPinOverflowRolledOnce(int pin) {
        return isRolledOnce() && (isPinUnderTen()) && pins.getTotalPins() + pin > 10;
    }

    @Override
    public boolean canRoll () {

        if (isRolledTwice() && pins.getTotalPins() < PINS_LIMIT) {
            return false;
        }

        if (pins.rollCount() < 3) {
            return true;
        }
        return false;
    }

    @Override
    public int getPins() {
        return this.pins.getTotalPins();
    }

    @Override
    public int getIndex() {
        return index;
    }

    private boolean isPinUnderTen() {
        return pins.getTotalPins() < PINS_LIMIT;
    }

    private boolean isRolledTwice() {
        return pins.rollCount() == CAN_ROLL_LIMIT;
    }

    private boolean isRolledOnce() {
        return pins.rollCount() < CAN_ROLL_LIMIT;
    }
}
