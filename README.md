# Zadanie 1 - Wstęp

:white_check_mark: 3.0 Zaimplementuj funkcję isSorted, która sprawdza czy dana funkcja jest posortowana zgodnie z podaną funkcją porównawczą [Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/5c6f9839a9f93fad7dc3faea70bae5ab31c8f408)

https://github.com/user-attachments/assets/a97547d8-0146-45be-906a-7b5504a47d0f

:white_check_mark: 3.5 Zaimplementuj funkcję, która zsumuje liczby po wierszach z trzech list na wejściu; wykorzystaj funkcję sprowadzi funkcję z trzema argumentami, do funkcji z dwoma [Link do commita2 ](https://github.com/GrubySamuraj/funkcyjne/commit/914cd942d8c5524b94edec316fe570f45f5042f2)

https://github.com/user-attachments/assets/82e4dda6-9ed6-4a02-8c27-0f73a94f603e

:white_check_mark: 4.0 Zaimplementuj funkcję setHead, która doda element na początku listy [Link do commita 3](https://github.com/GrubySamuraj/funkcyjne/commit/5de036778a533dd0ed4177870bcc2b7ad6d23251)

https://github.com/user-attachments/assets/fc6055f9-2d82-4dcc-9f1e-007df80a253f

:white_check_mark: 4.5 Zaimplementuj funkcję append, która doda element we wskazanym miejscu w liście [Link do commita 4](https://github.com/GrubySamuraj/funkcyjne/commit/5de036778a533dd0ed4177870bcc2b7ad6d23251)

https://github.com/user-attachments/assets/3b534671-02be-4fdf-bdbc-b72ad007dd28

:white_check_mark: 5.0 Zaimplementuj funkcję, która policzy kwadrat liczb z dwóch list (po wierszach) za pomocą funkcji map oraz funkcji anonimowej.
[Link do commita 5](https://github.com/GrubySamuraj/funkcyjne/commit/9702615fb22a9aea4851a21547d5dfd2d3e1eaae)

https://github.com/user-attachments/assets/346d678a-c807-456e-a8b5-6630d2ee84fb

Kod: [Link do zadania 1](https://github.com/GrubySamuraj/funkcyjne/tree/master/zad1)

# Zadanie 2 Docker

:white_check_mark: Stwórz obraz dockerowy, który bazuje na najnowszej wersji Ubuntu LTS oraz który zawiera paczki:

- Java 8
- Python 3
- Scala (dowolna wersja)
- sbt
- vim

Kod: [Link do zadania 2](https://github.com/GrubySamuraj/funkcyjne/tree/master/zad2)

https://github.com/user-attachments/assets/f02f8b89-b778-42fe-aa45-c6e64a94e653

Kod: [Link do docker hub](https://hub.docker.com/layers/grubysamuraj/zad2-funkcyjne/latest/images/sha256-4c66e7c1a84afbcee03d282b428d61616b18c286f743e3d9efb9396d2af06d4f)

# Zadanie 3 Struktury danych

:white_check_mark: 3.0 zwrócą wynik funkcji tail, która usuwa pierwszy element z listy
(parameter); należy rozważyć przypadek Nil jako parametr [Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/489c19c0f83c3aadd08a06490ac76e35265f29ab)

:white_check_mark: 3.5 zwróci wynik funkcji drop, która usuwa n elementów z listy
dwukierunkowej [Link do commita2 ](https://github.com/GrubySamuraj/funkcyjne/commit/489c19c0f83c3aadd08a06490ac76e35265f29ab)

:x: 4.0 zwróci wynik funkcji dropWhile, która usuwa n elementów z listy
dwukierunkowej, które spełniają warunek funkcji (parametr); należy
wykorzystać podejście pattern match

:x: 4.5 zwróci wynik funkcji foldLeft wykorzystując do tego companion
object

:x: 5.0 zwróci wynik funkcji concatenate na dwóch listach (parametry),
która zwraca jedną listę
[Link do commita 5]

https://github.com/user-attachments/assets/1327ff3c-547a-486c-a7fd-ec3d930aa1b9

Kod: [Link do zadania 3](https://github.com/GrubySamuraj/funkcyjne/tree/master/zad1)

# Zadanie 4 Typ optional

:white_check_mark: 3.0 zwróci taki sam wynik jak zad.1 4.5 ale wykorzysta typ opcjonalny
[Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/a548a198563fcf596f492aceb3424141f36e789b)

:white_check_mark: 3.5 zwroci wariancję z listy; do implementacji wykorzystać należy typ
opcjonalny [Link do commita 2](https://github.com/GrubySamuraj/funkcyjne/commit/e6f9ff0797674fea345b8a85489fb0c72f499884)

:white_check_mark: 4.0 zwróci listę (option), która jest wynikiem połączenia dwóch list
(option); w przypadku gdy jedna z list jest None, funkcja powinna
zwrócić None [Link do commita 3](https://github.com/GrubySamuraj/funkcyjne/commit/fe45f2f9c98adbef61bed651991ad2686e257192)

:white_check_mark: 4.5 zwróci listę za pomocą metody mojeMap[A,B,C](a: Option[A], b:
Option[B])(f:(A,B)=>C):Option[C]; należy wykorzystać metodę flatMap
oraz map [Link do commita 4](https://github.com/GrubySamuraj/funkcyjne/commit/3e801d7ffbc5d1d7ba889ba660d2c9e9104cbc1f)

:white_check_mark: 5.0 zwróci taki średnią (mean) z listy zwracając Either
[Link do commita 5](https://github.com/GrubySamuraj/funkcyjne/commit/954999a62b4afbcc321dc4faebafc120d151f6e7)

https://github.com/user-attachments/assets/2ad41dbc-6924-494d-8a47-0c7ecf4db1d9

Kod: [Link do zadania 4](https://github.com/GrubySamuraj/funkcyjne/blob/master/zad1/src/main/scala/zad4/zad4.scala)

# Zadanie 5 MapReduce

:white_check_mark: 3.0 zwróci słownik z liczbą powtarzających się liczb za pomocą funkcji
mapreduce dla list z liczbami
[Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/7152e2b3dc776ec8dea938f0bbe657af51a116d3)

:white_check_mark: 3.5 zwróci słownik z liczbami podniesionymi do sześcianu za pomocą
funkcji mapreduce dla list z liczbami
opcjonalny [Link do commita 2](https://github.com/GrubySamuraj/funkcyjne/commit/7152e2b3dc776ec8dea938f0bbe657af51a116d3)

:white_check_mark: 4.0 zwróci słownik (student, godziny nauki), która wykorzysta funkcją
mapreduce oraz groupBy dla słownika na wejściu
zwrócić None [Link do commita 3](https://github.com/GrubySamuraj/funkcyjne/commit/d982601871358d893bf30525763c0a0453c50709)

:x: 4.5 zwróci słownik (zdanie, wektor), która wykorzysta funkcję
mapreduce oraz bagOfWords

:x: 5.0 zwróci słownik (student, średnia ocen), która wykorzysta funkcję
mapreduce oraz join; na wejściu są dwie listy: (numer_indeksu,
student), (numer_indeksu, kurs, ocena)

https://github.com/user-attachments/assets/aca6e8f0-4bb7-41fe-9ed8-200826e571db

Kod: [Link do zadania 5](https://github.com/GrubySamuraj/funkcyjne/blob/master/zad1/src/main/scala/zad5/zad5.scala)

# Zadanie 6 Wstęp do Haskella

:white_check_mark: 3.0 Zaimplementuj funkcję isSorted, która sprawdza czy dana funkcja jest posortowana zgodnie z podaną funkcją porównawczą [Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/8c1a02d860ace107a8cccdb687f6fd89c8a6c5a0)

:white_check_mark: 3.5 Zaimplementuj funkcję, która zsumuje liczby po wierszach z trzech list na wejściu; wykorzystaj funkcję sprowadzi funkcję z trzema argumentami, do funkcji z dwoma [Link do commita2 ](https://github.com/GrubySamuraj/funkcyjne/commit/8c1a02d860ace107a8cccdb687f6fd89c8a6c5a0)

:white_check_mark: 4.0 Zaimplementuj funkcję setHead, która doda element na początku listy [Link do commita 3](https://github.com/GrubySamuraj/funkcyjne/commit/8c1a02d860ace107a8cccdb687f6fd89c8a6c5a0)

:white_check_mark: 4.5 Zaimplementuj funkcję append, która doda element we wskazanym miejscu w liście [Link do commita 4](https://github.com/GrubySamuraj/funkcyjne/commit/f1762259beea471cc1e8154ee394fe6a2a08bd5b)

:white_check_mark: 5.0 Zaimplementuj funkcję, która policzy kwadrat liczb z dwóch list (po wierszach) za pomocą funkcji map oraz funkcji anonimowej.
[Link do commita 5](https://github.com/GrubySamuraj/funkcyjne/commit/b56fdd38c7b167c909cd2eb2218f317ea2139140)

Kod: [Link do zadania 6](https://github.com/GrubySamuraj/funkcyjne/blob/master/zad6/zad6/src/Main.hs)

https://github.com/user-attachments/assets/3e44f57b-75d9-4733-b863-c03d4d4787d8

# Zadanie 7 Maszyna Stanów

:white_check_mark: 3.0 zwróci wartość między 0, a maxvalue of Int włącznie [Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/1ca821ad279e91ec4c50cd01248e5414401aedac)

:white_check_mark: 3.5 zwróci wartość między 0, a 1 (Double) z wyłączeniem 1 [Link do commita 2](https://github.com/GrubySamuraj/funkcyjne/commit/1ca821ad279e91ec4c50cd01248e5414401aedac)

:white_check_mark: 4.0 zwróci pary (Int, Double), (Double, Int) oraz krotki (Double,
Double, Double) wykorzystując funkcje z ocen 3.0 oraz 3.5 [Link do commita 3](https://github.com/GrubySamuraj/funkcyjne/commit/e372831da2a052d809db2a020d6d71137ecd4dd0)

:x: 4.5 zwróci wartość jak w funkcji 3.5, ale wykorzysta map

:x: 5.0 zwróci wartość jak w funkcji 3.5, ale wykorzysta flatMap

Kod: [Link do zadania 7](https://github.com/GrubySamuraj/funkcyjne/tree/master/zad7/zad7)

https://github.com/user-attachments/assets/198d12cc-e44f-47e2-8a39-4e93d830047c

# Zadanie 8 Monoidy Monady i funktory

:white_check_mark: 3.0 wykorzysta metodę map fuktora do wykonania funkcji dodawania lub
odejmowania na dwóch wartość przyjętych na wejściu [Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/2b49b882956f280d72dfe4f8cf784024cad36ff7)

:white_check_mark: 3.5 zwróci wartość konkatenacji trzech list za pomocą monoidy [Link do commita 2](https://github.com/GrubySamuraj/funkcyjne/commit/74c3293b238b0f42f7acabb353cb7db64f89d7db)

:white_check_mark: 4.0 zwróci wartość sumy listy liczb lub zwróci nil; zaimplementuj
wykorzystując monady [Link do commita 3](https://github.com/GrubySamuraj/funkcyjne/commit/eb6f36db7bf91b61dea6364cec5a40da49b6c59a)

:x: 4.5 zwróci zadanie z zestawy 6 na ocenę 4.0 i wykorzysta metodę
combine oraz join

:x: 5.0 zwróci dla listy minimum 3 elementów typu int mapę: liczba
elementów, suma, wartość minimalna, wartość maksymalna; wykorzysta do
tego monadę oraz metodę foldMap

Kod: [Link do zadania 8](https://github.com/GrubySamuraj/funkcyjne/tree/master/zad8/zad8)

https://github.com/user-attachments/assets/e151bc4e-96d9-492a-8445-c93200999cbf

# Zadanie 9 Wątki

:white_check_mark: 3.0 zwróci wartość binarną czy podana na wejściu liczba jest liczbą
pierwszą; wykorzysta Promise [Link do commita 1](https://github.com/GrubySamuraj/funkcyjne/commit/7ac348036c1687e17fb1c10d3ee203bdc371620a)

:white_check_mark: 3.5  zwróci posortowaną listę; wykorzysta Promise [Link do commita 2](https://github.com/GrubySamuraj/funkcyjne/commit/7ac348036c1687e17fb1c10d3ee203bdc371620a)

:white_check_mark: 4.0 zwróci wynik funkcji z zad. 5 na 4.0 (mapreduce); wykorzysta
worker_threads [Link do commita 3](https://github.com/GrubySamuraj/funkcyjne/commit/4557f51c244d2dabcfc8fe0157310c69c6a2c6b7)

:x: 4.5 zwróci wynik bagOfWords dla danego tekstu na wejściu; stworzy
pulę workterów

:x: 5.0 zwróci wynik funkcji z zad. 5 na 4.5; wykorzysta Promise.all oraz
funkcję map

Kod: [Link do zadania 9](https://github.com/GrubySamuraj/funkcyjne/tree/master/zad9/zad9)

https://github.com/user-attachments/assets/bd799d87-aba2-403d-a625-69ed08a8bfad
