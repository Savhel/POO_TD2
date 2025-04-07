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
            String requete="insert into Phones(id_phone,IdPropretaire,Nom,Marque,Modele,memoire_ROM,memoire_RAM,numero_serie,IMEI) VALUES (?,?,?,?,?,?,?,?,?)";
            try(PreparedStatement stmt=con.getConnection().prepareStatement(requete)){
                stmt.setString(1,p.getId());
                stmt.setString(2,p.getIdPropretaire());
                stmt.setDate(3, Date.valueOf(getDateNaissance()));
                stmt.setString(4,getAddress());
                stmt.setString(5,getEmail());
                stmt.setString(6,getTelNUmber());
                stmt.setString(7,getCycle());
                stmt.setInt(8,getNiveau());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

}
