package iuh.fit.se.bai02.dao;

import iuh.fit.se.bai02.dao.implement.UserDAO;
import iuh.fit.se.bai02.model.Gender;
import iuh.fit.se.bai02.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final DataSource dataSource;

    public UserDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new User(
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("email"),
                        rs.getString("first_name"),
                        Gender.valueOf(rs.getString("gender").toUpperCase()),
                        rs.getString("last_name"),
                        rs.getString("password")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertUser(String firstName, String lastName, String email, String password, LocalDate birthday, Gender gender) {
        String sql = "INSERT INTO users(first_name, last_name, email, password, birthday, gender) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setDate(5, Date.valueOf(birthday));
            ps.setString(6, gender.name()); // hoặc gender.toString()

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Có thể ném ra runtime exception để Servlet xử lý:
            // throw new RuntimeException("Error inserting user", e);
        }
    }
}