package Models;

public class EquipementsModel extends MaterielsModel{
    private String address_MAC;


    //setter


    public EquipementsModel(String nom, String marque, String modele, float memoire_ROM, float memoire_RAM, String numero_serie, Integer idPropretaire, String couleur, String etat_Materiel, String address_MAC) {
        super(nom, marque, modele, memoire_ROM, memoire_RAM, numero_serie, idPropretaire, couleur, etat_Materiel);
        this.address_MAC = address_MAC;
    }

    public EquipementsModel(String address_MAC) {
        super();
        this.address_MAC = address_MAC;
    }

    public void setAddress_MAC(String address_MAC) {
        this.address_MAC = address_MAC;
    }

    public EquipementsModel (){

    }

    // getter

    public String getAddress_MAC() {
        return address_MAC;
    }

}
