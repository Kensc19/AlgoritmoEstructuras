import java.util.Scanner;

public class Menu {
    Lista lista = new Lista();

    public void menu_opciones() {
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
    }//end method
}//end class
