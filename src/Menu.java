import org.w3c.dom.Node;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner options = new Scanner(System.in);
    Estudiante estudiante = new Estudiante();

    public void menu(){



        System.out.println("1 Ingresar Estudiante");
        System.out.println("2 Mostrar todos los Estudiantes por ID\n");
        System.out.println("3 Mostrar todos los Estudiantes por Nombre\n");
        System.out.println("4 Mostrar todos los Estudiantes con todos sus datos");
        System.out.println("5 Mostrar un solo Estudiante por ID");
        System.out.println("6 Mostrar un solo Estudiante por Nombre");
        System.out.println("7 Mostrar un solo Estudiante por posición en la lista");
        System.out.println("8 Modificar Datos de un Estudiante");
        System.out.println("9 Eliminar Estudiante");
        System.out.println("10 Indicar la cantidad de Estudiantes registrados");
        System.out.println("11 Salir");


        try {
            int optionUser = options.nextInt();
            if(optionUser!=11){
                switch (optionUser) {
                    case 1:
                        ingresarEstds();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

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

                        break;
                    default:
                        System.out.println("\nIngresó una opción que no está en el menú");
                        break;
                }// end switch
            }// end if
            else {
                System.out.println("Decidió salir");
            }
        }catch(NullPointerException | NumberFormatException | InputMismatchException w){
            System.out.println("\n**********Ingrese el tipo de valor correcto ************");
        }// end catch

    }
    public void ingresarEstds(){

            System.out.println("\nIngrese el ID: Int");
                int idEstuds = options.nextInt();
                System.out.println("\nIngrese el nombre: Str");
                options.nextLine();
                String nombre = options.nextLine();
                System.out.println("\nIngrese el numero de celular: Int");
                options.nextLine();
                int numCelular = options.nextInt();
                System.out.println("\nIngrese el carnet: Int");
                options.nextLine();
                String carnet = options.nextLine();
                System.out.println("\nIngrese la edad: Int");
                options.nextLine();
                int edad = options.nextInt();

            }
}


