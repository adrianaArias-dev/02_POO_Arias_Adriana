package vallegrande.edu.veterinaria.model;

public class Mascota {
    private String id;
    private String nombre;
    private String especie;
    private String dueno;

    public Mascota(String id, String nombre, String especie, String dueno) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.dueno = dueno;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getDueno() { return dueno; }
    public void setDueno(String dueno) { this.dueno = dueno; }
}