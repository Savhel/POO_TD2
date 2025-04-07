package Services.EquipementServices.Classes.InsertionPhones;

import Models.PhonesModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.InsertionInterfaces.InsertionInterface;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionPhones implements InsertionInterface {
    @Override
    public void Insertion(PhonesModel p) {
        DatabaseConnection con=new DatabaseConnection();
            String requete="insert into Phones(IMEI,IdProprietaire,Nom,Marque,Modele,memoire_ROM,memoire_RAM,numero_serie) VALUES (?,?,?,?,?,?,?,?)";
            try(PreparedStatement stmt=con.getConnection().prepareStatement(requete)){
                stmt.setString(1,p.getIMEI());
                stmt.setInt(2,p.getIdProprietaire());
                stmt.setString(3,p.getEtat_Materiel());
                stmt.setString(4,p.getCouleur());
                stmt.setString(5,p.getNom());
                stmt.setString(6,p.getMarque());
                stmt.setString(7, p.getModele());
                stmt.setFloat(8,p.getMemoire_ROM());
                stmt.setFloat(9,p.getMemoire_RAM());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
