package Services.EquipementServices.Classes.ReadEquipements;

import Models.EquipementsModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.DeleteInterfaces.DeleteInterface;
import Services.EquipementServices.Interfaces.ReadInterfaces.ReadInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ReadEquipements implements ReadInterface {
    Connection connection ;
    EquipementsModel equipement;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public ReadEquipements(EquipementsModel equipement) {
        this.equipement = equipement;
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public List read(Integer id) throws Exception {
        try{
            sql = "SELECT * FROM Agents where Code = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1,equipement.getId());
            pst.executeUpdate();
            return Collections.singletonList("");
        }catch (Exception e){
            throw new SQLException();
        }
    }
}
