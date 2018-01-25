# DoctorSupporter+
## Aplikacja mobilna dla lekarzy

**Table of Contents**

- [Intro](#intro)
- [Baza danych](#baza-danych)
- [Api](#api)
- [Guest Log In](#guest-log-in)
- [Pogląd aplikacji](#pogląd-aplikacji)
- [Przykład kodu](#przykład-kodu)
- [Założenia i funkcjonalności](#założenia-i-funkcjonalności)
- [Poszczególne funkcjonalności](#poszczególne-funkcjonalności)
- [Funkcjonalności pacjent](#funkcjonalności-pacjent)
- [Korzyści](#korzyści)
- [Podsumowanie](#podsumowanie)

## Intro
Aplikacja mobilna na platformę Android, **mająca wspierać codzienną pracę lekarzy poprzez wyeliminowanie bariery fizycznej dostępu do danych pacjentów** tj. informacji o przebytych chorobach, nadwrażliwościach, alergiach, podanych lekach czy przeprowadzonych badaniach poprzez umożliwienie dostępu do tychże za pośrednictwem tabletu w który ma zostać wyposażony lekarz podczas swojej pracy. Funkcjonalnościami dotyczącymi bezpośrednio lekarza są: dostęp do kalendarza, notatnika, powiadomień czy czasu pracy. 
Docelowym urządzeniem na którym będzie działać aplikacja jest tablet.

## Baza danych

Baza danych napisana w języku MySQL znajduje się na **oddzielnym serwerze.**

## Api

Api napisane w JavaScripcie znajduje się na serwerach **Heroku** jego kod nie został udostepniony w ramach tego repozytorium.

## Guest Log In

```
login: nowakpiotr
hasło: 1234
```

### Pogląd aplikacji
Pierwszym widokiem ukazującym się po uruchomieniu aplikacji będzie okno logowania, które wymagało będzie numeru identyfikacyjnego lekarza, oraz hasła. Bez prawidłowego wprowadzenia tych danych, korzystanie z dalszych funkcjonalności aplikacji jest niemożliwe. Kolejno ukazuje się panel lekarza z dostępem do wszystkich funkcjonalności, zawierających ifnformacje o pracowniku, oraz w liście panelu bocznego dostęp do przypisanych danemu pracownikowi pacjentów, wraz z niezbędnymi do prowadzenia praktyki informacjami, posegregowanymi w przesuwalnych zakładkach. Po wylogowaniu się z aplikacji, pojawia się ekran widoczny na rysunku. 

![image](https://user-images.githubusercontent.com/11943355/34871903-7ba9d288-f78f-11e7-8d4b-b432e81877f7.png)

Ekran  przedstawia stan po poprawnym zalogowaniu, aplikacja od razu wyświetla imię użytkownika, w celu potwierdzenia prawidłowego zalogowania użytkownika. Ekran jest prezentowany przez 3 sekundy, następnie pojawia się widok ze wszystkimi funkcjonalnościami 

![image](https://user-images.githubusercontent.com/11943355/34871975-a0b47060-f78f-11e7-8773-98b593873570.png)

Ekran  prezentuje panel dolegliwości i choroby. W panelu tym, widoczne są dolegliwości i choroby pacjenta, które dodawane są przez administratorów systemu w momencie przyjęcia pacjenta do placówki. Mogą one być dodawane również przez użytkowników do tego uprawnionych. Dodatkowym panelem są uwagi, które mogą być dodawane także zarówno przez lekarzy jak i przez pracowników administracyjnych. Mieści się w nich opis dolegliwości pacjenta, uwagi mogą być edytowane zarówno przez uprawnionego użytkownika jak i przez pracowników recepcji w placówce służby zdrowia.

![image](https://user-images.githubusercontent.com/11943355/34871981-a86ecb70-f78f-11e7-9ac7-120ae4f6fb3d.png)

Na każdym z dostępnych paneli, na górnej belce widoczne są podstawowe dane zalogowanego użytkownika, to znaczy imię i nazwisko, miniatura zdjęcia, a także czas pracy oraz czas wykorzystanej dotychczas przerwy. Poniżej widoczne są dane pacjenta niezbędne do identyfikacji, ponieważ zdarza się, że na jednej sali leżą dwie osoby o tym samym imieniu i nazwisku, podany jest również numer PESEL pacjenta, aby w razie wątpliwości, lub w przypadku kiedy pacjent jest nieprzytomny można było poprawnie  zweryfikować jego tożsamość. Pozwoli to w znacznym stopniu ułatwić pracę przy chorych, unikając błędów w podawaniu leków, czy metodyki leczenia. Widoczny jest również numer sali w której leży pacjent, aby w razie wątpliwości pracownik mógł sprawdzić numer sali, a także upewnić się co do tożsamości osoby.

![image](https://user-images.githubusercontent.com/11943355/34871995-b1028e84-f78f-11e7-920d-d0b9aeaf7fcd.png)

Powyższy ekran  aplikacji prezentuje panel różne informacje. W panelu tym dostępne są informacje związane z alergiami i uczuleniami chorego wraz z ich szerokim opisem. Na ekranie widoczna jest również ogólna ocena zdrowia pacjenta, wystawiana przez lekarza. Jest to ocena jedynie ogólna i poglądowa.
Informacja o lekarzu prowadzącym na prezentowanym ekranie, jest odgórnie dodawana przez pracowników administracyjnych. W prezentowanym widoku została również rozwinięta lista pacjentów. Po lewej stronie widoczna jest lista pacjentów przypisanych do danego pracownika służby zdrowia. Na liście prezentowane są podstawowe dane pacjenta, które zostają bardziej szczegółowo przedstawione po wybraniu pacjenta po prawej stronie obok nazwiska pacjenta widoczna jest ikonka powiadomień, która informuje o zmianach od ostatniego wyświetlania przez użytkownika. Numer w ikonie powiadomień informuje o liczbie zaszłych zmian. Zmiany które są odnotowywane przez system powiadomień, to wszystkie te związane ze zdrowiem pacjenta.

![image](https://user-images.githubusercontent.com/11943355/34872022-c4369982-f78f-11e7-9366-df59980267b9.png)



Powyższy rysunek  przedstawia zakładkę galeria w której przykładowo zostały dodane zdjęcia rentgenowskie. Jest to zakładka która skupia wszystkie dane zapisane obrazowo w jednym miejscu, są one dodawane przez pracowników administracyjnych. W perspektywie rozwoju na pewno rozważa się możliwość integracji narzędzi medycznych z programem, tak by bezpośrednio trafiały one na serwer aplikacji, skąd urządzenie z którego korzysta pracownik będzie mogło je pobrać i wyświetlić. Obrazy medyczne mogą nie być tak użytecznym narzędziem gdy są wyświetlane na ekranach tabletów, z powodu możliwego przekłamywania kolorów, nie uwydatniania odpowiednich szczegółów czy nieprawidłowej ostrości. Stąd ma się świadomość, że ten obszar powinien się rozwijać pod kontem prawidłowości wyświetlanych obrazów medycznych ze strony aplikacji. Podczas zamawiania urządzeń, należałoby rozważyć takie aspekty jak jasność ekranu, rozdzielczość ekranu czy odzwierciedlenie kolorów. Zakładka ta może okazać się ogromnie przydatna, w czasie kiedy pracownik może praktycznie od razu otrzymać obraz medyczny którego pojawienie się na serwerze zostanie zasygnalizowane przez powiadomienia, czy w każdej chwili zerknąć na obraz, przeanalizować go jeszcze raz, co może być przydatne w stawianiu diagnozy, czy przebiegu leczenia.


![image](https://user-images.githubusercontent.com/11943355/35411165-08dd1c68-0218-11e8-8a87-dbdd21639947.png)

### Api
```javascript
router.post('/getChoroby',function(req,res,next){
  var idPacjent = req.body.idPacjent;
  Doctors.getChoroby(idPacjent,function(err,rows){
                if(err){
            res.json(err);
        }
        else {
            res.json(rows);
        }
  })
});
```

```javascript

        getChoroby:function(idPacjent,callback){
            return db.query("Select * from Choroby where Pacjent_idPacjent = ?",[idPacjent],callback);
        },
```


## Założenia i funkcjonalności

#Założenia i przykładowe funkcjonalności Aplikacji mobilnej DoctorSupporter

**Podczas projektowania aplikacji starano się przeanalizować cały kontekst pracy w środowisku pod kątem jego silnych i słabych stron, a także szans i zagrożeń jakie stoją w obliczu proponowanego rozwiązania. W kwestii stron słabych aplikacji należy przedstawić jej nowatorskie podejście do zmiany papierowej, tradycyjnej dokumentacji na te nowocześniejsze, elektroniczne.**

Środowisko lekarzy i osób pracujących w placówkach służby zdrowia charakteryzuje się mniejszymi umiejętnościami obsługi urządzeń takich, jak tablet czy komputer, co zostało opisane wcześniej. Próba wprowadzenia przedstawionego rozwiązania w szpitalach może wiązać się z niechęcią do zmian i wciąż promować użytkowanie tradycyjnych wersji kart pacjenta i związanej z nią dokumentacji.

**Proponuje się zatem, aby przedstawiona aplikacja i nierozłącznie związane z nią użytkowanie tabletów na terenie szpitala było wdrażane w symbiozie z wersją tradycyjną, aby nie zmuszać do całkowitego porzucenia nawyków środowiska pracowników, a jedynie prowadzić do stopniowego wypierania starej wersji dokumentacji.** Takie rozwiązanie pozwoli również na uniknięcie problemu kiedy to aplikacja i związany z nią cały system uległby awarii i spowodował paraliż placówki medycznej. Zakładając, że pierwsze wersje systemu mogą być niedoskonałe i ich użytkowanie nie zawsze będzie spełniało oczekiwania jej użytkowników. Proponuje się także, by zaprojektowana aplikacja była możliwie maksymalnie intuicyjna i prosta w obsłudze, tak by każdy pracownik nauczył się jej obsługi możliwie szybko i dostrzegł zalety jakie wynikają z jej użytkowania. 

Sposobność przechodzenia pomiędzy poszczególnymi oknami, i uzyskiwanie dostępu do konkretnych informacji powinno być także możliwie szybkie, bowiem w praktyce medycznej, czas jest niezwykle cenny. Paleta kolorów i wygląd aplikacji w tym wypadku również nabiera większego znaczenia, kolory powinny być stonowane by nie razić użytkowników, a przyciski i sam wygląd miły dla oka, celem szybszego wdrażania a tym samym usprawniania pracy służby medycznej.

**Kolejnym aspektem który należało rozważyć podczas pracy nad projektem był wzrost obecności danych wrażliwych na nośnikach.** Istnienie kilkudziesięciu, czy nawet kilkuset urządzeń w przypadku dużej jednostki, generuje prawdopodobieństwo dostępu osób niepowołanych do urządzenia, na przykład w razie zgubienia urządzenia czy kradzieży, co jest oczywistym naruszeniem prawa.  Zakłada się zatem, aby przedstawiona aplikacja nie gromadziła danych o pacjentach w pamięci urządzenia, a wyłącznie pobierała je i wysyłała do serwerów szpitala, które zgodnie z zasadami bezpieczeństwa danych osobowych powinny być starannie zabezpieczone przed dostępem osób postronnych. Natomiast proces wysyłania danych z i do serwera powinien podlegać szyfrowaniu tych danych. **Korzystanie, a nawet zalogowanie się nie będzie zatem możliwe bez dostępu do sieci Internet.** 

Każde logowanie natomiast winno być odnotowywane, a urządzenia skrupulatnie ewidencjonowane. Rozwiązaniem powyższego problemu jest także możliwość instalowania kart SIM w tabletach, celem możliwości analizowania lokalizacji urządzenia, także w przypadku kiedy byłoby ono na zewnątrz placówki. Pozwoliłoby to na odnalezienie sprzętu w przypadku jego zgubienia oraz zablokowanie urządzenia i poinformowanie odpowiednich służb w przypadku jego kradzieży. 
Istotne jest także by aplikacja była na bieżąco akutalizowana pod kątem bezpieczeństwa i funkcjonalności. Urządzenie nie powinno akceptować innych sieci niż sieć komputerowa szpitala, wymaga się także, aby wyjścia urządzenia były wyłączone z funkcji transmisji danych.

W perspektywie dalszego rozwoju proponowanego programu w związku z jego bezpieczeństwem powinno się rozważyć zastosowanie programu DocSupporter+ jako hermetycznej platformy, na tablecie. Pozwoliłoby to ograniczyć ilość niezbędnych prac związanych z konserwacją w kwestii bezpieczeństwa, chroniąc urządzenie przed licznymi zagrożeniami tworzonymi bezpośrednio na platformę Android. 
Zagrożenie funkcjonowania może stanowić także sieci komputerowach w szpitalach, problem ten jednak wydaje się marginalny, ponieważ w dobie informatyzacji coraz więcej publicznych ośrodków w tym również szpitali ma dostęp do szerokopasmowego łącza. 

### Poszczególne funkcjonalności

* **Powiadomienia** 	o terminach wizyt, zabiegów, nagłych zdarzeniach, wezwaniach
* **Czas pracy**	informuje o dotychczasowym czasie pracy pracownika 
* **Czas przerwy**	w tym powiadomienie o powinności odbycia przerwy
* **Kalendarz	widok na kalendarz** Propozycja Bartka kalendarz z Androida
* **Grafik** 	obecny w kalendarzu, grafik pracy
* **Notatnik**	zawiera podstawowe funkcje notatnika
* **Wysłanie żądania do drukowania dokumentów** 	żądanie wysyłane do drukarek będących w sieci komputerowej szpitala
* **Wiadomości** 	komunikacja między użytkownikami aplikacji
* **Zmiana preferencji użytkownika**	zmiana kolorystyki wyglądu, dopasowania szybkich przycisków na belce górnej aplikacji
* **Miniatura zdjęcia**	pozwala upewnić się kto jest zalogowany
* **Przycisk odbierania powiadomień**	 przycisk interaktywny który zmienia swój wygląd w momencie kiedy użytkownik ma nowe powiadomienia

## Funkcjonalności pacjent

* **Imię i nazwisko**
* **Adres zamieszkania**	
* **Adres korespondencyjny**	
* **PESEL**	
* **Wiek**	
* **Oddział NFZ**	 
* **Dane osoby do kontaktu:**	imię, nazwisko, numer telefonu, email
* **Bilans zdrowotny**	zbiór badań pacjenta, zawierający takie informacje jak wzrost, waga, masa mięśni, ilość tkanki tłuszczowej w organizmie
* **Badania	wykonane,** zaplanowane lub anulowane badania, z możliwością zlecenia do ich zaplanowania
* **Historia pacjenta** 	historia wizyt, leczenie, przebyte choroby
* **Dolegliwości i choroby,**	w tym zalecane leczenie i przypisywanie leków – propozycja Dominika, rozróżnienie na chorby na które pacjent choruje cały czas (np. cukrzyca) i tych z którymi przyszedł do szpitala
* **Wywiad żywieniowy** 	zalecane produkty z uwzględnieniem nadwrażliwości na nie, uwagi
* **Recepty**	wypisane recepty, wraz z opcją dodawania nowych
* **Galeria**	dostęp do zbioru zdjęć związanych z obrazowaniem medycznym (zdjęcia rentgenowskie, tomografia komputerowa itd.)
* **Załączniki**	dodane dokumenty np. ze specjalistycznej aparatury medycznej
* **Leki**	dostęp do bazy leków oraz ich cen
* **Ocena zdrowia pacjenta**	ocena ogólna zdrowia, wraz z informacją o nadwrażliwościach i alergiach

##  Korzyści
###  z użytkowania aplikacji mobilnej wspomagającej pracę lekarzy
Zaprojektowana aplikacja ma za zadanie wspomaganie funkcjonowania pracowników placówek służby zdrowia, w ich środowisku pracy. **Aplikacja kierowana jest do szerokiego spektrum pracowników medycznych tj. lekarzy, pielęgniarek fizjoterapeutów czy opiekunów medycznych. Poprzez umożliwienie dostępu do danych związanych ze stanem zdrowia swoich pacjentów w czasie rzeczywistym, a także śledzeniem przebiegu leczenia, zostanie wyeliminowana bariera związana z koniecznością fizycznego udania się do pacjenta, czy jednego konkretnego miejsca w którym lekarzowi dane odnośnie zdrowia pacjenta zostaną przedłożone.** Niezaprzeczalnie realny kontakt lekarza z pacjentem zdecydowanie trafniej pozwoli zweryfikować jego stan zdrowia i podjąć ewentualną diagnozę, nie zawsze jednak lekarz ma sposobność bycia bezpośrednio przy łóżku pacjenta, czy to ze względu na inne obowiązki, czy fizyczną obecność w miejscu, z dala od pacjenta. 

Wygoda jaką oferuje aplikacja pozwala zasięgnąć danych w każdym miejscu i czasie, jeśli tylko urządzenie na którym pracuje aplikacja jest w zasięgu sieci. Opcjonalnie pracownicy służby zdrowia mogą sprawdzić aktualne dane o pacjentach będąc poza placówką służby zdrowia np. w domu, bowiem często zmiana stanu zdrowia pacjenta wymaga natychmiastowych działań i pracownik który zajmuje się konkretnym przypadkiem medycznym od początku, będzie w stanie prawdopodobnie najpełniej na podstawie posiadanych danych dokonać prawidłowej diagnozy. Aplikacja również oferuje moduł powiadomień związanych z nagłymi zdarzeniami na oddziale, wezwaniami przez przełożonego itd. zastępując tym samym wciąż funkcjonujące w placówkach pagery.  

W przedstawionym projekcie uwzględniono wpływ na wygodę pracy lekarzy, zaprojektowany został **moduł pozwalający monitorować czas pracy pracowników medycznych, nie pozwalając by przekroczył on zadane wartości, a także informując w sposób nieinwazyjny o konieczności odbycia przerwy w czasie dnia pracy, ograniczając tym samym chroniczne przemęczenie pracowników, co wydaje się kluczowe biorąc pod uwagę fakt, że tym właśnie osobom powierza się zdrowie i życie. **

Zaprojektowany został również kalendarz, do którego pracownicy służby zdrowia mogą dodawać zdefiniowane przez siebie czynności, a korzystanie z grafiku pracy. Uwzględniono też opcję dodawania notatek czy wysłanie żądania drukowania zaznaczonych dokumentów do widocznych w sieci drukarek. Jest także możliwość kontaktowania się z innymi pracownikami szpitala korzystających z przedłożonej aplikacji poprzez wiadomości. Przy użyciu przycisku preferencji istnieje możliwość dostosowania szaty graficznej czy wyglądu okienek, zależnie od upodobań użytkownika.

Kolejnymi korzyściami, oprócz powyższych jest prowadzenie czy wspomaganie leczenia pacjenta przez cały jego czas pobytu w szpitalu, od czasu jego przyjęcia, poprzez rozpoznanie, dolegliwości na wyleczeniu i wypisaniu kończąc. 
Umożliwiają to moduły odpowiedzialne za prowadzenie bilansu zdrowotnego, a więc szczegółowego wywiadu związanego z fizycznymi atrybutami chorego takimi jak waga, masa mięśni, ilość tkanki tłuszczowej itd. 
Do modułu badań, który dostarcza pełne i aktualne informacje o przeprowadzonych badaniach, także z możliwością zaplanowania nowego badania pacjenta i anulowania tego zdarzenia. Moduł związany z historią pacjenta pozwoli prześledzić jego przeszłość w placówce, w której przebywa, a w perspektywie rozwoju aplikacji warto rozważyć opcję pobierania danych historycznych o pacjencie z prowadzonej bazy ogólnopolskiej szpitali. Dolegliwości i choroby to część programu odpowiedzialnego za proces leczenia pacjenta, zawarte są tam, więc zalecenia odnośnie prowadzonej praktyki, a także przypisane leki wraz z dawkowaniem. Wywiad żywieniowy pozwoli dobrać produkty dla pacjenta w taki sposób, aby zminimalizować ryzyko wystąpienia powikłań pooperacyjnych, niepożądanych interakcji pokarmu z lekami czy reakcji alergicznych lub uczuleń.

Możliwość wypisania recepty wraz ze szczegółowymi informacjami, oraz dodaniem do nowych i zleceniem drukowania ich. **Galerii, czyli możliwości podglądu do obrazów wykonanych aparaturą medyczną, wraz z opcją ich powiększenia i wszelkimi dodatkowymi opisami.** Moduł załączniki będzie zawierał wszelkie dokumenty związane z pacjentem nie uwzględnione w przedstawionych modułach.

Mogą to być na przykład dane liczbowe z specjalistycznej aparatury medycznej szpitala, dostarczone przez administrację w celu pełniejszej diagnostyki. Moduł bazy leków prezentuje listę leków wraz jej numerem identyfikacyjnym, substancją czynną, nazwą, postacią i dawką leku, zawartością opakowania i pozostałymi informacjami niezbędnymi do wykorzystania w praktyce. Zakładka różne informacje informuje użytkownika o ogólnych uwagach jakie lekarz czy inny uprawniony do tego pracownik placówki może dodać, obecny jest również suwak informujący o ogólnym zdrowiu pacjenta w skali procentowej, oraz informacja o tym do którego pracownika przypisany jest pacjent.
Zgodnie z zasadą niezaprzeczalności w zakładce raport zmian odnotowywane są wszystkie modyfikacje zachodzące podczas pracy przy dokumentacji medycznej, wraz z jej datą, czasem, a także autorem zmian. Wyświetlana jest komórka w której dokonano zmian, treść którą wprowadzono, a także informacja co znajdowało się w danej komórce, przed dokonaniem tych zmian.

## Podsumowanie
dostęp do danych pacjenta w tak łatwy i prosty sposób pozwala oszczędzić czas i zwiększyć efektywność pracy lekarzy . Jednocześnie podnosząc komfort pracy ich samych poprzez personalne udogodnienia, co powinno mieć też realny wpływ na jakość wykonywanej przez nich pracy, i na ograniczenie wypadków czy błędów medycznych wynikających z praktyki. Żyjąc w XXI wieku nie sposób nie dostrzegać galopujących zmian jakie dokonują się w właściwie każdej dziedzinie życia. Informatyzacja poszczególnych sektorów gospodarki zachodzi dziś w znacznym tempie, a jej progres w przypadku służby zdrowia musi wciąż stymulowany, ze względu na przeciwności jakie stają na jej przeszkodzie. 
