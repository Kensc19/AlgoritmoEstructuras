import java.util.InputMismatchException;
import java.util.Scanner;

public class Colas {
    Estudiante cola;
    Estudiante frente;
    Scanner options = new Scanner(System.in);
    public void menu() {
        System.out.println("1 Ingresar Estudiante en la cola (push)");
        System.out.println("2 Hacer pop a la cola");
        System.out.println("3 Mostrar cola");
        System.out.println("4 Hacer top ");
        System.out.println("5 Salir");
        try {
            int optionUser = options.nextInt();
            if (optionUser != 5) {
                switch (optionUser) {
                    case 1:
                        ingresarEstds();
                        break;
                    case 2:
                        dequeue();
                        break;
                    case 3:
                        showCola();
                        break;
                    case 4:
                        top();
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
                enqueue(new Estudiante(idEstuds, nombre, numCelular, carnet, edad));
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
    public void enqueue(Estudiante estud) {
        if (cola == null) {
            cola = estud;
            frente = estud;
        } else {
            frente.setSiguiente(estud);
            frente = estud;
        }
    }// end enqueue

    public void dequeue() {// elimina por el inicio
        if (cola == null) {
            System.out.println("Pila vacia");
        } else {
            System.out.println(cola.toString());
            deleteInCola(cola);
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }
    }// end dequeue
    private void deleteInCola(Estudiante ests) {
        cola = ests.getSiguiente();
        ests.setSiguiente(null);
        if (cola == null) {
            frente = null;
        }
    }
    public void showCola() {
        Estudiante aux = cola;
        if (cola != null) {
            if (cola.getSiguiente() != null || cola.getSiguiente() == null) {
                while (aux.getSiguiente() != null || aux.getSiguiente() == null) {
                    if (aux.equals(frente)) {
                        System.out.println(".[ Estudiante: " + aux + " ]" + " ->  ");
                        break;
                    }
                    System.out.println(".[ Estudiante: " + aux + " ]" + " --->  ");
                    aux = aux.getSiguiente();
                }//
            } else {
                System.out.println("Cola vacia");
            }
        } else {
            System.out.println("Cola vacia");
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }// end showCola
    }
    private void top(){
        if(cola!=null) {
            System.out.println(cola.toString() + "\n");
        }else{
            System.out.println("Pila vacia");
        }
        System.out.println("\n¿ Desea volver al menú ?: Int \n 1)_____ SÍ\n 2)______NO");
        options.nextLine();
        int option = options.nextInt();
        if (option == 1) {
            menu();
        } else {
            System.out.println("Salió");
        }

    }// end top():
}
