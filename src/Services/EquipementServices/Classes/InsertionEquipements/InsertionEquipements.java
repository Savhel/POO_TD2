package Services.EquipementServices.Classes.InsertionEquipements;

import Models.EquipementsModel;
import Models.MaterielsModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.InsertionInterfaces.InsertionInterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionEquipements implements InsertionInterface {
    @Override
    public void Insertion(MaterielsModel m) throws SQLException {
        EquipementsModel e=(EquipementsModel)m;
        String requet = "insert into Equipements(address_MAC,IdProprietaire,etat_Materiel,Nom,Marque,Modele,memoire_ROM,memoi_RAM,numero_serie) values (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(requet)) {
            stmt.setString(1,e.getAddress_MAC());
            stmt.setInt(2,e.getIdProprietaire());
            stmt.setString(3,e.getCouleur());
            stmt.setString(4,e.getEtat_Materiel());
            stmt.setString(5,e.getNom());
            stmt.setString(6,e.getMarque());
            stmt.setString(7,e.getModele());
            stmt.setFloat(8,e.getMemoire_ROM());
            stmt.setFloat(9,e.getMemoire_RAM());
            stmt.setString(10,e.getNumero_serie());
            stmt.executeUpdate();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
}
