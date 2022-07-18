package Modelo;

public class Cliente {
    int id;
    String dni;
    String nom;
    String dire;
    String estado;
    
    public Cliente(){
    
    }

    public Cliente(int id, String dni, String nom, String dire, String estado) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.dire = dire;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}