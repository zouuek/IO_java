package org.example;

import java.util.Scanner;

public class App {

    public static User user = null;
    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository = UserRepository.getInstance();
    private final MovieRepository movieRepository = MovieRepository.getInstance();


    public void runAdminMode() {
        System.out.println("Witaj w trybie administatora, wpisz kod dostępu");
        String adminInput = scanner.nextLine();
        Admin admin = Authentication.authenticateAdmin(adminInput);
        if (admin != null) {
            System.out.println("Zwryfikowano pomyślnie!");
            String response;
            boolean running = true;
            while (running){
                System.out.println("Tryb administratora");
                System.out.println("\tWpisz numer czynności: ");
                System.out.println("1 - Dodaj film do bazy");
                System.out.println("2 - Zwróć fizyczny film");
                System.out.println("3 - Usuń film z bazy");
                System.out.println("4 - Wyświetl filmy z bazy");
                System.out.println("5 - Wyświetl użytkowników: ");
                String adminCommand = scanner.nextLine();
                switch (adminCommand) {
                    case "1":
                        System.out.println("wpisz dane filmu oddzielone średnikiem");
                        String filmData = scanner.nextLine();
                        String[] arr = filmData.split(";");
                        if (admin.addMovie(new Movie(arr[0], arr[1], arr[2], Double.parseDouble(arr[3])))) {
                            System.out.println("Dodano film!");
                        } else {
                            System.out.println("Błąd, ten film znajduje się już w bazie");
                        }
                        break;
                    case "2":
                        System.out.println("Wpisz nazwę filmu: ");
                        String physicalMovieToReturn = scanner.nextLine();
                        if (admin.returnPhysicalMovie(physicalMovieToReturn)) {
                            System.out.println("Sukces");
                        } else {
                            System.out.println("Błąd");
                        }
                        break;
                    case "3":
                        System.out.println("Wpisz nazwę filmu który chcesz usunąć: ");
                        String toDelete = scanner.nextLine();
                        if (admin.deleteMovie(toDelete)) {
                            System.out.println("Sukces");
                        } else {
                            System.out.println("Błąd");
                        }
                        break;
                    case "4":
                        System.out.println("Filmy: ");
                        for (Movie m : movieRepository.getMovies()) {
                            System.out.println(m);
                        }
                        break;
                    case "5":
                        System.out.println("Użytkownicy: ");
                        admin.printUsers();
                        break;
                    default:
                        running = false;
                }
            }
        } else {
            System.out.println("Błędnu kod dostępu!");
        }
    }
    public void runUserMode() {
        System.out.println("Tryb użytkownika");
        System.out.println("Wpisz dane logowania:");
        user = Authentication.login(scanner.nextLine(), scanner.nextLine());
        if (user != null) {
            System.out.println("Zalogowano pomyślnie!");
            User loggedUser = userRepository.getUser(user.getLogin());
            String response;
            boolean running = true;
            while (running) {
                System.out.println("\t Wpisz numer czynności:");
                System.out.println("0 - wyświetl twoje filmy");
                System.out.println("1 - wyświetl wszystkie filmy");
                System.out.println("2 - wyświetl ranking filmów");
                System.out.println("3 - wypożycz film");
                System.out.println("4 - zwróć film");
                System.out.println("5 - oceń film");
                response = scanner.nextLine();
                switch (response) {
                    case "0":
                        System.out.println("Twoje dostępne filmy:");
                        loggedUser.displayRentedMovies();
                        break;
                    case "1":
                        System.out.println("Dostępne filmy w wypożyczalni: ");
                        movieRepository.displayMovies();
                        break;
                    case "2":
                        System.out.println("Ranking najlepszych filmów: ");
                        movieRepository.displayBestMovies();
                        break;
                    case "3":
                        System.out.println("Wpisz nazwę filmu jaki chcesz wypożyczyć: ");
                        if (loggedUser.rentMovie(scanner.nextLine())) {
                            System.out.println("Wypożyczono film!");
                        } else {
                            System.out.println("Błąd");
                        }
                        break;
                    case "4":
                        System.out.println("Wpisz nazwę filmu jaki chcesz zwrócić: ");
                        if (loggedUser.returnMovie(scanner.nextLine())) {
                            System.out.println("Zwrócono film!");
                        } else {
                            System.out.println("Błąd");
                        }
                        break;
                    case "5":
                        System.out.println("Wpisz nazwę filmu jaki chcesz ocenić");
                        String movieName = scanner.nextLine();
                        System.out.println("Wpisz ocenę: ");
                        int rating = Integer.parseInt(scanner.nextLine());
                        if(loggedUser.rateMovie(movieName, rating)) {
                            System.out.println("Ocena została wystawiona!");
                        }
                        else System.out.println("Nie znaleziono filmu w wypozyczonych");
                    default:
                        //running = false;
                }
            }
        }else {
            System.out.println("Błędne dane");
        }
        System.exit(0);
    }
    public void run() {
        System.out.println("Witaj w wypożyczalni filmów!\n");
        System.out.println("Jeśli jesteś administatorem wpisz 1, jeśli jesteś użytkownikiem wpisz 2");
        String response = scanner.nextLine();
        if (response.equals("1")) {
            runAdminMode();
        } else if (response.equals("2")) {
            runUserMode();
        } else {
            System.out.println("Błędne dane");
        }
    }

}
