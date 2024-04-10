import java.util.Scanner;

public class ControladorAuthor {
    public void ca() {
        Scanner leer = new Scanner(System.in);
        int numero = 0;
        System.out.println("1) Crear");
        System.out.println("2) Actualizar");
        System.out.println("3) Eliminar");
        System.out.println("Escoja una opcion: ");
        numero = leer.nextInt();
        leer.nextLine();
        switch (numero) {
            case 1:
                System.out.print("Name: ");
                String nameau = leer.nextLine();

                System.out.print("Last name: ");
                String lastau = leer.nextLine();

                System.out.print("Day: ");
                int D= leer.nextInt();
                System.out.print("Month: ");
                int M= leer.nextInt();
                System.out.print("Year: ");
                int Y= leer.nextInt();

                Date birth=new Date(D,M,Y);
                Profile autor = new Profile(nameau, lastau, birth);
                Author cel = new Author(autor);
                RepositoryProfile.cl.add(cel);

                System.out.println("Autor creado con exito");
                break;

            case 2:

                System.out.print("Dame el nombre a modificar:");
                String nombre3 = leer.nextLine();
                System.out.print("Dame el apellido a modificar:");
                String apellido3 = leer.nextLine();
                System.out.println("");

                for (Author sep : RepositoryProfile.cl) {
                    if (sep.getProfile().name.equals(nombre3)&&sep.getProfile().lastName.equals(apellido3)) {

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

                            Date birth1=new Date(D1,M2,Y3);

                            sep.getProfile().name = names;
                            sep.getProfile().lastName = last;
                            sep.getProfile().birthdate = birth1;
                             return;

                    }


                }
                break;
            case 3:
                System.out.print("Name: ");
                String namec2 = leer.nextLine();
                System.out.print("Last name: ");
                String lastc2 = leer.nextLine();

                for (int i = 0; i < RepositoryProfile.cl.size(); i++) {
                    if (RepositoryProfile.cl.get(i).getProfile().name.equals(namec2) && RepositoryProfile.cl.get(i).getProfile().lastName.equals(lastc2)) {
                        RepositoryProfile.cl.remove(i);
                    }
                }
                break;

        }
    }
}
