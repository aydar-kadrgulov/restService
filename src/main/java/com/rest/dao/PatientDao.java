package com.rest.dao;

import com.rest.entities.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String QUERY_INSERT = "insert into patients (firstName, patientName, lastName, gender, birthDate, snils) values (?,?,?,?,?,?)";
    private static final String QUERY_UPDATE = "update patients set firstName=?, patientName=?, lastName=?, gender=?, birthDate=?, snils=? where id = ?";
    private static final String QUERY_DELETE = "delete from patients WHERE snils = ?";
    private static final String QUERY_GET_PATIENTS = "select * from patients";
    private static final String QUERY_GET_PATIENTS_BY_SNILS = "select * from patients where snils = ?";
    private static final java.lang.String QUERY_GET_PATIENTS_BY_ID = "select * from patients where id = ?";

    @Autowired
    private DataSource dataSource;
    public Patient createPatient(Patient patient) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT, new String[]{"id"});
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setBoolean(4, patient.getGender().equals(Patient.Gender.MALE));
            preparedStatement.setTimestamp(5, new Timestamp(patient.getBirthDate().getTime()));
            preparedStatement.setString(6, patient.getSnils());
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

    public List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PATIENTS);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Patient patient = getPatientFromResultSet(resultSet);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public Patient getPatientBySnils(String snils) {
        Patient patient = new Patient();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PATIENTS_BY_SNILS, new String[]{snils});
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                patient = getPatientFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    private Patient getPatientFromResultSet (ResultSet resultSet) throws SQLException {
        Patient patient = new Patient();
        patient.setId(resultSet.getLong("id"));
        patient.setFirstName(resultSet.getString("firstName"));
        patient.setName(resultSet.getString("patientName"));
        patient.setLastName(resultSet.getString("lastName"));
        patient.setBirthDate(resultSet.getDate("birthDate"));
        patient.setGender(resultSet.getBoolean("gender")? Patient.Gender.MALE : Patient.Gender.FEMALE);
        patient.setSnils(resultSet.getString("snils"));
        return patient;
    }

    public Patient getPatientById(long id) {
        logger.info("get patient with id : " + id);
        Patient patient = new Patient();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PATIENTS_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                patient = getPatientFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public void updatePatient(Patient patient) {
        try {

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setBoolean(4, patient.getGender().equals(Patient.Gender.MALE));
            preparedStatement.setTimestamp(5, new Timestamp(patient.getBirthDate().getTime()));
            preparedStatement.setString(6, patient.getSnils());
            preparedStatement.setLong(7, patient.getId());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePatientBySnils(String snils) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setString(1, snils);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
