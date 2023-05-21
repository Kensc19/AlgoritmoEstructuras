import java.util.Scanner;

public class Menu {
    Lista lista = new Lista();
    Pilas pilas = new Pilas();
    Colas colas = new Colas();

    public void elegirMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean finalizarPrograma = false;

        while(!finalizarPrograma) {
            System.out.println("***Menú Principal***");
            System.out.println("Ingrese un [ 1 ] si desea ingresar al menú de listas enlazadas\n" +
                    "Ingrese un [ 2 ] si desea ingresar al menú de pilas\n" +
                    "Ingrese un [ 3 ] si desea ingresar al menú de colas\n" +
                    "Ingrese un [ 4 ] si desea finalizar el programa");
            int opcionMenu = scanner.nextInt();
            switch (opcionMenu) {
                case 1:
                    menu_listas();
                    break;
                case 2:
                    menu_pilas();
                    break;
                case 3:
                    menu_colas();
                    break;
                case 4:
                    finalizarPrograma = true;
                    break;
                default:
                    System.out.println("La entrada no fue correcta, debe ingresar un 1,2,3 o un 4");
            }//end switch
        }//end while
    }

    public void menu_listas() {
        boolean bandera = false;

        while (!bandera) {
            System.out.print("1. Ingresar Estudiante \n" + "2. Mostrar todos los estudiantes por ID  \n" + "3. Mostrar todos los estudiantes por nombre  \n" +
                    "4. Mostrar todos los estudiantes con todos los datos  \n" + "5. Mostrar un solo estudiante por ID  \n" + "6. Mostrar un solo estudiante por nombre  \n" + "7. Mostrar un solo estudiante por posición en la lista\n" +
                    "8. Modificar datos de un estudiante  \n" + "9. Eliminar estudiante \n" + "10. Indicar la cantidad de estudiantes registrados  \n" + "11. Salir  \n");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del estudiante");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el ID del estudiante");
                    int id = scanner.nextInt();
                    System.out.println("Ingrese la edad del estudiante");
                    int edad = scanner.nextInt();
                    System.out.println("Ingrese el lugar de residencia del estudiante");
                    scanner.nextLine();
                    String lugar = scanner.nextLine();
                    System.out.println("Ingrese el correo del estudiante");
                    String correo = scanner.nextLine();
                    lista.ingresarEstudiante(new Lista.Estudiante(nombre, id, edad, lugar, correo, new Lista.Estudiante()));
                    break;
                case 2:
                    lista.mostrarListaDeEstudiantes(opcion);
                    break;
                case 3:
                    lista.mostrarListaDeEstudiantes(opcion);
                    break;
                case 4:
                    lista.mostrarListaDeEstudiantes(opcion);
                    break;
                case 5:
                    lista.mostrarListaDeEstudiantes(opcion);
                    break;
                case 6:
                    lista.mostrarListaDeEstudiantes(opcion);
                    break;
                case 7:
                    System.out.println("Ingrese la posicion del estudiante que desea ver (empieza desde la posición 1)");
                    int posicion = scanner.nextInt();
                    lista.mostrarPorPosicion(posicion);
                    break;
                case 8:
                    System.out.println("Ingrese el nombre del estudiante al que desea modificar los datos");
                    scanner.nextLine();
                    String nombreEstudiante = scanner.nextLine();
                    boolean finalizar = false;
                    while(!finalizar) {
                        System.out.println("Ingrese el número del dato que desea modificar, o un 0 para finalizar\n" +
                                "1. Nombre\n" +
                                "2. ID\n" +
                                "3. Edad\n" +
                                "4. Lugar de residencia\n" +
                                "5. Correo\n");
                        int numeroDeDato = scanner.nextInt();

                        if (numeroDeDato == 0)
                            finalizar = true;
                        else {
                            lista.buscarEstudianteParaModificarDato(nombreEstudiante, numeroDeDato);
                            if (lista.finalizar)
                                finalizar = true;
                        }
                    }
                    break;
                case 9:
                    lista.mostrarListaDeEstudiantes(opcion);
                    break;
                case 10:
                    System.out.println("La cantidad de estudiantes registrados es: " + lista.totalEstudiantesRegistrados() + "\n");
                    break;
                case 11:
                    bandera = true;
                    break;
            }//end switch

        }//end while
        elegirMenu();
    }

    public void menu_pilas(){
        Scanner scanner = new Scanner(System.in);
        boolean salirMenuPilas = false;

        while(!salirMenuPilas) {
            System.out.println("***Menú de pilas***\n1. Ingresar Estudiante\n2. Eliminar estudiante que esté en el tope de la pila\n" +
                    "3. Mostrar el estudiante que esté en el tope de la pila\n4. Mostrar la pila\n5. Salir del menú de pilas");
            int opcionPilas = scanner.nextInt();
            switch (opcionPilas) {
                case 1:
                    System.out.println("Ingrese el nombre del estudiante");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el ID del estudiante");
                    int id = scanner.nextInt();
                    System.out.println("Ingrese la edad del estudiante");
                    int edad = scanner.nextInt();
                    System.out.println("Ingrese el lugar de residencia del estudiante");
                    scanner.nextLine();
                    String lugar = scanner.nextLine();
                    System.out.println("Ingrese el correo del estudiante");
                    String correo = scanner.nextLine();
                    pilas.push(new Lista.Estudiante(nombre, id, edad, lugar, correo, new Lista.Estudiante()));
                    break;
                case 2:
                    pilas.pop();
                    break;
                case 3:
                    pilas.mostrarTop();
                    break;
                case 4:
                    pilas.mostrar();
                    break;
                case 5:
                    salirMenuPilas = true;
                    break;
                default:
                    System.out.println("La entrada no fue correcta, debe ingresar un 1,2,3,4 o un 5");
            }//end switch
        }//end while
        elegirMenu();
    }

    public void menu_colas(){
        Scanner scanner = new Scanner(System.in);
        boolean salirMenuColas = false;

        while(!salirMenuColas) {
            System.out.println("***Menú de colas***\n1. Ingresar Estudiante\n2. Eliminar estudiante que esté al frente de la cola\n" +
                    "3. Mostrar el estudiante que esté al frente de la cola\n4. Mostrar la cola\n5. Salir del menú de colas");
            int opcionColas = scanner.nextInt();
            switch (opcionColas) {
                case 1:
                    System.out.println("Ingrese el nombre del estudiante");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el ID del estudiante");
                    int id = scanner.nextInt();
                    System.out.println("Ingrese la edad del estudiante");
                    int edad = scanner.nextInt();
                    System.out.println("Ingrese el lugar de residencia del estudiante");
                    scanner.nextLine();
                    String lugar = scanner.nextLine();
                    System.out.println("Ingrese el correo del estudiante");
                    String correo = scanner.nextLine();
                    colas.enqueue(new Lista.Estudiante(nombre, id, edad, lugar, correo, new Lista.Estudiante()));
                    break;
                case 2:
                    colas.dequeue();
                    break;
                case 3:
                    colas.mostrarHead();
                    break;
                case 4:
                    colas.mostrar();
                    break;
                case 5:
                    salirMenuColas = true;
                    break;
                default:
                    System.out.println("La entrada no fue correcta, debe ingresar un 1,2,3,4 o un 5");
            }//end switch
        }//end while
        elegirMenu();
    }

}//end class