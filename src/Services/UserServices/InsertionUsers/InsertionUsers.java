package Services.UserServices.InsertionUsers;

import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionUsers {
    public void InsertionUser(UsersModel u){
        String requete="INSERT INTO Users (id_user,nom,prenom,email,numtel,address) values (?,?,?,?,?,?)";
        try(PreparedStatement stmt=DatabaseConnection.getInstance().getConnection().prepareStatement(requete)){
            stmt.setInt(1,u.getId());
            stmt.setString(2,u.getNom());
            stmt.setString(3,u.getPrenom());
            stmt.setString(4,u.getEmail());
            stmt.setString(5,u.getNumtel());
            stmt.setString(6,u.getAddress());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
