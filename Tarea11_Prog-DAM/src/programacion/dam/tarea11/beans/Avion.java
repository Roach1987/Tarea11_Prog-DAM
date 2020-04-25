package programacion.dam.tarea11.beans;

/**
 *
 * @author Roach
 */
public class Avion {
    
    // Atributos
    private String codigo;
    private String modelo;
    private int numeroPlazas;
    
    // Constructores
    public Avion() {
    }

    public Avion(String codigo, String modelo, int numeroPlazas) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.numeroPlazas = numeroPlazas;
    }
    
    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }  
}