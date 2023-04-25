public class Lista {
    class Node {
        Estudiante data;
        Node next;
    }
    public void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    public void agregarACola(Node head,Estudiante data){
        Node newNode = new Node();
        newNode.data = data;

        Node ptr = head;
        while (ptr.next != null)
            ptr = ptr.next;

        ptr.next = newNode;
    }

    public Node constructList(Estudiante[] keys)
    {
        Node head = null;

        // comienza desde el final de la array
        for (int i = keys.length - 1; i >= 0; i--) {
            head = agregarACola(head, keys[i]);
        }

        return head;
    }

    public void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Minor",787763);

        Estudiante[] keys = {estudiante1};


        Node head = constructList(keys);

        printList(head);
    }
}
