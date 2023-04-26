public class Lista {
    class Estudiante {
        private String nombre;
        private int idEstudiante;
        Estudiante next;

        public Estudiante(String nombre, int idEstudiante, Estudiante next) {
            this.nombre = nombre;
            this.idEstudiante = idEstudiante;
            this.next = next;
        }
    }



}
