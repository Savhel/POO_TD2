package Services.EquipementServices.Interfaces.ReadInterfaces;

import Models.MaterielsModel;

import java.sql.ResultSet;

public interface ReadInterface<T extends MaterielsModel> {
   ResultSet read(Integer id) throws Exception;
}
