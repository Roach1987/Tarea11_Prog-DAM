package programacion.dam.tarea11.beans;

import java.util.Date;

/**
 *
 * @author Roach
 */
public class Vuelo {
    
    // Atributos
    private String codigo;
    private String codigoAvion;
    private int numeroPlazasDisponibles;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private Date fechaEscala;
    
    // Constructores
    public Vuelo() {
    }

    public Vuelo(String codigo, String codigoAvion, int numeroPlazasDisponibles, String aeropuertoOrigen, String aeropuertoDestino, Date fechaSalida, Date fechaLlegada, Date fechaEscala) {
        this.codigo = codigo;
        this.codigoAvion = codigoAvion;
        this.numeroPlazasDisponibles = numeroPlazasDisponibles;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.fechaEscala = fechaEscala;
    }
    
    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public int getNumeroPlazasDisponibles() {
        return numeroPlazasDisponibles;
    }

    public void setNumeroPlazasDisponibles(int numeroPlazasDisponibles) {
        this.numeroPlazasDisponibles = numeroPlazasDisponibles;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaEscala() {
        return fechaEscala;
    }

    public void setFechaEscala(Date fechaEscala) {
        this.fechaEscala = fechaEscala;
    } 
}