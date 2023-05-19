public class Pilas extends Lista{
    Estudiante top;
    Estudiante base;

    public void push(Estudiante estudiante){
        Estudiante ptr = top;
          if(base == null){
              base = estudiante;
              top = base;
          }
          else{
                  ptr = estudiante;
                  ptr.next = top;
                  top = ptr;
          }
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
