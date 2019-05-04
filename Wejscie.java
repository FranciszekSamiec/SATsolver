package SATsolver;

import java.util.Arrays;

public class Wejscie {
    private String[] wierszWejscia;
    private int ileAltenratyw;

    public void ustawLiczbeAlt(int x) {
        this.ileAltenratyw = x;
    }

    public void ustawTabWejscie(String[] w) {
        wierszWejscia = Arrays.copyOf(w, w.length);
    }

    public int dajIleALt() {
        return this.ileAltenratyw;
    }

    public String[] dajWierszWejscia() {
        return this.wierszWejscia;
    }

}
