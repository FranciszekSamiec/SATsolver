package SATsolver;

public abstract class Binarna extends Wyrazenie {
    private Wyrazenie lewe;
    private Wyrazenie prawe;

    public Binarna(Wyrazenie l, Wyrazenie p) {
        this.lewe = l;
        this.prawe = p;

    }

    public Binarna() {
        this.lewe = null;
        this.prawe = null;
    }

    public void ustawLewego(Wyrazenie w) {
        this.lewe = w;
    }

    public void ustawPrawego(Wyrazenie w) {
        this.prawe = w;
    }

    protected abstract boolean oblicz(boolean l, boolean p);

    @Override
    public boolean wartosc(boolean[] wartosciowanie) {
        boolean lewaWartosc = this.lewe.wartosc(wartosciowanie);
        boolean prawaWartosc = this.prawe.wartosc(wartosciowanie);

        return oblicz(lewaWartosc, prawaWartosc);

    }
}
