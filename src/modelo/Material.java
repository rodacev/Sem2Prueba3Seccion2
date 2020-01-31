package modelo;

public class Material {
    
    private String codigo;
    private String nombre;
    private String formato;
    private int duracion;
    private String categoria;
    private String autor;
    private boolean estado;
    
    
    public Material() {
        
        this.codigo = "";
        this.nombre = "";
        this.formato = "";
        this.duracion = 0;
        this.categoria = "";
        this.autor = "";
        this.estado = false;   
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    
    
    
    
    
}
