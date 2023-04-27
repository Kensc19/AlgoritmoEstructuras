public class Estudiante {

    private int idEstudiante;

    private String nomEstudiante;

    private int numCelular;

    private String carnet;

    private int edad;
    private Estudiante siguiente;

    public int getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(int numCelular) {
        this.numCelular = numCelular;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNomEstudiante() {
        return nomEstudiante;
    }

    public void setNomEstudiante(String nomEstudiante) {
        this.nomEstudiante = nomEstudiante;
    }

    public Estudiante getSiguiente() {return siguiente;}

    public void setSiguiente(Estudiante siguiente) {this.siguiente = siguiente;}

    public Estudiante() {
    }
    @Override
    public String toString() {
        return "{" +
                " iD=" + idEstudiante +
                ", Nombre='" + nomEstudiante + '\'' +
                ", Celular=" + numCelular +
                ", Carnet='" + carnet + '\'' +
                ", Edad=" + edad +
                '}';
    }

    public Estudiante(int idEstudiante, String nomEstudiante, int numCelular, String carnet, int edad) {
        this.idEstudiante = idEstudiante;
        this.nomEstudiante = nomEstudiante;
        this.numCelular = numCelular;
        this.carnet = carnet;
        this.edad = edad;
        this.siguiente = null;
    }
}
