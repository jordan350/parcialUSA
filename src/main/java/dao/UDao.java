package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.estudiante;
import model.registro;
import util.DbUtil;

public class UDao {

    private Connection connection;

    public UDao() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("jdbc:mysql://localhost:3306/parcialusa"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        connection = DbUtil.getConnection();
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(dbUrl, username, password);
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            }

        }

    }

    public registro validar(registro registro) {
        try {
            PreparedStatement preparedStatement = null;
            String consulta = "select DISTINCT students.firstname from students, results, exercises where students.sid = results.sid  and results.cat='H';";
            preparedStatement = connection.prepareStatement(consulta);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
