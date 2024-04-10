
import java.util.*;

public class ControladorBook {
    public void Books() {
        Scanner leer = new Scanner(System.in);
        System.out.println("===Books===");
        System.out.println("1) Eliminar libro");
        System.out.println("2) Crear libro");
        System.out.println("3) Actualizar libro");
        System.out.println("4) Mostrar todos los libros");
        System.out.println("5) Mostrar libros prestados");
        System.out.println("6) Mostrar libros disponibles para prestamo");
        System.out.print("Seleccionar opcion: ");
        int opcion = leer.nextInt();
        switch (opcion) {

            case 1:
                leer.nextLine();
                System.out.println("Isbn: ");
                String isbn1 = leer.nextLine();
                for (int i = 0; i < RepositoryBook.books.size(); i++) {
                    if (RepositoryBook.books.get(i).isAvailable) {
                        if (RepositoryBook.books.get(i).isbn.equals(isbn1)) {
                            RepositoryBook.books.remove(i);
                        }
                    }
                }

                break;

            case 2:
                leer.nextLine();
                System.out.print("Isbn: ");
                String isbn = leer.nextLine();
                System.out.print("title: ");
                String title = leer.nextLine();
                System.out.print("Day: ");
                int D= leer.nextInt();
                System.out.print("Month: ");
                int M= leer.nextInt();
                System.out.print("Year: ");
                int Y= leer.nextInt();
                Date publish=new Date(D,M,Y);
                leer.nextLine();
                System.out.print("Name author: ");
                String s = leer.nextLine();
                System.out.print("Lastname author: ");
                String z = leer.nextLine();

                for (Author pes : RepositoryProfile.cl) {
                    if (pes.getProfile().name.equals(s) && pes.getProfile().lastName.equals(z)) {
                        Book book1 = new Book(isbn, title, publish, pes, true);
                        RepositoryBook.books.add(book1);
                        //   Author.Author.add(book1);
                        pes.setAuthor(book1);
                    }
                }
                break;
            case 3:
                leer.nextLine();
                System.out.print("Dame el Isbn:");
                String nisbn = leer.nextLine();
                for (Book see : RepositoryBook.books) {
                    if (see.isbn.equals(nisbn)) {
                        System.out.println("===Book Reboot===");
                        System.out.print("Isbn: ");
                        String isbns = leer.nextLine();
                        System.out.println("Title: ");
                        String titles = leer.nextLine();
                        System.out.print("Day: ");
                        int D1= leer.nextInt();
                        System.out.print("Month: ");
                        int M2= leer.nextInt();
                        System.out.print("Year: ");
                        int Y3= leer.nextInt();

                        Date birth=new Date(D1,M2,Y3);

                        System.out.println("Author: ");
                        String name = leer.nextLine();
                        see.isbn = isbns;
                        see.title = titles;
                     see.publishDate=birth;
                        see.author.profile.name=name;
                        return;
                    } else {
                        System.out.println("Vuelva hacerlo");
                    }
                }
                break;
            case 4:
                for (Book boors : RepositoryBook.books) {
                    int d=boors.getPublishDate().day;
                    int m=boors.getPublishDate().month;
                            int y=boors.getPublishDate().year;
                            String publish1= d+"/"+m+"/"+y;
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                            boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                    System.out.println("-------------------------------------------------------------------------------------------");
                }

                break;
            case 5:


                for (Book boors : RepositoryBook.books) {
                    if (!boors.isAvailable) {
                        int d=boors.getPublishDate().day;
                        int m=boors.getPublishDate().month;
                        int y=boors.getPublishDate().year;
                        String publish1= d+"/"+m+"/"+y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                break;

            case 6:

                for (Book boors : RepositoryBook.books) {
                    if (boors.isAvailable) {
                        int d=boors.getPublishDate().day;
                        int m=boors.getPublishDate().month;
                        int y=boors.getPublishDate().year;
                        String publish1= d+"/"+m+"/"+y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                break;


        }
    }
}
