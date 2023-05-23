public class Colas extends Lista{
    Estudiante head;
    Estudiante rear;

    public void enqueue(Estudiante estudiante){
        if(head == null) { //verifica si esta vacía
            head = estudiante;//el nuevo objeto pasa a ser el primero de la lista
            rear = head;
        }
        else{
            rear.next = estudiante;//La cola se "enlaza" con el nuevo estudiante
            rear = estudiante;//El estudiante que se ingresó pasa a ser la nueva cola
        }
    }

    public void dequeue(){
        Estudiante ptr = head;
        if (ptr.toString().contains("0") && ptr.toString().contains("null"))
            ptr = ptr.next;
        head = ptr.next;
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
