package Services.EquipementServices.Interfaces.InsertionInterfaces;

import Models.EquipementsModel;
import Models.MaterielsModel;
import Models.PhonesModel;

import java.sql.SQLException;

public interface InsertionInterface {
    public void Insertion(MaterielsModel m) throws SQLException;

}
