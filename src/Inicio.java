import java.util.*;
public class Inicio {
    public void menus(){
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("===MENU===");
            System.out.println("1) Client");
            System.out.println("2) Author");
            System.out.println("3) Book");
            System.out.println("4) Profile");
            System.out.println("5) Transaction");
            System.out.println("6) Cerrar sesion");
            System.out.print("Dime que quieres hacer: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("===CLIENT===");
                    ControladorClient client = new ControladorClient();
                    client.pc();
                    break;
                case 2:
                    System.out.println("===AUTHOR===");
                    ControladorAuthor auti=new ControladorAuthor();
                    auti.ca();
                    break;
                case 3:
                    System.out.println("===BOOK===");
                    ControladorBook booki=new ControladorBook();
                    booki.Books();
                    break;
                case 4:
                    System.out.println("===PROFILE===");
                    ControladorProfile profils = new ControladorProfile();
                    profils.profiles();
                    break;
                case 5:
                    System.out.println("===TRANSACTION===");
                    ControladorTransaction teis=new ControladorTransaction();
                    teis.trans();
                    break;
                    case 6:
                        Login login=new Login();
                        login.Login();
                        break;
            }
        }while (opcion != 7) ;
    }
}
