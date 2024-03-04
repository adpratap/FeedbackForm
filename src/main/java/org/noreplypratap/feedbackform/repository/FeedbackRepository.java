package org.noreplypratap.feedbackform.repository;

import org.noreplypratap.feedbackform.model.ViewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //DB > feedback_db
    //Tables > feedback | file_path | basic_data

    //Create
    public boolean createUserData(ViewData viewData) {

        String queryBasicData = "INSERT INTO basic_data (id,fullName,email,phoneNumber,gender,state,city,pinCode) values (?,?,?,?,?,?,?,?)";
        int x = jdbcTemplate.update(
                queryBasicData,
                viewData.getId(),
                viewData.getFullName(),
                viewData.getEmail(),
                viewData.getPhoneNumber(),
                viewData.getGender(),
                viewData.getState(),
                viewData.getCity(),
                viewData.getPinCode()
        );
        String queryFeedback = "INSERT INTO feedback (message,userId) values (?,?)";
        int y = jdbcTemplate.update(
                queryFeedback,
                viewData.getMessage(),
                viewData.getId()
        );
        String queryFilePath = "INSERT INTO file_path (filePath,userId) values (?,?)";
        int z = jdbcTemplate.update(
                queryFilePath,
                viewData.getFilePath(),
                viewData.getId()
        );

        if (x == 1 && y == 1 && z == 1)
            return true;
        return false;
    }
    public boolean updateUserData(ViewData viewData) {
        String updateQuery = "UPDATE basic_data INNER JOIN feedback ON basic_data.id = feedback.userId SET basic_data.fullName=? , basic_data.email=? , basic_data.phoneNumber=? , basic_data.gender=?, basic_data.state=?, basic_data.city=?, basic_data.pinCode=?, feedback.message=? WHERE basic_data.id = ?";

        int rowsAffected = jdbcTemplate.update(
                updateQuery,
                viewData.getFullName(),
                viewData.getEmail(),
                viewData.getPhoneNumber(),
                viewData.getGender(),
                viewData.getState(),
                viewData.getCity(),
                viewData.getPinCode(),
                viewData.getMessage(),
                viewData.getId()
        );

        return rowsAffected > 0;
    }


    //Read By ID
    public ViewData readDataById(int userId) {
        String query = "SELECT basic_data.*, file_path.filePath, feedback.message from basic_data INNER JOIN feedback ON basic_data.id = feedback.userId INNER JOIN file_path ON basic_data.id = file_path.userId WHERE basic_data.id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(ViewData.class), userId);
    }

    // Read All Data
    public List<ViewData> readAllData() {
        String query = "SELECT basic_data.*, file_path.filePath, feedback.message from basic_data INNER JOIN feedback ON basic_data.id = feedback.userId INNER JOIN file_path ON basic_data.id = file_path.userId";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ViewData.class));
    }

    public int getMaxId() {
        String query = "SELECT MAX(id) FROM basic_data";
        Integer maxId = jdbcTemplate.queryForObject(query, Integer.class);
        return maxId != null ? maxId : 0; // Return 0 if there are no records
    }

    //Update
    //Delete
    public Integer deleteById(int id) {
        String query = "DELETE basic_data, file_path, feedback FROM basic_data " +
                "INNER JOIN file_path ON basic_data.id = file_path.userId " +
                "INNER JOIN feedback  ON basic_data.id = feedback.userId " +
                "WHERE basic_data.id = ?";

        String q1 = "DELETE FROM feedback Where userID = ?";
        String q2 = "DELETE FROM file_path Where userID = ?";
        String q3 = "DELETE FROM basic_data Where id = ?";

        // Execute the SQL query
        jdbcTemplate.update(q1, id);
        jdbcTemplate.update(q2, id);
        return jdbcTemplate.update(q3, id);
    }

}
