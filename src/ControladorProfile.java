import java.util.*;

public class ControladorProfile {
    public void profiles() {
        Scanner leer = new Scanner(System.in);
        int numero = 0;
        System.out.println("2) Author");
        System.out.println("1) Cliente");
        System.out.println("Escoja una opcion: ");
        numero = leer.nextInt();
        leer.nextLine();

        switch (numero) {
            case 1:
                for (Client clients : RepositoryProfile.cr) {
                    String book = "";
                    for (Book client : clients.getBorrowedBoooks()) {
                        book += client.title + "|";
                    }
                    int day = clients.getProfile().birthdate.day;
                    int mon = clients.getProfile().birthdate.month;
                    int yea = clients.getProfile().birthdate.year;
                    String Birthdate = day + "/" + mon + "/" + yea;
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                            clients.getProfile().name, clients.getProfile().lastName, Birthdate, clients.username, book);
                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------");
                }
                break;
            case 2:
                for (Author autors : RepositoryProfile.cl) {
                    String book2 = "";
                    for (Book autor : autors.getAuthor()) {
                        book2 += autor.title + "|";
                    }
                    int day = autors.getProfile().birthdate.day;
                    int mon = autors.getProfile().birthdate.month;
                    int yea = autors.getProfile().birthdate.year;
                    String Birthdate = day + "/" + mon + "/" + yea;
                    System.out.println("--------------------------------------------");
                    System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s| ",
                            autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
                    System.out.println("");
                    System.out.println("--------------------------------------------");
                }
                break;
            case 3:
                System.out.println("No se puede realizar");
                break;
        }
    }
}
