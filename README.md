# SATsolver
SAT solver działający na formułach CNF
SAT solvery najczęściej działają na formułach w koniunkcyjnej postaci normalnej (CNF). Formuła w CNF jest wieloargumentową koniunkcją klauzul, z których każda jest wieloargumentową alternatywą literałów. Literałem będę tu nazywał zmienną zdaniową lub jej negację.

Ten SAT solver jest zgodny z poniższą specyfikacją.

- Na wejściu programu jest formuła w CNF.

  W formule mogą wystąpić:

  * dodatnia liczba całkowita `x`, reprezentująca zmienną numer `x`,

  * ujemna liczba całkowita `-x`, reprezentująca negację zmiennej `x`,

  * ujęty w nawiasy kwadratowe ciąg formuł, reprezentujący wieloargumentową koniunkcję,

  * ujęty w nawiasy okrągłe ciąg formuł, reprezentujący wieloargumentową alternatywę.

- Jeśli formuła nie jest spełnialna, to wynikiem programu jest wiersz z liczbą `0`.

- Jeśli formuła jest spełnialna, to wynikiem programu jest wiersz z zapisem wartościowania zmiennych spełniającego formułę.

Spośród wszystkich wartościowań spełniających formułę, wybierane jest to, którego zapis zero-jedynkowy występuje w porządku leksykograficznym najwcześniej.

Program pisze wartościowanie jako uporządkowany rosnąco ciąg numerów tych zmiennych, które są prawdziwe.

* Dla danych:

`[ ( 2 ) ( -2 ) ]`
wynikiem programu jest:

`0`
* Dla danych:

`[ ( 3 4 ) ( 1 ) ( 7 -1 -3 ) ( -3 5 -2 ) ( -4 ) ]`
wynikiem programu jest:

`1 3 7`
 

Zakładam poprawność danych wejściowych.

Zakładam, że między kolejnymi elementami danych, czyli nawiasami oraz liczbami, jest co najmniej jedna spacja lub koniec wiersza.

Spełnialność formuły sprawdzam, licząc jej wartość dla kolejnych wartościowań zmiennych.

Wartościowania generuję, traktując ich zapis zero-jedynkowy jak binarną reprezentację nieujemnej liczby całkowitej. Zaczynając od wartościowania z samymi zerami. Kolejne wartościowanie tworzę z poprzedniego, dodając do niego arytmetycznie jedynkę.
