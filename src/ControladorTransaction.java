import java.util.*;

public class ControladorTransaction {

    public void trans() {
        Scanner leer = new Scanner(System.in);

        System.out.println("1) Borrow ");
        System.out.println("2) Return ");
        System.out.println("3) Mostrar transacciones");
        System.out.println("4) Filtrar por cliente");
        System.out.println("5) Filtrar por fecha");
        System.out.println("6) Filtrar por libro ");
        System.out.println("Elige una opcion: ");
        int elige = leer.nextInt();
        switch (elige) {
            case 1:
                UUID uuid = UUID.randomUUID();
                String id = uuid.toString();

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
                System.out.println("Id:" + id);
                leer.nextLine();
                System.out.println("Type: Borrow ");

                System.out.print("Nombre del cliente: ");
                String nc = leer.nextLine();
                System.out.print("Apellido del cliente: ");
                String ac = leer.nextLine();
                System.out.print("Isbn: ");
                String ib = leer.nextLine();
                System.out.print("Day: ");
                int D= leer.nextInt();
                System.out.print("Month: ");
                int M= leer.nextInt();
                System.out.print("Year: ");
                int Y= leer.nextInt();
                Date publish=new Date(D,M,Y);
publish.setDate();
                for (Client res : RepositoryProfile.cr) {
                    if (res.getProfile().name.equals(nc) && res.getProfile().lastName.equals(ac) && res.getBorrowedBoooks().size() < 3) {
                        for (Book burs : RepositoryBook.books) {
                            if (burs.isbn.equals(ib)) {

                                Transaction tans1 = new Transaction(id, "Borrow", res, burs,publish);
                                RepositoryTransaction.tras.add(tans1);
                                burs.setAvailable(false);
                                //   Client.borrowedBoooks.add(burs);
                                res.setBorrowedBoooks(burs);
                            }
                        }
                    }

                }
                break;
            case 2:
                UUID uuid1 = UUID.randomUUID();
                String id2 = uuid1.toString();

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


                System.out.println("Id:" + id2);
                leer.nextLine();
                System.out.println("Type: Return");

                System.out.print("Nombre del cliente: ");
                String nc2 = leer.nextLine();
                System.out.print("Apellido del cliente: ");
                String ac3 = leer.nextLine();
                System.out.print("Isbn: ");
                String ib1 = leer.nextLine();
                System.out.print("Day: ");
                int D2= leer.nextInt();
                System.out.print("Month: ");
                int M2= leer.nextInt();
                System.out.print("Year: ");
                int Y2= leer.nextInt();
                Date publish2=new Date(D2,M2,Y2);

                for (Client cirs : RepositoryProfile.cr) {
                    if (cirs.getProfile().name.equals(nc2) && cirs.getProfile().lastName.equals(ac3)) {
                        for (Book ches : cirs.getBorrowedBoooks()) {
                            if (ches.isbn.equals(ib1)) {
                                Transaction pin = new Transaction(id2, "Return", cirs, ches,publish2);
                                RepositoryTransaction.tras2.add(pin);
                            }

                        }
                    }
                }
                for (int i = 0; i < RepositoryProfile.cr.size(); i++) {
                    if (RepositoryProfile.cr.get(i).getProfile().name.equals(nc2) && RepositoryProfile.cr.get(i).getProfile().lastName.equals(ac3)) {
                        for (int g = 0; g < RepositoryProfile.cr.get(i).borrowedBoooks.size(); g++) {
                            if (RepositoryProfile.cr.get(i).getBorrowedBoooks().get(g).isbn.equals(ib1)) {
                                RepositoryProfile.cr.get(i).getBorrowedBoooks().remove(g);
                                for (Book chest : RepositoryBook.books) {
                                    if (chest.isbn.equals(ib1)) {
                                        chest.setAvailable(true);
                                    }

                                }
                            }
                        }
                    }
                }

                break;

            case 3:
                for (Transaction tex : RepositoryTransaction.tras) {
                    tex.date.getDateh();
                    System.out.println("-----------------------------------------------------------------------------------------------");
                    System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                            tex.id, tex.type, tex.client.getProfile().name, tex.book.title,tex.date.getDateh());
                    System.out.println("");
                    System.out.println("-----------------------------------------------------------------------------------------------");
                }
                    for (Transaction tex2 : RepositoryTransaction.tras2) {
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                                tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                    }

                break;
            case 4:

                leer.nextLine();
                System.out.print("Dame el nombre:");
                String nombre= leer.nextLine();
                for (Transaction tex : RepositoryTransaction.tras) {
                    if (tex.getClient().profile.name.equals(nombre)) {
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                                tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                    }}
                    for (Transaction tex2 : RepositoryTransaction.tras2) {
                        if(tex2.getClient().profile.name.equals(nombre)){

                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                                tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                     }}

                break;
            case 5:

                leer.nextLine();
                System.out.print("Dame el dia:");
                int dia= leer.nextInt();
                System.out.print("Dame el mes:");
                int mes= leer.nextInt();
                System.out.print("Dame el año:");
                int año= leer.nextInt();
                Date ne=new Date(dia,mes,año);
                for (Transaction tex : RepositoryTransaction.tras) {
                    if (tex.getDate().day == dia && tex.getDate().month==mes&&tex.getDate().year==año) {

                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                                tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------------------------");}}
                        for (Transaction tex2 : RepositoryTransaction.tras2) {
                            if (tex2.getDate().equals(ne)) {

                                System.out.println("-----------------------------------------------------------------------------------------------");
                                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                                        tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                                System.out.println("");
                                System.out.println("-----------------------------------------------------------------------------------------------");
                            }
                        }



                break;
            case 6:
                leer.nextLine();
                System.out.println("Dame el isbn:");
                String isbn= leer.nextLine();
                for (Transaction tex : RepositoryTransaction.tras) {
                    if (tex.getBook().isbn.equals(isbn)) {

                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                                tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                    }}
                        for (Transaction tex2 : RepositoryTransaction.tras2) {
                            if(tex2.getBook().isbn.equals(isbn)){

                                System.out.println("-----------------------------------------------------------------------------------------------");
                                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| Date: %s| ",
                                        tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title,tex2.date.getDateh());
                                System.out.println("");
                                System.out.println("-----------------------------------------------------------------------------------------------");
                            }
                }
                break;
        }
    }
}

