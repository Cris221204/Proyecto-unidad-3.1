
import java.util.*;

public class ControladorSuperAdministrator {
    public void Senad() {
        Scanner leer = new Scanner(System.in);
        int n;
        do {
            System.out.println("===Menu SuperAdmin===");
            System.out.println("1) Crear administrador");
            System.out.println("2) Editar administrador");
            System.out.println("3) Eliminar administrador");
            System.out.println("4) Mostrar los administradores");
            System.out.println("5) Client");
            System.out.println("6) Author");
            System.out.println("7) Book");
            System.out.println("8) Profile");
            System.out.println("9) Transaction");
            System.out.println("10) Cerrar sesion");
            System.out.println("11) Editar permisos");
            System.out.print("Elige:");
            n = leer.nextInt();
            switch (n) {
                case 1:

                    leer.nextLine();
                    System.out.print("Name: ");
                    String namec = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc = leer.nextLine();
                    System.out.print("Day: ");
                    int D = leer.nextInt();
                    System.out.print("Month: ");
                    int M = leer.nextInt();
                    System.out.print("Year: ");
                    int Y = leer.nextInt();
                    leer.nextLine();
                    System.out.print("Username: ");
                    String user = leer.nextLine();
                    System.out.println("Password: ");
                    String pass = leer.nextLine();

                    Date fechad = new Date(D, M, Y);
                    Profile ad1 = new Profile(namec, lastc, fechad);
                    boolean isSuperAdmin = (RepositorySuperAdministrator.Admins.isEmpty());
                    Administrator ulti = new Administrator(ad1, user, pass, false);

                    ulti.addPermissions();
                    RepositorySuperAdministrator.Admins.add(ulti);
                    break;

                case 2:
                    leer.nextLine();
                    System.out.print("Dame el nombre a modificar:");
                    String nombre2 = leer.nextLine();
                    System.out.print("Dame el apellido a modificar:");
                    String apellido = leer.nextLine();
                    System.out.print("Dame el username a modificar: ");
                    String un = leer.nextLine();

                    for (Administrator mod : RepositorySuperAdministrator.Admins) {
                        if (mod.profile.name.equals(nombre2) && mod.profile.lastName.equals(apellido) && mod.username.equals(un)) {

                            System.out.print("Nombre: ");
                            String names = leer.nextLine();
                            System.out.print("Last name: ");
                            String last = leer.nextLine();
                            System.out.print("Day: ");
                            int D1 = leer.nextInt();
                            System.out.print("Month: ");
                            int M2 = leer.nextInt();
                            System.out.print("Year: ");
                            int Y3 = leer.nextInt();
                            leer.nextLine();
                            System.out.print("Username: ");
                            String user2 = leer.nextLine();
                            System.out.println("Password: ");
                            String pass2 = leer.nextLine();
                            Date date = new Date(D1, M2, Y3);
                            mod.profile.name = names;
                            mod.profile.lastName = last;
                            mod.profile.birthdate = date;
                            mod.username = user2;
                            mod.password = pass2;
                        }
                    }

                    break;

                case 3:
                    for (Administrator Admins : RepositorySuperAdministrator.Admins) {

                        int day = Admins.profile.birthdate.day;
                        int mon = Admins.profile.birthdate.month;
                        int yea = Admins.profile.birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| SuperAdmin: %s| ",
                                Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, Admins.isSuperAdmin);
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                    leer.nextLine();
                    System.out.print("Name: ");
                    String namec1 = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc1 = leer.nextLine();
                    System.out.print("Username:");
                    String Us = leer.nextLine();

                    boolean superexis = false;


                    for (int i = 0; i < RepositorySuperAdministrator.Admins.size(); i++) {
                        if (RepositorySuperAdministrator.Admins.get(i).profile.name.equals(namec1) && RepositorySuperAdministrator.Admins.get(i).profile.lastName.equals(lastc1) && RepositorySuperAdministrator.Admins.get(i).username.equals(Us)) {
                            if (RepositorySuperAdministrator.Admins.get(i).isSuperAdmin) {
                                superexis = true;
                                break;
                            }
                            RepositorySuperAdministrator.Admins.remove(i);
                            break;
                        }
                    }
                    if ((superexis)) {
                        System.out.println("No se puede eliminar");
                    }

                    break;
                case 4:
                    for (Administrator Admins : RepositorySuperAdministrator.Admins) {

                        int day = Admins.profile.birthdate.day;
                        int mon = Admins.profile.birthdate.month;
                        int yea = Admins.profile.birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| SuperAdmin: %s| ",
                                Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, Admins.isSuperAdmin);
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                    break;
                case 5:
                    System.out.println("===CLIENT===");
                    ControladorClient client = new ControladorClient();
                    client.pc();
                    break;
                case 6:
                    System.out.println("===AUTHOR===");
                    ControladorAuthor auti=new ControladorAuthor();
                    auti.ca();
                    break;
                case 7:
                    System.out.println("===BOOK===");
                    ControladorBook booki=new ControladorBook();
                    booki.Books();
                    break;
                case 8:
                    System.out.println("===PROFILE===");
                    ControladorProfile profils = new ControladorProfile();
                    profils.profiles();
                    break;
                case 9:
                    System.out.println("===TRANSACTION===");
                    ControladorTransaction teis=new ControladorTransaction();
                    teis.trans();
                    break;
                case 10:
                    Login login=new Login();
                    login.Login();
                    break;
                case 11:
                    for (Administrator Admins : RepositorySuperAdministrator.Admins) {

                        int day = Admins.profile.birthdate.day;
                        int mon = Admins.profile.birthdate.month;
                        int yea = Admins.profile.birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| SuperAdmin: %s| ",
                                Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, Admins.isSuperAdmin);
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                    leer.nextLine();
                    System.out.print("Dame el username: ");
                    String dam=leer.nextLine();
                    for (Administrator rep:RepositorySuperAdministrator.Admins){
                        if(rep.username.equals(dam)){
                            if(rep.isSuperAdmin){
                                System.out.println("No puedes modificar los permisos");
                                ControladorSuperAdministrator controladorSuperAdministrator=new ControladorSuperAdministrator();
                                controladorSuperAdministrator.Senad();

                            }
                            System.out.println("Estos son sus permisos:");
                            for (Permissions pes:rep.getPermissions()){
                                System.out.println(pes);
                            }
                            System.out.println("1) Elliminar");
                            System.out.println("2) Agregar");
                            int ag= leer.nextInt();
                            switch (ag){
                                case 1:
                            rep.getPermissions().clear();
                                    System.out.println("Eliminados");
                           break;

                                case 2:
                                rep.addPermissions();
                                    System.out.println("Agregados");
                                    break;
                            }
                        }
                }
    break;
            }
        } while (n != 12);
    }
}