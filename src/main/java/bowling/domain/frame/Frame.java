package bowling.domain.frame;

import bowling.domain.pin.Pin;
import bowling.domain.pin.Pins;

import java.util.List;

public interface Frame {
    void roll(int pin);

    int getTotal();

    boolean canRoll();

    int getIndex();

    List<Pin> getPinInfo();

    Pins getPins();

    String getScore();

    boolean isGameOver();
}
