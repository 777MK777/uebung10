package gelato.wetter;

public record Wetter(int temperatur, int regenwahrscheinlichkeit) {

    public Wetter(String daten) {
        this(Integer.parseInt(daten.split(" ")[0]),
                Integer.parseInt(daten.split(" ")[1]));
    }

    public boolean istHeiss() {
        return temperatur >= 29;
    }

    public boolean istKalt() {
        return temperatur < 15;
    }

    public boolean istTrocken() {
        return regenwahrscheinlichkeit < 30;
    }

    public boolean istNass() {
        return regenwahrscheinlichkeit > 80;
    }

}
