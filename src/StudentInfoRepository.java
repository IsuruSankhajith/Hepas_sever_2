import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class StudentInfoRepository {

    public Optional<StudentInfo> getStudentInfoByPersonId(Integer personId, String firstName, String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = new DBConnection().getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM student_info WHERE person_id=? AND first_name=? AND email=?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, personId);
                ps.setString(2, firstName);
                ps.setString(3, email);
                rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    StudentInfo studentInfo = new StudentInfo();
                    studentInfo.setPersonId(rs.getInt("person_id"));
                    studentInfo.setCourseCode(rs.getString("course_code"));
                    studentInfo.setFirstName(rs.getString("first_name"));
                    studentInfo.setLastName(rs.getString("last_name"));
                    studentInfo.setEmail(rs.getString("email"));
                    studentInfo.setMobileNumber(rs.getString("mobile_number"));
                    studentInfo.setUnitAttempted(rs.getInt("unit_attempted"));
                    studentInfo.setUnitCompleted(rs.getInt("unit_completed"));
                    studentInfo.setCourseStatus(rs.getString("course_status"));
                    return Optional.of(studentInfo);
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
        return Optional.empty();
    }

}
