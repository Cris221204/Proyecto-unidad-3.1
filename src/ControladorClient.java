import java.util.*;
public class ControladorClient {
    public void pc() {

        Scanner leer = new Scanner(System.in);
        System.out.println("1) Crear");
        System.out.println("2) Actualizar");
        System.out.println("3) Eliminar cliente");
        System.out.println("Escoja una opcion: ");
        int numero = leer.nextInt();
        leer.nextLine();

        switch (numero) {
            case 1:
                System.out.print("Name: ");
                String namec = leer.nextLine();
                System.out.print("Last name: ");
                String lastc = leer.nextLine();
                System.out.print("Day: ");
                int D= leer.nextInt();
                System.out.print("Month: ");
                int M= leer.nextInt();
                System.out.print("Year: ");
                int Y= leer.nextInt();
                leer.nextLine();
                System.out.print("Username: ");
                String user = leer.nextLine();
                System.out.println("Password: ");
                String pass = leer.nextLine();
                Date birth=new Date(D,M,Y);
                Profile cliente = new Profile(namec, lastc, birth);
                Client cr=new Client(cliente,user,pass);
                cr.setProfile(cliente);
                RepositoryProfile.cr.add(cr);

                System.out.println("===Cliente creado con exito===");
                break;

            case 2:

                System.out.print("Dame el nombre a modificar:");
                String nombre2 = leer.nextLine();
                System.out.print("Dane el apellido a modificar:");
                String apellido = leer.nextLine();

//Buscamos en el array los datos que ingrese el usuario para buscar el profile
                for (Client cli : RepositoryProfile.cr) {
                    if (cli.getProfile().name.equals(nombre2)&&cli.getProfile().lastName.equals(apellido)) {

                            System.out.println("===Profile Reboot===");
                            System.out.print("Nombre: ");
                            String names = leer.nextLine();
                            System.out.print("Last name: ");
                            String last = leer.nextLine();

                            System.out.print("Day: ");
                            int D1= leer.nextInt();
                            System.out.print("Month: ");
                            int M2= leer.nextInt();
                            System.out.print("Year: ");
                            int Y3= leer.nextInt();
                            leer.nextLine();
                        System.out.print("Username: ");
                        String user1 = leer.nextLine();
                        System.out.println("Password: ");
                        String pass1 = leer.nextLine();
                            Date date=new Date(D1,M2,Y3);

                            cli.getProfile().name = names;
                            cli.getProfile().lastName = last;
                            cli.getProfile().birthdate = date;
                            cli.username=user1;
                            cli.password=pass1;
                        return;
                        }
                    }
                break;

            case 3:
                System.out.print("Name: ");
                String namec1 = leer.nextLine();
                System.out.print("Last name: ");
                String lastc1 = leer.nextLine();
                for (int i = 0; i < RepositoryProfile.cr.size(); i++) {
                    if (RepositoryProfile.cr.get(i).getProfile().name.equals(namec1) && RepositoryProfile.cr.get(i).getProfile().lastName.equals(lastc1)) {
                        if (RepositoryProfile.cr.get(i).getBorrowedBoooks().isEmpty()) {
                            RepositoryProfile.cr.remove(i);
                        }
                    }
                }
                break;
        }
    }
}