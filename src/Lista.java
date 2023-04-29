
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
                    buscarPorPosicion();
                    break;
                case 8:
                    modificarEstudiante();
                    break;
                case 9:
                    eliminarEstudiante();
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
                    System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
                    options.nextLine();
                    int option8 = options.nextInt();
                    if (option8 == 1) {
                        menu();
                    } else {
                        System.out.println("Decidió salir");
                    }
                    break;
            }// end switch
        }// end if
        else {
            System.out.println("Decidió salir");
        }
    }// nenu
    public boolean listaEstudsVacia(){// revisa si la lista está vacía
        return inicio==null;
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
        }else{
            System.out.println("lista vacia");
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
        }else {
            System.out.println("lista vacia");
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }// end buscarPorNombre

    public String showCountStuds(){
        return countEstuds!=0?"La cantidad de estudiantes ingresados es: "+countEstuds+" estudiantes":"Lista Vacia{}";
    }// end showCountStuds
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
        }else{
            System.out.println("Lista vacia");
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }// end mostrarEstudiantes

    // este metodo es para saber de la existencia de un estudiante en al lista
    public boolean buscarId(int id){
        Estudiante aux = inicio;// aux recorre la lista desde el inicio
        boolean encontrado = false;
        if(!listaEstudsVacia()) {
            while (aux.getSiguiente() != null||aux.getSiguiente()==null) {
                if (id == aux.getIdEstudiante()) {
                    encontrado = true;
                    break;
                } else {
                    // sino lo encontró entonces
                    // adelanta el "puntero" al siguiente estudiante
                    if(aux.getSiguiente()==null){break;}
                    aux = aux.getSiguiente();
                }
            }
        }
        return encontrado;
    }//buscarId:bo

    public void buscarEstudianteID() {
        if(!listaEstudsVacia()) {
        System.out.println("Ingrese el id del estudiante a buscar");
        int idBuscado = options.nextInt();
        options.nextLine(); // consume la nueva línea después de nextInt()
        Estudiante aux= inicio;
            while (aux.getSiguiente() != null || aux.getSiguiente()==null ) {
                if(buscarId(idBuscado)) {
                    if (aux.getIdEstudiante() == idBuscado) {
                        System.out.print(".[ Estudiante: " + aux.toString() + " ]" + " ->  ");
                        break;
                    } else {
                        aux = aux.getSiguiente();
                    }
                }else{
                    System.out.println("No existe el estudiante con el ID ''"+idBuscado);
                    break;
                }
            }// while
            System.out.print( "NULL");
        }else{
            System.out.println("Lista vacia");
        }
        System.out.println("\n¿ Desea consultar por otro estudiante ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            buscarEstudianteID();
        } else {
            menu();
        }
    }// end buscarPorID()

    public void buscarEstudianteNombre() {
        if(!listaEstudsVacia()) {
        System.out.println("Ingrese el nombre del estudiante a buscar: Str");
        options.nextLine();
        String nomBuscado = options.nextLine();
        Estudiante aux = inicio;
            while (aux.getSiguiente() != null|| aux.getSiguiente()==null) {
                if(buscarId(aux.getIdEstudiante())) {
                    if (aux.getNomEstudiante().equals(nomBuscado)) {
                        System.out.print(".[ Estudiante: " + aux.toString() + " ]" + " ->  ");
                        break;
                    } else {
                        aux = aux.getSiguiente();
                    }
                }else{
                    System.out.println("No existe el estudiante de nombre: ''"+nomBuscado+"''");
                    break;
                }
            }// while
            System.out.print( "NULL");
        }else{
            System.out.println("Lista vacia");
        }
        System.out.println("\n¿ Desea ir al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        int option = options.nextInt();
        options.nextLine();
        if (option == 1) {
           menu();
        } else {
            System.out.println("Salió");}
    } //end buscarEstudianteNombre()

    // da el indice exacto donde se encuetra el estudiante en la lista
    // esto para que lo use el metodo modificarEstudiante() que necesita la indice exacto para
    // detener el while
    public int positionEst(int id){
        Estudiante aux = inicio;// aux recorre la lista desde el inicio
        int index = 0;int i=0;
        if(countEstuds!=0){
            while (aux.getSiguiente() != null || aux.getSiguiente()== null) {
                if (id == aux.getIdEstudiante()) {
                    index = i;
                    break;
                } else {
                    aux = aux.getSiguiente(); // adelanta el "puntero" al siguiente estudiante
                    i++;
                }
            }// while
        }
        return index;
    }// positionEst(int):int
    public void modificarEstudiante(){
        Estudiante auxModificar= inicio;
        if(!listaEstudsVacia()){
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
            }// else existe estudiante
        }else {
            System.out.println("\n Lista vacia no se puede modificar ningun estudiante");
        }// else de lista vacia
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {System.out.println("Salió");}
    }// modificar()


    //metodo sin usar
    public void buscarPorPosicion() {
        int i = 0;
        Estudiante aux = inicio;
        if (!listaEstudsVacia()) {
            System.out.println("\nIngrese la posición : Int");
            int posReferent = options.nextInt();
            if (posReferent > countEstuds || posReferent < 0) {
                System.out.println("No existe la posición");
            } else {
                while (aux.getSiguiente() != null || countEstuds>0) {
                    int index = positionEst(posReferent);
                    if (index == i) {
                        System.out.println(aux);
                        break;
                    }
                    aux = aux.getSiguiente();
                    i++;
                }// while que recorre la lista
            }
        }else{
            System.out.println("lista Vacia");
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {System.out.println("Salió");}
    }
    public void eliminarEstudiante(){
        Estudiante aux = inicio;
        if (!listaEstudsVacia()) {
            System.out.println("Ingrese el ID del estudiante a eliminar: int");
            options.nextLine();
            int iDAbuscar = options.nextInt();
            int indice = 0;
            if (buscarId(iDAbuscar)) {
                int posAnt = positionEst(iDAbuscar);
                if(1==(posAnt+1)){// para eliminar al inicio
                    Estudiante posIni = inicio.getSiguiente();
                    inicio=posIni;
                    countEstuds--;
                    System.out.println("ELIMINADO");
                }else if(countEstuds==(posAnt+1)) {// para eliminar al final
                    Estudiante posF = encuentraAnterior(estudFinal);
                    posF.setSiguiente(null);
                    estudFinal = posF;
                    countEstuds--;
                    System.out.println("ELIMINADO ");
                }else{
                    while (aux.getSiguiente() != null) {
                        if (indice == posAnt) {
                            Estudiante estudAnterior = encuentraAnterior(aux);
                            estudAnterior.setSiguiente(aux.getSiguiente());
                            countEstuds--;
                            System.out.println("ELIMINADO");
                            break;
                        } else {
                            indice++;
                            aux = aux.getSiguiente();}
                    }// end while
                }// end if borrar al inicio
            } else {
                System.out.println("No existe el estudiante ");
            }
        } else {
            System.out.println("Lista vacia");
        }
        System.out.println("\n¿ Desea ir al menú ?: Int \n 1)_ SÍ\n 2)__NO");
        int option = options.nextInt();
        options.nextLine();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }// end eliminar

    public Estudiante encuentraAnterior(Estudiante estudiante){
        Estudiante aux= inicio;
        if(!listaEstudsVacia()) {
            int indice=0;
            while(aux.getSiguiente()!=null|| aux.getSiguiente()==null){
                if(buscarId(estudiante.getIdEstudiante())){
                    int indexEstAnterior= positionEst(estudiante.getIdEstudiante());
                    if(indice==indexEstAnterior-1){
                        break;
                    }else{
                        aux= aux.getSiguiente();
                        indice++;
                    }
                }else{
                    return null;}
            }// while
        }else{
            System.out.println("Lista vacia");
        }
        return aux;
    }// end encuentraAbterior
}// class

