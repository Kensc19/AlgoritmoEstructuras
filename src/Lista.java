import java.util.InputMismatchException;
import java.util.Scanner;

public class Lista {
    Scanner options = new Scanner(System.in);
    Estudiante inicio;
    Estudiante estudFinal= new Estudiante();
    private int countEstuds=0;

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
                        mostrarEstudiantesNombre();
                        break;
                    case 4:
                        mostrarEstudiantes();
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
                        System.out.println(showCountStuds());
                        menu();
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
                flag = !flag;
            }} while (flag);
        menu();

    }
    public boolean listaEstudsVacia(){
        return inicio==null;
    }

    public void agregarAlFinal(Estudiante estud){
        // Define un nuevo estudiante.
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
    public void mostrarEstudiantesNombre(){
        int i=0;
        if(!listaEstudsVacia()) {
            while (inicio.getSiguiente() != null) {
                System.out.print(i + ".[ Estudiante: " + inicio.getNomEstudiante() + " ]" + " ->  ");
                inicio = inicio.getSiguiente();
                i++;
            }
            System.out.print( "NULL");
        }
    }
    public String showCountStuds(){
        return "La cantidad de estudiantes ingresados es: "+countEstuds+" estudiantes";
    }
    public void mostrarEstudiantes(){
        int i=0;
        if(!listaEstudsVacia()) {
            while (inicio.getSiguiente() != null) {
                System.out.print(i  +"--" +inicio.toString()+" " + " ->  ");
                inicio = inicio.getSiguiente();
                i++;
            }
            System.out.print( "NULL");
        }
    }

    public boolean buscarId(int id){
        Estudiante aux = inicio;// aux recorre la lista desde el inicio
        boolean encontrado = false;
        while(aux.getSiguiente() != null && !encontrado){
            if (id == aux.getIdEstudiante()){
                encontrado = true;
                break;
            }else{
                // sino lo encontró entonces
                // adelanta el "puntero" al siguiente estudiante
                aux = aux.getSiguiente();
            }
        }
        return encontrado;
    }
    public int positionEst(int id){
        Estudiante aux = inicio;// aux recorre la lista desde el inicio
        int index = 0;int i=0;
        while(aux.getSiguiente() != null){
            if (id == aux.getIdEstudiante()){
                  index=i+1;
                break;
            }else{
                // sino lo encontró entonces
                // adelanta el "puntero" al siguiente estudiante
                aux = aux.getSiguiente();
                i++;
            }

        }
        return index;
    }
    public void modificarEstudiante(){
        System.out.println("\nIngrese el ID del estudiante a modificar : Int");
        int idEstud = options.nextInt();
        if (buscarId(idEstud)){
            System.out.println("\n El ID Ingresado existe en lista ");
            int pos= positionEst(idEstud);

        }else{
            System.out.println("\n El ID Ingresado NO existe en lista ");
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

