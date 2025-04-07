package Models;

public class PhonesModel extends MaterielsModel {
    private String IMEI;


    public PhonesModel(String nom, String marque, String modele, float memoire_ROM, float memoire_RAM, String numero_serie, Integer idPropretaire, String couleur, String etat_Materiel, String IMEI) {
        super(nom, marque, modele, memoire_ROM, memoire_RAM, numero_serie, idPropretaire, couleur, etat_Materiel);
        this.IMEI = IMEI;
    }

    public PhonesModel(String IMEI) {
        this.IMEI = IMEI;
    }

    public PhonesModel() {
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}
