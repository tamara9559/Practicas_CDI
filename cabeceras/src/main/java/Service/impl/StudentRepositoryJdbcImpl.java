package Service.impl;

import Model.Student;
import Service.Repository;
import mapping.StudentMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJdbcImpl implements Repository<Student> {
    private Connection conn;
    public StudentRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<Student> list() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT s.* order by s.id ASC")) {
            while (rs.next()) {
                Student ps= getStudent(rs);
                students.add(s);
            }
        }
        return StudentMapper.mapFrom(Students);
    }

}

