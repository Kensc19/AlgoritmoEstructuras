public class Lista {
    Estudiante head;
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
    }//end Estudiante

    public void ingresarEstudiante(Estudiante estudiante){
        if(head == null)
            head = estudiante;
        else{
            Estudiante ptr = head;
            while(ptr!=null)
                ptr = ptr.next;

            ptr.next = estudiante;
        }


    }// end ingresarEstudiante

    public void mostrarEstudiantesPorID(){
        Estudiante ptr = head;

        while(ptr!=null){
            System.out.print(ptr.getIdEstudiante() + "-->");
            ptr = ptr.next;
        }
        System.out.print("NULL");
    }//end mostrarEstudiantesPorID

}//end class
