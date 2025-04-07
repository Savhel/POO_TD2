package Models;

public abstract class MaterielsModel {



    private Integer Id;
    private String Nom;
    private String Marque;
    private String Modele;
    private float memoire_ROM;
    private float memoire_RAM;
    private String numero_serie;
    private String etat ;
    private Integer IdPropretaire;

    public Integer getIdPropretaire() {
        return IdPropretaire;
    }

    public void setIdPropretaire(Integer idPropretaire) {
        IdPropretaire = idPropretaire;
    }

    public float getMemoire_RAM() {
        return memoire_RAM;
    }

    public float getMemoire_ROM() {
        return memoire_ROM;
    }

    public String getNumero_serie() {
        return numero_serie;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void setMemoire_RAM(float memoire_RAM) {
        this.memoire_RAM = memoire_RAM;
    }

    public void setMemoire_ROM(float memoire_ROM) {
        this.memoire_ROM = memoire_ROM;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getModele() {
        return Modele;
    }

    public void setModele(String modele) {
        Modele = modele;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
