# Sprawdź kiedy będzie zachód słońca
(for english version please scroll down)
<div style="display: flex; justify-content: space-between;">
    <img src="https://i.ibb.co/zHhjZHP/Zrzut-ekranu-2023-12-22-153716.png" alt="Screen 1" width="200">
    <img src="https://i.ibb.co/Qbp9B4J/Zrzut-ekranu-2023-12-22-153735.png" alt="Screen 2" width="200">
    <img src="https://i.ibb.co/Wy2DM7s/Zrzut-ekranu-2023-12-22-153803.png" alt="Screen 3" width="200">
    <img src="https://i.ibb.co/wzDrbXn/Zrzut-ekranu-2023-12-22-153747.png" alt="Screen 4" width="200">
</div>

### Opis projektu

SolarWatch to aplikacja typu Spring Boot Web API, która dostarcza informacje o godzinach wschodu i zachodu słońca dla określonego miasta w wybranym dniu.

### Technologie

- Java 21
- Spring Boot
- Spring Data JPA (+PostgreSQL)
- Spring Security
- Thymeleaf

### Cel projektu

Celem tego projektu było zdobycie wiedzy i umiejętności w zakresie narzędzi Springa oraz stworzenie działającej aplikacji webowej.

### Uruchomienie projektu

1. Sklonuj repozytorium do lokalnego środowiska
2. Skonfiguruj ustawienia bazy danych PostgreSQL zgodnie z informacjami zawartymi w pliku konfiguracyjnym
3. Uruchom projekt w środowisku deweloperskim za pomocą IntelliJ
4. Przejdź do przeglądarki i wpisz adres: `http://localhost:8080` w celu sprawdzenia działania aplikacji

### Stopniowy rozwój aplikacji

Projekt został stworzony z myślą o stopniowym rozwijaniu funkcjonalności, zaczynając od implementacji podstawowych możliwości (MVP).
W pierwszej fazie projektu wykorzystałam dwa zewnętrzne API - jedno dostarczające informacje o godzinach wschodu/zachodu słońca, a drugie zwracające wartości szerokości i długości geograficznej dla określonego miasta.
Kolejnym krokiem  była implementacja rejestracji użytkowników, autentykacji i autoryzacji. W tym celu korzystałam z bazy PostgreSQL zintegrowaną przy użyciu Spring Data JPA.
Cały frontend tworzony jest w technologii Thymeleaf, który komunikuje się z SolarWatch API i prezentuje wyniki w przejrzystym interfejsie użytkownika.

### Główne funkcjonalności

W tej fazie projektu aplikacja umożliwia:

- Pobieranie godzin wschodu i zachodu słońca dla określonego miasta w danym dniu
- Pobieranie szerokości i długości geograficznej dla określonego miasta
- Autentykacja i autoryzacja użytkownika
- Możliwość edycji bazy danych oraz usuwania użytkowników przy pomocy panelu admina

### Przykład użycia - User Story

Jako użytkownik chcę poznać godziny wschodu i zachodu słońca dla miasta, w którym planuję podróżować w najbliższym czasie. Po wprowadzeniu nazwy miasta i daty, chcę zobaczyć precyzyjne godziny wschodu i zachodu słońca dla wybranego dnia.

### Stan projektu

Projekt jest w fazie rozwoju. Aktualnie zaimplementowałam podstawową funkcjonalność API, możliwość rejestracji użytkowników, logowanie oraz panel administratora.

# English version

### Project Description

SolarWatch is a Spring Boot Web API application that provides information about the sunrise and sunset times for a specified city on a chosen date.

### Technologies

- Java 21
- Spring Boot
- Spring Data JPA (+PostgreSQL)
- Spring Security
- Thymeleaf

### Project Objective

The aim of this project was to gain knowledge and skills in Spring tools and to create a functional web application.

### Running the Project

1. Clone the repository to your local environment.
2. Configure PostgreSQL database settings according to the information in the configuration file.
3. Run the project in the development environment using IntelliJ.
4. Open a web browser and enter: `http://localhost:8080` to check the application.

### Incremental Development

The project was designed for incremental feature development, starting from implementing basic functionalities (MVP). Initially, I utilized two external APIs - one providing sunrise/sunset information, and the other returning geographical latitude and longitude values for a given city. The subsequent step was implementing user registration, authentication, and authorization using a PostgreSQL database integrated with Spring Data JPA. The entire frontend is built using Thymeleaf, which communicates with the SolarWatch API and presents results in a clear user interface.

### Key Features

At this phase of the project, the application allows:

- Retrieving sunrise and sunset times for a specified city on a given day
- Obtaining geographical latitude and longitude for a specified city
- User authentication and authorization
- Admin panel for database editing and user deletion

### Use Case - User Story

As a user, I want to know the sunrise and sunset times for the city I plan to travel to in the near future. After entering the city name and date, I want to see precise sunrise and sunset times for the selected day.

### Project Status

The project is in the development phase. Currently, I have implemented basic API functionality, user registration, login, and an admin panel.
