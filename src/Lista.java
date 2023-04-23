import java.util.InputMismatchException;
import java.util.Scanner;

public class Lista {
    Scanner options = new Scanner(System.in);
    Estudiante inicio;
    Estudiante estudFinal= new Estudiante();
    private int countEstuds;

    public void menu() {
        System.out.println("1 Ingresar Estudiante");
        System.out.println("2 Mostrar todos los Estudiantes por ID");
        System.out.println("3 Mostrar todos los Estudiantes por Nombre");
        System.out.println("4 Mostrar todos los Estudiantes con todos sus datos");
        System.out.println("5 Mostrar un solo Estudiante por ID");
        System.out.println("6 Mostrar un solo Estudiante por Nombre");
        System.out.println("7 Mostrar un solo Estudiante por posición en la lista");
        System.out.println("8 Modificar Datos de un Estudiante");
        System.out.println("9 Eliminar Estudiante");
        System.out.println("10 Indicar la cantidad de Estudiantes registrados");
        System.out.println("11 Salir");
            int optionUser = options.nextInt();
            if (optionUser != 11) {
                switch (optionUser) {
                    case 1:
                        ingresarEstds();
                        break;
                    case 2:
                        mostrarEstudiantesId();
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
                    default:
                        System.out.println("\nIngresó una opción que no está en el menú");
                        break;
                }// end switch
            }// end if
            else {
                System.out.println("Decidió salir");
            }
    }

    public void ingresarEstds() {
        boolean flag = true;
        do {
            System.out.println("\nIngrese el ID: Int");
            int idEstuds = options.nextInt();
            System.out.println("\nIngrese el nombre: Str");
            options.nextLine();
            String nombre = options.nextLine();
            System.out.println("\nIngrese el numero de celular: Int");
            int numCelular = options.nextInt();
            System.out.println("\nIngrese el carnet: str");
            options.nextLine();
            String carnet = options.nextLine();
            System.out.println("\nIngrese la edad: Int");
            int edad = options.nextInt();
            agregarAlFinal(new Estudiante(idEstuds, nombre, numCelular, carnet, edad));
            System.out.println("\n¿ Desea ingresar más estudiantes ?: Int \n 1)_____ SÍ\n 2)______NO");
            options.nextLine();
            int option = options.nextInt();
            if (option != 1) {
                flag = false;
            }
        } while (flag);
        menu();

    }
    public boolean listaEstudsVacia(){
        return inicio==null;
    }

    public void agregarAlFinal(Estudiante estud){
        // Define un nuevo nodo.
        Estudiante nuevo = new Estudiante(estud.getIdEstudiante(),estud.getNomEstudiante(),
                               estud.getNumCelular(),estud.getCarnet(),estud.getEdad());

        if (listaEstudsVacia()) {
            inicio = nuevo;
            estudFinal=nuevo;
        } else {
             estudFinal.setSiguiente(nuevo);
             estudFinal=nuevo;
        }
        countEstuds++;
    }
    public void mostrarEstudiantesId(){
        int i=0;
        if(!listaEstudsVacia()) {
            while (inicio.getSiguiente() != null) {
                System.out.print(i + ".[ Estudiante: " + inicio.getIdEstudiante() + " ]" + " ->  ");
                inicio = inicio.getSiguiente();
                i++;
            }
        }
    }




}

