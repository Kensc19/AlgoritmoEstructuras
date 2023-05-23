public class Pilas extends Lista{
    Estudiante top;

    public void push(Estudiante estudiante){
        Estudiante ptr = top;
          if(top == null){
              top = estudiante;
          }
          else{
                  ptr = estudiante;
                  ptr.next = top;
                  top = ptr;
          }
    }

    public void pop() {
        Estudiante ptr = top;
        top = top.next;
        System.out.println("Se ha eliminado al estudiante: " + ptr.getNombre() + "\n\n");
    }

    public void mostrarTop(){
        Estudiante ptr = top;
        if (top == null){
            System.out.println("La pila esta vacía, ingrese un estudiante");
        }
        System.out.println("El top de la pila es: " + ptr + "\n\n");
    }

    public void mostrar(){
        Estudiante ptr = top;
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

//pilas.mostrar();
//pilas.push(new Lista.Estudiante(nombre, id, edad, lugar, correo, new Lista.Estudiante()));