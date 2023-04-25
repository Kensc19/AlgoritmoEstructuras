import java.util.Scanner;

public class Menú {

    public void menu_opciones() {
        boolean bandera = false;

        while (!bandera) {
            System.out.print("1. Ingresar Estudiante \n" + "2. Mostrar todos los estudiantes por ID  \n" + "3. Mostrar todos los estudiantes por nombre  \n" +
                    "4. Mostrar todos los estudiantes con todos los datos  \n" + "5. Mostrar un solo estudiante por ID  \n" + "6. Mostrar un solo estudiante por nombre  \n" + " 7. Mostrar un solo estudiante por posición en la lista" +
                    "8. Modificar datos de un estudiante  \n" + "9. Eliminar estudiante \n" + "10. Indicar la cantidad de estudiantes registrados  \n" + "11. Salir  \n");

            Scanner scanner = new Scanner(System.in);
            int opción = scanner.nextInt();

            switch (opción) {
                case 1:
                    System.out.println("Ingrese el nombre del estudiante");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el ID del estudiante");
                    int id = scanner.nextInt();
                    Estudiante estudiante = new Estudiante(nombre, id);

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    bandera = true;
                    break;
            }

        }
    }
}
