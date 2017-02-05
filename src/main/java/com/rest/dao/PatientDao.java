package com.rest.dao;

import com.rest.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class PatientDao {
    private static final String QUERY_INSERT = "insert into patients (firstName, patientName, lastName, birthDate, snils) values (?,?,?,?,?)";

    @Autowired
    private DataSource dataSource;
    public Patient createPatient(Patient patient) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT, new String[]{"id"});
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setTimestamp(4, new Timestamp(patient.getBirthDate().getTime()));
            preparedStatement.setString(5, patient.getSnils());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                patient.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return patient;
    }
}
