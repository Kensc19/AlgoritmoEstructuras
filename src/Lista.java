import java.util.Arrays;
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
                    buscarEstudianteID();
                    break;
                case 6:
                    buscarEstudianteNombre();
                    break;
                case 7:

                    break;
                case 8:
                    modificarEstudiante();
                    break;
                case 9:

                    break;
                case 10:
                    System.out.println(showCountStuds());
                    System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
                    options.nextLine();
                    int option = options.nextInt();
                    if (option == 1) {
                        menu();
                    } else {
                        System.out.println("Decidió salir");
                    }
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
        try {
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
        }catch (InputMismatchException ee){
            System.out.println("error en el tipo de dato");
            options.nextLine();
            ingresarEstds();
        }

    }// end ingresar estuds
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
    }// end agregar al final
    public void mostrarEstudiantesId(){
        int i=0;
        Estudiante aux= inicio;
        if(!listaEstudsVacia()) {
            while (aux.getSiguiente() != null||aux.getSiguiente()==null) {
                if(aux.equals(estudFinal)){
                    System.out.print(i + ".[ Estudiante: " + aux.getIdEstudiante() + " ]" + " ->  ");
                    break;
                }
                System.out.print(i + ".[ Estudiante: " + aux.getIdEstudiante() + " ]" + " ->  ");
                aux = aux.getSiguiente();
                i++;
            }
            System.out.print( "NULL");
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }// end mostrar id
    public void mostrarEstudiantesNombre(){
        int i=0;
        Estudiante aux= inicio;
        if(!listaEstudsVacia()) {
            while (aux.getSiguiente() != null||aux.getSiguiente()==null) {
                if(aux.equals(estudFinal)){
                    System.out.print(i + ".[ Estudiante: " + aux.getNomEstudiante() + " ]" + " ->  ");
                    break;
                }
                System.out.print(i + ".[ Estudiante: " + aux.getNomEstudiante() + " ]" + " ->  ");
                aux = aux.getSiguiente();
                i++;
            }// while
            System.out.print( "NULL");
        }// if
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }
    public String showCountStuds(){
        return countEstuds!=0?"La cantidad de estudiantes ingresados es: "+countEstuds+" estudiantes":"Lista Vacia{}";
    }
    public void mostrarEstudiantes(){
        int i=0;
        Estudiante aux= inicio;
        if(!listaEstudsVacia()) {
            while (aux.getSiguiente() != null||aux.getSiguiente()==null) {
                if(aux.equals(estudFinal)){
                    System.out.print(i + ".[ Estudiante: " + aux.toString() + " ]" + " ->  ");
                    break;
                }
                System.out.print(i + ".[ Estudiante: " + aux.toString() + " ]" + " --->  \n");
                aux = aux.getSiguiente();
                i++;
            }
            System.out.print( "NULL");
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }

    public boolean buscarId(int id){
        Estudiante aux = inicio;// aux recorre la lista desde el inicio
        boolean encontrado = false;
        while(aux.getSiguiente() != null){
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
    public void buscarEstudianteID() {
        System.out.println("Ingrese el id del estudiante a buscar");
        int idBuscado = options.nextInt();
        options.nextLine(); // consume la nueva línea después de nextInt()
        Estudiante aux = inicio;
            if (!listaEstudsVacia()) {
                while (aux != null) {
                    if (aux.getIdEstudiante() == idBuscado) {
                        System.out.print(".[ Estudiante: " + aux.toString() + " ]" + " ->  ");
                        break;
                    }else{

                        System.out.println("El ID a consultar, no corresponde a ningún estudiante");
                    }
                    aux = aux.getSiguiente();
                }
                System.out.println("Null");
            }
        System.out.println("\n¿ Desea consultar por otro estudiante ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            buscarEstudianteID();
        } else {
            menu();
        }
    }
    public void buscarEstudianteNombre() {
        System.out.println("Ingrese el nombre del estudiante a buscar: Str");
        options.nextLine();
        String nomBuscado = options.nextLine();
        Estudiante aux = inicio;
        if (!listaEstudsVacia()) {
            while (aux != null) {
                if (aux.getNomEstudiante().equals(nomBuscado))
                    {
                    System.out.print(".[ Estudiante: " + aux.toString() + " ]" + " ->  ");
                    break;
                }else{

                    System.out.println("El nombre a consultar, no corresponde a ningún estudiante");
                }
                aux = aux.getSiguiente();
            System.out.println("Null");
        }
        System.out.println("\n¿ Desea consultar por otro estudiante ?: Int \n 1)_____ SÍ\n 2)______NO");
        int option = options.nextInt();
        options.nextLine();
        if (option == 1) {
            buscarEstudianteID();
        } else {
            option = 2;
            menu();
             } //End else
        } //end if (!listaEstudsVacia())
    } //end buscarEstudianteNombre()

    public int positionEst(int id){
        Estudiante aux = inicio;// aux recorre la lista desde el inicio
        int index = 0;int i=0;
        while(aux.getSiguiente() != null){
            if (id == aux.getIdEstudiante()){
                  index=i;
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
        Estudiante auxModificar= inicio;
        if(countEstuds==0){
            System.out.println("\n Lista vacia no se puede modifica ningun estudiante");
        }else {
            System.out.println("\nIngrese el ID del estudiante a modificar : Int");
            int idEstud = options.nextInt();
            int i = 0; int pos = positionEst(idEstud); // i es un una bandera para llegar a la posicion de la lista
            if (buscarId(idEstud)) {
                System.out.println("\n El ID Ingresado existe en lista ");
                while (auxModificar.getSiguiente() != null || countEstuds == 1) {
                    if (pos == i) {
                        try {
                            System.out.println("\nIngrese el ID: Int");
                            int idEstuds = options.nextInt();
                            auxModificar.setIdEstudiante(idEstuds);
                            System.out.println("\nIngrese el nombre: Str");
                            options.nextLine();
                            String nombre = options.nextLine();
                            auxModificar.setNomEstudiante(nombre);
                            System.out.println("\nIngrese el numero de celular: Int");
                            int numCelular = options.nextInt();
                            auxModificar.setNumCelular(numCelular);
                            System.out.println("\nIngrese el carnet: str");
                            options.nextLine();
                            String carnet = options.nextLine();
                            auxModificar.setCarnet(carnet);
                            System.out.println("\nIngrese la edad: Int");
                            int edad = options.nextInt();
                            auxModificar.setEdad(edad);
                            System.out.println("Se realiazaron los cambios");
                            menu();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Error en los datos");
                            modificarEstudiante();
                        }
                    }// end if de posicion
                    auxModificar = auxModificar.getSiguiente();
                    i++;
                }// while que recorre la lista
            } else {
                System.out.println("\n El ID Ingresado NO existe en lista ");
                System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
                options.nextLine();
                int option = options.nextInt();
                if (option == 1) {
                    menu();
                } else {System.out.println("Salió");}
            }// else existe estudiante
        }// else de lista vacia
    }// modificar()


    //metodo sin usar
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
}// class

