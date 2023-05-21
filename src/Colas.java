public class Colas extends Lista{
    Estudiante head;

    public void enqueue(Estudiante estudiante){
        if(head == null) //verifica si esta vacía
            head = estudiante; //el nuevo objeto pasa a ser el primero de la lista
        else{
            Estudiante ptr = head; //Si no está vacia, debe agregar al final de la cola.
            while(ptr.next!=null) { //recorre la lista hasta que sea nulo
                ptr = ptr.next;
            }
            ptr.next = estudiante; //Apunta al nuevo objeto
        }
    }

    public void dequeue(){
        Estudiante ptr = head;
        head = head.next;
        System.out.println("Se ha eliminado al estudiante: " + ptr.getNombre() + "\n\n");
    }

    public void mostrarHead(){
        Estudiante ptr = head;
        if (ptr.toString().contains("0") && ptr.toString().contains("null"))
            ptr = ptr.next;

        if (head == null){
            System.out.println("La pila esta vacía, ingrese un estudiante");
        }
        System.out.println("El primer estudiante de la cola es: " + ptr + "\n\n");
    }

    public void mostrar(){
        Estudiante ptr = head;

        System.out.println("Lista de estudiantes con todos los datos: ");

        while (ptr != null) {
            if (ptr.toString().contains("0") && ptr.toString().contains("null")) { //entre cada elemento de la lista se agrega uno nulo o 0 y lo que hace es ir quitandolos
            } else {
                System.out.print(ptr.toString()); //toString contiene todos los datos
                if (ptr.next != null) {
                    System.out.print(" --> ");
                }
            }
            ptr = ptr.next;
        }
        System.out.print("NULL\n\n");
    }

}
