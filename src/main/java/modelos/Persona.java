package modelos;

import com.google.gson.annotations.SerializedName;

public class Persona {
    private String nombreCompleto;
    private String telefono;
    private String correo;
    @SerializedName("fecha_creacion")
    private String fechaCreacion;

    public Persona(String nombreCompleto, String telefono, String correo, String fechaCreacion) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}';
    }
}
