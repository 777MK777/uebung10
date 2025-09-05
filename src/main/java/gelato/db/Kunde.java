package gelato.db;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Kunde(long id, String name, String email, LocalDate letzteMail) {
    // Kunden werden maximal einmal pro 10 Tage angemailt!
    public boolean darfMailEmpfangen() {
        long tageSeitLetzterMail = ChronoUnit.DAYS.between(letzteMail, LocalDate.now());
        return tageSeitLetzterMail >= 10;
    }
}
