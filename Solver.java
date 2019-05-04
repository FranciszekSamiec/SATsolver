package SATsolver;

import java.util.Arrays;
import java.util.Scanner;

public class Solver {

    private static final int MNOZNIK = 3;
    private static final int DZIELNIK = 2;

    private static int wiecej(int d) {
        return 1 + d * MNOZNIK / DZIELNIK;
    }

    private static String[] dopisz(String[] a, int k, String x) {
        String[] b;
        if (k == a.length) {
            b = Arrays.copyOf(a, wiecej(a.length));
        } else {
            b = a;
        }
        b[k] = x;
        return b;
    }

    public static Wyrazenie budujWyrazenie(Wejscie w) {

        int ileAlternatyw = w.dajIleALt();
        String[] wierszWejscia = w.dajWierszWejscia();

        Wyrazenie[] tabAlternatyw = new Wyrazenie[ileAlternatyw];

        int i = 0;
        int iteratorAlt = 0;
        while (i < wierszWejscia.length && wierszWejscia[i] != null) {
            if (wierszWejscia[i].charAt(0) == '(') {
                i++;
                Literal l = new Literal(Integer.parseInt(wierszWejscia[i]));

                Alternatywa a = new Alternatywa();
                a.ustawLewego(l);
                i++;
                if (wierszWejscia[i].charAt(0) == ')') {
                    a.ustawPrawego(l);
                    tabAlternatyw[iteratorAlt] = a;
                    iteratorAlt++;
                } else {

                    l = new Literal(Integer.parseInt(wierszWejscia[i]));
                    a.ustawPrawego(l);
                    i++;
                    Alternatywa poprzednia = a;
                    while (wierszWejscia[i].charAt(0) != ')') {

                        Alternatywa kolejna = new Alternatywa();
                        kolejna.ustawLewego(poprzednia);
                        l = new Literal(Integer.parseInt(wierszWejscia[i]));
                        kolejna.ustawPrawego(l);
                        poprzednia = kolejna;
                        i++;
                    }

                    tabAlternatyw[iteratorAlt] = poprzednia;
                    iteratorAlt++;
                }
            }

            i++;
        }

        if (tabAlternatyw.length == 1) {

            return tabAlternatyw[0];
        } else {
            Koniunkcja k = new Koniunkcja();
            k.ustawLewego(tabAlternatyw[0]);
            k.ustawPrawego(tabAlternatyw[1]);
            Koniunkcja poprzednia = k;
            for (i = 2; i < tabAlternatyw.length; i++) {
                Koniunkcja nowa = new Koniunkcja();
                nowa.ustawLewego(poprzednia);
                nowa.ustawPrawego(tabAlternatyw[i]);
                poprzednia = nowa;
            }

            return poprzednia;
        }

    }

    public static boolean[] czytaj(Wejscie w) {
        Scanner a = new Scanner(System.in);
        String wierszWejscia = a.nextLine();
        Scanner wejscie = new Scanner(wierszWejscia);

        int i = 0;
        int ileAlternatyw = 0;
        int kandydatNaRozmiar = 0;
        String[] wiersz = new String[1];

        while (wejscie.hasNext()) {
            String x = wejscie.next();
            wiersz = dopisz(wiersz, i, x);
            if (x.charAt(0) == '(')
                ileAlternatyw++;
            if (Character.isDigit(x.charAt(0)) || x.charAt(0) == '-') {
                if (Math.abs(Integer.parseInt(x)) > kandydatNaRozmiar)
                    kandydatNaRozmiar = Math.abs(Integer.parseInt(x));
            }

            i++;

        }

        w.ustawLiczbeAlt(ileAlternatyw);

        w.ustawTabWejscie(wiersz);

        boolean[] tabZmiennych = new boolean[kandydatNaRozmiar];

        a.close();
        wejscie.close();
        return tabZmiennych;
    }

    public static void sprawdzajSpelnialnosc(boolean[] tabZmiennych, Wyrazenie w) {

        boolean pierwszy = true;
        int x = 0;

        while (x <= Math.pow(2, tabZmiennych.length)) {

            for (int i = tabZmiennych.length - 1; i >= 0; i--) {
                tabZmiennych[i] = (x & (1 << i)) != 0;
            }

            if (w.wartosc(tabZmiennych) && pierwszy) {

                pierwszy = false;
                for (int j = 0; j < tabZmiennych.length; j++) {
                    if (tabZmiennych[j])
                        System.out.print((j + 1) + " ");
                }

            }
            x++;
        }

        if (pierwszy)
            System.out.println(0);
    }

    public static void main(String[] args) {

        Wejscie w = new Wejscie();

        boolean[] tablicaZmiennych = czytaj(w);

        Wyrazenie wyr = budujWyrazenie(w);

        sprawdzajSpelnialnosc(tablicaZmiennych, wyr);

    }
}
