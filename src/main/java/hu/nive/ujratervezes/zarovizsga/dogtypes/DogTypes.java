package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT NAME, country FROM dog_types WHERE country = ? ORDER BY NAME;")) {
            stmt.setString(1, country.toUpperCase());
            return makeListByPreparedStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }

    private List<String> makeListByPreparedStatement(PreparedStatement stmt) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString("NAME").toLowerCase());
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }
}
