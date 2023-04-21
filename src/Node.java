public class Node {

       Estudiante estud;
        Node next;
    Node(Estudiante dato, Node next)
    {
        this.estud = new Estudiante();
        this.next = null;
    }

    public Node() {
    }

    public Estudiante getDato() {
        return estud;
    }

    public void setDato(Estudiante dato) {
        this.estud = dato;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
