package Services.UserServices.DeleteUsers;


import Services.DatabaseServices.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUsers {
    public void delete(int id) {
        String requete = "DELETE FROM  Users WHERE id_user=" + id;
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(requete)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
