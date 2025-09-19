package iuh.fit.se.bai02.dao.implement;

import iuh.fit.se.bai02.model.Gender;
import iuh.fit.se.bai02.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void insertUser(String firstName, String lastName, String email, String password, LocalDate birthday, Gender gender);
}
