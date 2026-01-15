import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentDB {


    public void addStudent(Student s) {
// program should not be crush
        try {
            Connection conn = DBConn.getConnection();
            String query = "INSERT into StudentSystem(id ,sname, semail) VALUES(?,?,?)";

            PreparedStatement psm = conn.prepareStatement(query);

            psm.setInt(1, s.getId());
            psm.setString(2, s.getSname());
            psm.setString(3, s.getSemail());
            psm.executeUpdate();
            System.out.println("Data is successfully added");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void updateStudent(int id, String newName, String newEmail) {

        try {
            Connection conn = DBConn.getConnection();
            String query = "UPDATE StudentSystem SET sname=?, semail=? where id=?";

            PreparedStatement psm = conn.prepareStatement(query);

            psm.setString(1, newName);
            psm.setString(2, newEmail);
            psm.setInt(3, id);
            int row = psm.executeUpdate();
            if (row == 0) {
                System.out.println("student is not found");
            }
            System.out.println("Data is successfully added");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void studentDelete(int id) {

        try {
            Connection conn = DBConn.getConnection();
            String query = "DELETE FROM StudentSystem WHERE id = ?";
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setInt(1, id);
            int row = psm.executeUpdate();
            if (row == 0) {
                System.out.println("student is not found");
            }
            System.out.println("Student is successfully delete");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Student getStudent(int id) throws Exception {
        String query = "SELECT * FROM StudentSystem WHERE id = ?";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("sname"), rs.getString("semail"));
            } else {
                throw new Exception("Student not found.");
            }
        }
    }


    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM StudentSystem";
        try (Connection conn = DBConn.getConnection();
             Statement sm = conn.createStatement()) {

            ResultSet rs = sm.executeQuery(query);
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("sname"),
                        rs.getString("semail")));
            } if(list.isEmpty()) {
                throw new Exception("Student not found.");
            }
        }
        return list;
    }
}