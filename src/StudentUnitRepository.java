import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentUnitRepository {
    public List<StudentUnit> getStudentUnitByPersonId(Integer personId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<StudentUnit> studentUnitList = new ArrayList<>();
        try {
            connection = new DBConnection().getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM student_unit WHERE person_id=?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, personId);
                rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    StudentUnit studentUnit = new StudentUnit();
                    studentUnit.setPersonId(rs.getInt("person_id"));
                    studentUnit.setUnitCode(rs.getString("unit_code"));
                    studentUnit.setUnitTitle(rs.getString("unit_title"));
                    studentUnit.setResultScore(rs.getDouble("result_score"));
                    studentUnit.setResultGrade(rs.getString("result_grade"));
                    studentUnit.setYearAttemped(rs.getInt("year_attemped"));
                    studentUnit.setSemesterAttemped(rs.getInt("semester_attemped"));
                    studentUnit.setNotes(rs.getString("notes"));
                    studentUnitList.add(studentUnit);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {

                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {

                }
            }
        }
        return studentUnitList;
    }
}
