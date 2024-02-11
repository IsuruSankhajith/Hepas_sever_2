import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseInfoRepository {
    public CourseInfo getCourseInfoByCourseCode(String courseCode) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CourseInfo courseInfo = null;
        try {
            connection = new DBConnection().getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM course_info WHERE course_code=?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, courseCode);
                System.out.println(ps.toString());
                rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    courseInfo = new CourseInfo();
                    courseInfo.setCourseCode(rs.getString("course_code"));
                    courseInfo.setCourseTitle(rs.getString("course_title"));
                    courseInfo.setCourseCoordinatorName(rs.getString("course_coordinator_name"));
                    courseInfo.setCourseCoordinatorEmail(rs.getString("course_coordinator_email"));
                    courseInfo.setCourseCoordinatorMobilePhone(rs.getString("course_coordinator_mobile_phone"));
                    courseInfo.setYearStartOffer(rs.getInt("year_start_offer"));
                    courseInfo.setYearEndOffer(rs.getInt("year_end_offer"));
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
        return courseInfo;
    }
}
