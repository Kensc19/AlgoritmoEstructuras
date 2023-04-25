import java.util.InputMismatchException;
import java.util.Scanner;

public class Lista {
    Scanner options = new Scanner(System.in);

    Estudiante inicio;
    Estudiante estudiante = new Estudiante();

    private int countEstuds;

    public void menu() {
        System.out.println("1 Ingresar Estudiante\n");
        System.out.println("2 Mostrar todos los Estudiantes por ID\n");
        System.out.println("3 Mostrar todos los Estudiantes por Nombre\n");
        System.out.println("4 Mostrar todos los Estudiantes con todos sus datos\n");
        System.out.println("5 Mostrar un solo Estudiante por ID\n");
        System.out.println("6 Mostrar un solo Estudiante por Nombre\n");
        System.out.println("7 Mostrar un solo Estudiante por posición en la lista\n");
        System.out.println("8 Modificar Datos de un Estudiante\n");
        System.out.println("9 Eliminar Estudiante\n");
        System.out.println("10 Indicar la cantidad de Estudiantes registrados\n");
        System.out.println("11 Salir\n");


        try {
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
                    case 5:

                        break;
                    case 6:
                        mostrarEstudianteNom();
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
        } catch (NullPointerException | NumberFormatException | InputMismatchException w) {
            System.out.println("\n**********Ingrese el tipo de valor correcto ************");
        }// end catch

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
                flag = !flag;
            }
        } while (flag);
        menu();

    }
    public void agregarAlFinal(Estudiante estud){
        // Define un nuevo estudiante.
        Estudiante nuevo = new Estudiante(estud.getIdEstudiante(),estud.getNomEstudiante(),
                estud.getNumCelular(),estud.getCarnet(),estud.getEdad());

        if (listaEstudsVacia()) {
            inicio = nuevo;
            estudiante=nuevo;
        } else {
            estudiante.setSiguiente(nuevo);
            estudiante=nuevo;
        }
        countEstuds++;
    }

    public boolean listaEstudsVacia(){
        return inicio==null;
    }


    public void mostrarEstudiantesId(){
        int i=0;
        Estudiante aux= inicio;
        if(!listaEstudsVacia()) {
            while (aux.getSiguiente() != null) {
                System.out.print(i + ".[ Estudiante: " + aux.getIdEstudiante() + " ]" + " ->  ");
                aux = aux.getSiguiente();
                i++;
            }
            System.out.print( "NULL");
        }
    }
    public void mostrarEstudianteNom(){
        System.out.println("\nIngrese el nombre a buscar: Str");
        options.nextLine();
        String nomReferent = options.nextLine();
        int i=0;
        if(!listaEstudsVacia()) {
            while (inicio.getSiguiente() != null) {
                if(nomReferent == inicio.getNomEstudiante())
                System.out.print(i + ".[ Estudiante: " + inicio.getNomEstudiante() + " ]" + " ->  ");
                inicio = inicio.getSiguiente();
                i++;
            }
            System.out.print( "NULL");
        }
    }

    public boolean buscarPorPosicion(int PosReferent){
        // Crea una copia de la lista.
        Estudiante aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (PosReferent == countEstuds){
                // Canbia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. nodo.
                aux = aux.getSiguiente();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }



}

