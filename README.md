# SolarWatch

## Opis projektu

SolarWatch to aplikacja typu Spring Boot Web API, która dostarcza informacje o godzinach wschodu i zachodu słońca dla określonego miasta w wybranym dniu.

## Technologie

- Java 21
- Spring Boot
- Spring Data JPA (+PostgreSQL)
- Spring Security
- Thymeleaf

## Cel projektu

Celem tego projektu było zdobycie wiedzy i umiejętności w zakresie narzędzi Springa oraz stworzenie działającej aplikacji webowej.

## Uruchomienie projektu

1. Sklonuj repozytorium do lokalnego środowiska
2. Skonfiguruj ustawienia bazy danych PostgreSQL zgodnie z informacjami zawartymi w pliku konfiguracyjnym
3. Uruchom projekt w środowisku deweloperskim za pomocą IntelliJ
4. Przejdź do przeglądarki i wpisz adres: `http://localhost:8080` w celu sprawdzenia działania aplikacji

## Stopniowy rozwój aplikacji

Projekt został stworzony z myślą o stopniowym rozwijaniu funkcjonalności, zaczynając od implementacji podstawowych możliwości (MVP).
W pierwszej fazie projektu wykorzystałam dwa zewnętrzne API - jedno dostarczające informacje o godzinach wschodu/zachodu słońca, a drugie zwracające wartości szerokości i długości geograficznej dla określonego miasta.
Kolejnym krokiem  była implementacja rejestracji użytkowników, autentykacji i autoryzacji. W tym celu korzystałam z bazy PostgreSQL zintegrowaną przy użyciu Spring Data JPA.
Cały frontend tworzony jest w technologii Thymeleaf, który komunikuje się z SolarWatch API i prezentuje wyniki w przejrzystym interfejsie użytkownika.

## Główne funkcjonalności

W tej fazie projektu aplikacja umożliwia:

- Pobieranie godzin wschodu i zachodu słońca dla określonego miasta w danym dniu
- Pobieranie szerokości i długości geograficznej dla określonego miasta
- Autentykacja i autoryzacja użytkownika
- Możliwość edycji bazy danych oraz usuwania użytkowników przy pomocy panelu admina

## Przykład użycia - User Story

Jako użytkownik chcę poznać godziny wschodu i zachodu słońca dla miasta, w którym planuję podróżować w najbliższym czasie. Po wprowadzeniu nazwy miasta i daty, chcę zobaczyć precyzyjne godziny wschodu i zachodu słońca dla wybranego dnia.

## Stan projektu

Projekt jest w fazie rozwoju. Aktualnie zaimplementowałam podstawową funkcjonalność API, możliwość rejestracji użytkowników, logowanie oraz panel administratora.

