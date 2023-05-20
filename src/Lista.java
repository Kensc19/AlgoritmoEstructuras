import java.util.Scanner;

public class Lista {
    Estudiante head;
    Scanner scanner = new Scanner(System.in);
    boolean finalizar = false;
    public static class Estudiante {
        private String nombre;
        private int idEstudiante;
        private int edad;
        private String lugarDeResidencia;
        private String correo;
        Estudiante next;

        public Estudiante(){

        }

        public Estudiante(String nombre, int idEstudiante, int edad, String lugarDeResidencia, String correo, Estudiante next) {
            this.nombre = nombre;
            this.idEstudiante = idEstudiante;
            this.edad = edad;
            this.lugarDeResidencia = lugarDeResidencia;
            this.correo = correo;
            this.next = next;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getIdEstudiante() {
            return idEstudiante;
        }

        public void setIdEstudiante(int idEstudiante) {
            this.idEstudiante = idEstudiante;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getLugarDeResidencia() {
            return lugarDeResidencia;
        }

        public void setLugarDeResidencia(String lugarDeResidencia) {
            this.lugarDeResidencia = lugarDeResidencia;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public Estudiante getNext() {
            return next;
        }

        public void setNext(Estudiante next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Estudiante{" +
                    "nombre='" + nombre + '\'' +
                    ", idEstudiante=" + idEstudiante +
                    ", edad=" + edad +
                    ", lugarDeResidencia='" + lugarDeResidencia + '\'' +
                    ", correo='" + correo + '}';
        }
    }//end Estudiante

    public void ingresarEstudiante(Estudiante estudiante){

        if(head == null) //verifica si esta vacía
            head = estudiante; //el nuevo objeto pasa a ser el primero de la lista
        else{
            Estudiante ptr = head; //Si no está vacia, debe agregar al final de la lista.
            while(ptr.next!=null) //recorre la lista hasta que sea nulo
                ptr = ptr.next;

            ptr.next = estudiante; //Apunta al nuevo objeto
        }
    }// end ingresarEstudiante

    public void mostrarListaDeEstudiantes(int opcion){
        Estudiante ptr = head; //apunto al primer estudiante de la lista


        switch (opcion){
            case 2:
                System.out.println("Lista de estudiantes por ID: ");

                while(ptr.next!=null){ //verifica que no este vacía
                    if(ptr.getIdEstudiante() != 0) {
                        System.out.print(ptr.getIdEstudiante() + "-->");
                        if(ptr.next != null && ptr.next.getIdEstudiante() != 0){ //entre cada elemento de la lista se agrega uno 0 y lo que hace es ir quitandolos
                            System.out.print(" --> ");
                        }
                    }
                    ptr = ptr.next;
                }
                System.out.print("NULL\n\n");
                break;
            case 3:
                System.out.println("Lista de estudiantes por nombre: ");

                while (ptr != null) { //verifica que no este vacía
                    if (ptr.getNombre() != null) {
                        System.out.print(ptr.getNombre()+ " --> ");
                        if (ptr.next != null && ptr.next.getNombre() != null) { //entre cada elemento de la lista se agrega uno nulo y lo que hace es ir quitandolos
                            System.out.print(" --> ");
                        }
                    }
                    ptr = ptr.next;
                }
                System.out.print("NULL\n\n");
                break;
            case 4:
                System.out.println("Lista de estudiantes con todos los datos: ");

                while (ptr != null) {
                    if (ptr.toString().contains("0") && ptr.toString().contains("null")) { //entre cada elemento de la lista se agrega uno nulo o 0 y lo que hace es ir quitandolos
                    } else {
                        System.out.print(ptr.toString()); //toString contiene todos los datos
                        if (ptr.next != null) {
                            System.out.print(" -->");
                        }
                    }
                    ptr = ptr.next;
                }
                System.out.print("NULL\n\n");
                break;
            case 5:
                boolean buscarID = false;
                System.out.println("Ingrese el ID del estudiante para mostrar su información:");
                int id = scanner.nextInt();

                while (ptr!=null){
                    if(ptr.getIdEstudiante() == id) { //Se busca uno que cooincida
                        buscarID = true;
                        System.out.println("La información del estudiante de acuerdo al ID " + id + " es: " + ptr.toString()+"\n\n");
                    }
                    ptr = ptr.next;
                }
                if(!buscarID){
                    System.out.println(id + " no existe en la lista"+"\n\n");
                }
                break;
            case 6:
                boolean buscarNombre = false;
                System.out.println("Ingrese el nombre del estudiante para mostrar su información:");
                String nombre = scanner.nextLine();

                while (ptr!=null) {
                    if (ptr.getNombre() != null && ptr.getNombre().equals(nombre)) {
                        buscarNombre = true;
                        System.out.println("La información del estudiante " + nombre + " es: " + ptr.toString()+ "\n\n");
                    }
                    ptr = ptr.next;
                }
                if(!buscarNombre){
                    System.out.println(nombre + " no existe en la lista"+ "\n\n");
                }
                break;
            case 9:
                System.out.println("Ingrese el nombre del estudiante que desea borrar");
                String nombreBorrar = scanner.nextLine();

                // Si el estudiante a eliminar está al principio de la lista
                if (head.getNombre() != null && head.getNombre().equals(nombreBorrar)) {
                    head = head.next;
                    System.out.println("El estudiante " + nombreBorrar + " ha sido eliminado de la lista."+ "\n\n");
                    return;
                }

                // Si el estudiante a eliminar está en otro lugar de la lista
                Estudiante punteroAnterior = head;
                Estudiante punteroActual = head.next;
                while (punteroActual != null) {
                    if (punteroActual.getNombre() != null && punteroActual.getNombre().equals(nombreBorrar)) {
                        punteroAnterior.next = punteroActual.next;
                        punteroActual = null;
                        System.out.println("El estudiante " + nombreBorrar + " ha sido eliminado de la lista."+ "\n\n");
                        return;
                    }
                    punteroAnterior = punteroActual;
                    punteroActual = punteroActual.next;
                }

                // Si el estudiante no se encuentra en la lista
                System.out.println(nombreBorrar + " no existe en la lista."+ "\n\n");
                break;
        }
    }//end mostrarListaDeEstudiantes

    //Recibe un entero que significa la posición del estudiante que se desea obtener, y se recorrerá la lista hasta la posición ingresaada y se imprimirá el estudiante
    public void mostrarPorPosicion(int posicionBuscada){
        Estudiante ptr = head;
        int contadorPosicion = 1; //contador

        //Si la lista está vacía, se imprime ese mensaje y se detiene el método con el return
        if(ptr==null){
            System.out.println("\nLa lista está vacia, debe ingresar un estudiante\n");
        }

        while(ptr!=null){
            if(contadorPosicion == posicionBuscada && ptr.getNombre() != null){ // se compara la posición
                System.out.println("El estudiante encontrado es: \n" + ptr.toString() + "\n");
                break;
            }
            if(ptr.getNombre() != null){ //Como cada vez que se ingresa un estudiante se agrega uno nulo en el medio de cada estudiante, si por el que pasa es nulo se lo salta
                contadorPosicion++;
            }
            ptr = ptr.next;
        }//end while
    }//end mostrarPorPosicion

    //Recorre la lista hasta encontrar el estudiante que busca para cuando esto se haga, se modifique el dato correspondiente
    public void buscarEstudianteParaModificarDato(String nombre, int dato){
        Estudiante ptr = head;
        boolean nombreEncontrado = false;

        //Si la lista está vacía, se imprime ese mensaje y se detiene el método con el return
        if(ptr==null){
            System.out.println("\nLa lista está vacia, debe ingresar un estudiante\n");
            this.finalizar = true;
            return;
        }

        while(ptr!=null){
            if(nombre.equalsIgnoreCase(ptr.getNombre())) {
                modificarDato(dato, ptr);
                break;
            }
            ptr = ptr.next;
        }//end while
        if(!nombreEncontrado)
            System.out.println("El nombre ingresado no existe en la lista."+ "\n\n");

    }//end buscarEstudianteParaModificarDato

    //modifica el dato que se solicite
    public void modificarDato(int dato,Estudiante ptr){

        switch(dato){
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                String nuevoNombre = scanner.nextLine();
                ptr.setNombre(nuevoNombre);
                break;
            case 2:
                System.out.println("Ingrese el nuevo ID");
                int nuevoID = scanner.nextInt();
                ptr.setIdEstudiante(nuevoID);
                break;
            case 3:
                System.out.println("Ingrese la nueva edad");
                int nuevaEdad = scanner.nextInt();
                ptr.setEdad(nuevaEdad);
                break;
            case 4:
                System.out.println("Ingrese el nuevo lugar de residencia");
                String nuevaResidencia = scanner.nextLine();
                ptr.setLugarDeResidencia(nuevaResidencia);
                break;
            case 5:
                System.out.println("Ingrese el nuevo correo");
                String nuevoCorreo = scanner.nextLine();
                ptr.setCorreo(nuevoCorreo);
                break;
        }//end switch
    }//end modificarDato
    public int totalEstudiantesRegistrados(){
        Estudiante ptr = head;
        int contadorEstudiantes = 0;

        //Si la lista está vacía, se imprime ese mensaje y se detiene el método con el return
        if(ptr==null){
            System.out.println("\nLa lista está vacia, debe ingresar un estudiante\n");
        }

        while(ptr!=null){
            if(ptr.getNombre() != null){ //Como cada vez que se ingresa un estudiante se agrega uno nulo en el medio de cada estudiante, si por el que pasa es nulo se lo salta
                contadorEstudiantes++;
            }
            ptr = ptr.next;
        }//end while

        return contadorEstudiantes;
    }
}//end class
