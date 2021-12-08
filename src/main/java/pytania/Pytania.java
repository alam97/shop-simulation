package pytania;

public class Pytania {

    /*

    Tylko lista pytan odnosnie kodu:
    * 5. Czy builder do "Order" ma sens? Czyli czy warto dodawac i budowac zamowienie krok po kroku, czy lepiej od razu?
    * 7. Czy jest sens budowac symulacje uzywajac wzorca projektowego "builder"?
    * 8. Jak to z tym handle order? Czy dodac jakies proxy?
    * 9. Czy jak dodam policy do handleorder, czy to nie bedzie za duzo?
    *
    * Pytanie o mechanizm, po przeczytaniu tego, jak ma wygladac wybor sklepow:
    * watki maja jedynie sklepy w sobie, tak? Skoro symulacje nalezy wykonywac w osobnym watku dla kazdego sklepu.
    * klientow generujemy przed symulacja?
    * mamy globalny counter ktory odlicza dni do 365? (symulacja 12 miesiecy)
    * if counter == 0 then rownomiernie wysylamy klientow jako parametry?
    * if counter == 31 (no wlasnie, jak ustalic miesiac? :)) then synchronize, then wykonaj losowanie ponownie, then sporzadz raport
    *
    * Pytanie odnosnie parametry funkcji prawdopodobienstwa:
    * "stopnia zadowolenia z poprzednich zakupow dokonywanych przez klienta w okreslonych sklepach" czyli potrzebuje
    * miec powiazanie pomiedzy klientem, a ocena? bo biore pod uwage ocene wydana przez tego konkretnego klienta?
    * I teraz: czy warto wprowadzac nowa klase? czy dodam po prostu nowy field dla ordery "satisfaction" i bede brac
    * srednia z ocen z listy zamowien wykonanych przez tego klienta?
    *
    *

     */
}
