package programacion.dam.tarea11.beans;

/**
 *
 * @author Roach_Mimi
 */
public class Plazas {
    
    // Atributos
    private String codigo;
    private String codigoVuelo;
    private String estado;
    
    // Constructores
    public Plazas() {
    }

    public Plazas(String codigo, String codigoVuelo, String estado) {
        this.codigo = codigo;
        this.codigoVuelo = codigoVuelo;
        this.estado = estado;
    }
    
    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}