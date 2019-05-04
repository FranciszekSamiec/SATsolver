package SATsolver;

public class Alternatywa extends Binarna {
    public Alternatywa(Wyrazenie l, Wyrazenie p) {
        super(l, p);
    }

    public Alternatywa() {
        super();
    }

    @Override
    protected boolean oblicz(boolean l, boolean p) {
        if (l || p)
            return true;
        else
            return false;

    }
}
