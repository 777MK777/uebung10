package gelato.external;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public final class Kalender {

    private LocalDateTime now() {
        return LocalDateTime.now();
    }

    public boolean isFrueh() {
        return now().getHour() > 6 && now().getHour() < 10;
    }

    public DayOfWeek getTag() {
        return now().getDayOfWeek();
    }
}
