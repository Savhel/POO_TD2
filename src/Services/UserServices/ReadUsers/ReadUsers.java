package Services.UserServices.ReadUsers;


import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.ReadInterfaces.ReadInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadUsers implements ReadInterface {
    UsersModel user;
    Connection connection;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public ReadUsers(UsersModel user) {
        this.user = user;
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public ArrayList<UsersModel> read(Integer id) throws Exception {
        ArrayList<UsersModel> users = new ArrayList<>();

        try {
            // Requête SQL paramétrée
            sql = "SELECT * FROM Agents WHERE Code = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, user.getId());

            // Exécution de la requête
            rsl = pst.executeQuery();

            // Parcours des résultats et création des objets PhonesModel
            while (rsl.next()) {
                UsersModel usersModel = new UsersModel();
                usersModel.setId(rsl.getInt("ID"));
                usersModel.setNom(rsl.getString("nom"));
                usersModel.setPrenom(rsl.getString("Prénom"));
                usersModel.setEmail(rsl.getString("EMAIL"));
                usersModel.setNumtel(rsl.getString("Numtel"));
                usersModel.setAddress(rsl.getString("Address"));


                users.add(usersModel); // Ajouter l'objet à la liste
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la lecture des users: " + e.getMessage());
        } finally {
            // Fermeture des ressources
            if (rsl != null) rsl.close();
            if (pst != null) pst.close();
        }

        return users;
    }
}