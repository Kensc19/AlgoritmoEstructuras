import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Universidad De Costa Rica
 * @author Brandon Vargas C28223
 * @author Kendall Sanchez C27227
 * Laboratorio 4 Algoritmos y estructuras de datos
 * Pilas y colas
 **/
public class interfacePilasColas {
    Estudiante base;
    Estudiante estudianteTop;
    Scanner options = new Scanner(System.in);

    public void menu() {
        System.out.println("1 Ingresar Estudiante (push)");
        System.out.println("2 Hacer Estudiante (pop)");
        System.out.println("3 Mostrar Pila");
        System.out.println("4 Salir");
        try {
            int optionUser = options.nextInt();
            if (optionUser != 4) {
                switch (optionUser) {
                    case 1:
                        ingresarEstds();
                        break;
                    case 2:
                         pop();
                        break;
                    case 3:
                      showStack();
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
        }catch (InputMismatchException d){
            System.out.println("error en el tipo de dato");
            options.nextLine();
            menu();
        }
    }// nenu

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
                push(new Estudiante(idEstuds, nombre, numCelular, carnet, edad));
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

    // se ecnarga de hacer agregar por el inicio
    public void push(Estudiante estud){
        if (base==null ){
            base=estud;
            estudianteTop=estud;
        } else {
            estud.setSiguiente(estudianteTop);
            estudianteTop=estud;
        }
    }// end agregar push()
    public void pop(){// elimina por el inicio
        if(base==null){
            System.out.println("Pila vacia");
        }else{
            System.out.println(estudianteTop.toString());
            delete(estudianteTop);
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }// end pop()

    public void showStack(){
        int i=0;
        Estudiante aux= estudianteTop;
        if(estudianteTop.getSiguiente()!=null ||estudianteTop.getSiguiente()==null ) {
            while (aux.getSiguiente() != null||aux.getSiguiente()==null) {
                if(aux.equals(base)){
                    System.out.println(i + ".[ Estudiante: " + aux+ " ]" + " ->  ");
                    break;
                }
                System.out.println(i + ".[ Estudiante: " + aux + " ]" + " --->  ");
                   aux= aux.getSiguiente();
                i++;
            }//
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
    }// end showStack
    private void delete(Estudiante ests){
        estudianteTop= ests.getSiguiente();
        ests.setSiguiente(null);
        if(estudianteTop==null){
            base=null;
        }
    }// decidimos borrar el elemento

}// end class
