package gelato.marketing;

import gelato.external.Kalender;
import gelato.mailversand.Mail;
import gelato.wetter.Wetter;
import gelato.wetter.WetterDienst;

import java.util.Objects;

import static gelato.marketing.Texte.*;

public final class MarketingCore {

    private final WetterDienst wetterDienst;
    private final Kalender kalender;

    public MarketingCore(WetterDienst wetterDienst, Kalender kalender) {
        this.wetterDienst = Objects.requireNonNull(wetterDienst);
        this.kalender = Objects.requireNonNull(kalender);
    }

    public Mail mailErstellen(String name) {
        Wetter wetter = wetterDienst.wetterDaten();

        // Wetter-Logik
        if (wetter.istHeiss() && wetter.istTrocken()) {
            if (kalender.isFrueh()) {
                return granita(name);
            }
            return gelato(name);
        }
        else if (wetter.istKalt()) {
            return waffelnUndKaffee(name);
        }
        else {
            return tagesempfehlung(name);
        }
    }

    private Mail tagesempfehlung(String name) {
        return switch (kalender.getTag()) {
            case MONDAY, WEDNESDAY -> cassata(name);
            case TUESDAY, THURSDAY -> tiramisu(name);
            case FRIDAY -> pannaCotta(name);
            case SATURDAY, SUNDAY -> zuppaInglese(name);
        };
    }
}
