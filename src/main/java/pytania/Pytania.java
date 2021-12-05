package pytania;

public class Pytania {

    /*

    Tylko lista pytan odnosnie kodu:
    * 1. Czy Singleton ma sens? Ponoc odchodzi sie od niego we wzorcach projetkowych
    * 2. Czy Enumy w tym przypadku maja sens? Czy moze zastapic je Generics? Czyli Class<T>?
    * 3. Nie jest to aplikacja gdzie uzytkownik cokolwiek robi, czyli Events i Listenery nie maja sensu, prawda?
    * 4. Czy ma sens komplikowanie Produktow i tworzenie Fabryk itp? W moim rozumieniu zadanie ma na celu pokazanie
    * strategi rynkowych (czy oplaca sie sprowadzac wiecej towaru czy mniej i dluzej czekac na realizacje).
    * 5. Czy builder do "Order" ma sens? Czyli czy warto dodawac i budowac zamowienie krok po kroku, czy lepiej od razu?
    * 6. Czy ma sens to, ze mam enumy, ale nie uzywam ich w klasach? Projektujac, zalezalo mi na code reusability.
    * Tzn: Mam te enumy, ale moge zmienic ich strukture, jednak wartosci przekazywane klasom i tak beda np double czy int,
    * takze moge usunac enumy i moge przeslac po prostu inne dane
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
