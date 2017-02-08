package com.rest.dao;

import com.rest.entities.Vaccination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class VaccinationDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String QUERY_INSERT = "insert into vaccinations (drugName, eventDate, patient_id) values (?,?,?)";
    private static final String QUERY_UPDATE = "update patients set firstName=?, patientName=?, lastName=?, gender=?, birthDate=?, snils=? where id = ?";
    private static final String QUERY_DELETE = "delete from patients WHERE snils = ?";
    private static final String QUERY_GET_PATIENTS = "select * from patients";
    private static final String QUERY_GET_PATIENTS_BY_SNILS = "select * from patients where snils = ?";
    private static final java.lang.String QUERY_GET_PATIENTS_BY_ID = "select * from patients where id = ?";


    @Autowired
    private DataSource dataSource;

    public Vaccination createVaccination(Vaccination vaccination) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT, new String[]{"id"});
            preparedStatement.setString(1, vaccination.getDrugName());
            preparedStatement.setTimestamp(2, new Timestamp(vaccination.getDate().getTime()));
            preparedStatement.setLong(3, vaccination.getPatientId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                vaccination.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaccination;
    }
}
