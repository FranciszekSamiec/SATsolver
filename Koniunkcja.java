package SATsolver;

public class Koniunkcja extends Binarna {

    public Koniunkcja(Wyrazenie l, Wyrazenie p) {
        super(l, p);
    }

    public Koniunkcja() {
        super();
    }

    @Override
    protected boolean oblicz(boolean l, boolean p) {
        if (l && p)
            return true;
        else
            return false;

    }
}
