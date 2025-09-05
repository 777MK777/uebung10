package gelato.external;

public final class Zufall {

    private static final double CORONA_FACTOR = 0.13;

    private double wert() {
        return Math.random();
    }

    public boolean fuerMailAusgewaehlt() {
        return wert() < CORONA_FACTOR;
    }
}
