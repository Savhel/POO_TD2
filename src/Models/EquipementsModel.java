package Models;

public class EquipementsModel extends MaterielsModel{
      private String address_MAC;
//    private String nom;
//    private String marque;
//    private String modele;
//    private float memoire_ROM;
//    private float memoire_RAM;
//    private String numero_serie;
//    private Integer idPropretaire;
//    private String couleur;
//    private String etat_Materiel;


    //setter

    public EquipementsModel(String nom, String marque, String modele, float memoire_ROM, float memoire_RAM, String numero_serie, Integer idPropretaire, String couleur, String etat_Materiel) {
        super(nom, marque, modele, memoire_ROM, memoire_RAM, numero_serie, idPropretaire, couleur, etat_Materiel);
    }

    public EquipementsModel() {
        super();
    }

    public void setAddress_MAC(String address_MAC) {
        this.address_MAC = address_MAC;
    }

    // getter

    public String getAddress_MAC() {
        return address_MAC;
    }
}
