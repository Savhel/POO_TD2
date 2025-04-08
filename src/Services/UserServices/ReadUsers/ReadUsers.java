package Services.UserServices.ReadUsers;


import Models.UsersModel;
import Services.DatabaseServices.DatabaseConnection;
import Services.EquipementServices.Interfaces.ReadInterfaces.ReadInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadUsers {
    UsersModel user;
    Connection connection;
    PreparedStatement pst;
    ResultSet rsl;
    String sql;

    public ReadUsers() {
        connection = DatabaseConnection.getInstance().getConnection();
    }


    public ResultSet read(Integer id) throws Exception {
//        ArrayList<UsersModel> users = new ArrayList<>();

        try {
            // Requête SQL paramétrée
            sql = "SELECT * FROM Users WHERE id_user = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);

            // Exécution de la requête
            rsl = pst.executeQuery();

            // Parcours des résultats et création des objets PhonesModel
//            while (rsl.next()) {
//                UsersModel usersModel = new UsersModel();
//                usersModel.setId(rsl.getInt("id_user"));
//                usersModel.setNom(rsl.getString("nom"));
//                usersModel.setPrenom(rsl.getString("prenom"));
//                usersModel.setEmail(rsl.getString("email"));
//                usersModel.setNumtel(rsl.getString("nnumtel"));
//                usersModel.setAddress(rsl.getString("address"));
//
//
//                users.add(usersModel); // Ajouter l'objet à la liste
//            }
            return rsl;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la lecture des users: " + e.getMessage());
        }


    }
}