package Services.UserServices.InsertionUsers;

import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertionUsers {
    Connection connection;
    UsersModel user;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public InsertionUsers(UsersModel user){
        this.user=user;
        connection = DatabaseConnection.getInstance().getConnection();
    }


    public int InsertionUser(){
        String requete="INSERT INTO Users (nom,prenom,email,password,numtel,address) values (?,?,?,?,?,?)";
        try(PreparedStatement stmt=connection.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS)){
//            stmt.setInt(1,user.getId());
            stmt.setString(1,user.getNom());
            stmt.setString(2,user.getPrenom());
            stmt.setString(3,user.getEmail());
            stmt.setString(4,user.getPassword());
            stmt.setString(5,user.getNumtel());
            stmt.setString(6,user.getAddress());
            stmt.executeUpdate();
            
            // Récupérer l'ID généré
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            return -1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}
