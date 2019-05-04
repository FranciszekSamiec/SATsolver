package SATsolver;

public class Literal extends Wyrazenie {
    private final int numerZmiennej;
    private final boolean negacja;

    public Literal(int nr) {
        numerZmiennej = Math.abs(nr);
        if (nr < 0)
            negacja = true;
        else
            negacja = false;
    }

    @Override
    public boolean wartosc(boolean[] wartosciowanie) {
        if (negacja == false)
            return wartosciowanie[numerZmiennej - 1];
        else
            return (wartosciowanie[numerZmiennej - 1] == false);
    }
}
