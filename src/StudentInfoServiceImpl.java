import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StudentInfoServiceImpl extends UnicastRemoteObject implements StudentInfoService {
    private final StudentInfoRepository studentInfoRepository;
    private final CourseInfoRepository courseInfoRepository;
    private final StudentUnitRepository studentUnitRepository;

    public StudentInfoServiceImpl(
            StudentInfoRepository studentInfoRepository,
            CourseInfoRepository courseInfoRepository,
            StudentUnitRepository studentUnitRepository) throws RemoteException {
        super();
        this.studentInfoRepository = studentInfoRepository;
        this.courseInfoRepository = courseInfoRepository;
        this.studentUnitRepository = studentUnitRepository;
    }

    @Override
    public StudentInfo getStudentInfoByPersonId(Integer personId, String firstName, String email) {
        return studentInfoRepository.getStudentInfoByPersonId(personId, firstName, email)
                .map(studentInfo -> {
                    CourseInfo courseInfo = courseInfoRepository.getCourseInfoByCourseCode(studentInfo.getCourseCode());
                    List<StudentUnit> studentUnitList = studentUnitRepository.getStudentUnitByPersonId(personId);
                    studentInfo.setCourseInfo(courseInfo);
                    studentInfo.setStudentUnits(studentUnitList);
                    return studentInfo;
                }).get();
    }
}
