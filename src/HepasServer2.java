import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HepasServer2 {
    public static void main(String[] args) {
        try {
            // Create and start the RMI registry
            LocateRegistry.createRegistry(1000);
            StudentInfoService studentInfoService = new StudentInfoServiceImpl(
                    new StudentInfoRepository(),
                    new CourseInfoRepository(),
                    new StudentUnitRepository()
            );
            String serverURL = "rmi://localhost:1000/HonorsEvaluatorDB";
            Naming.rebind(serverURL, studentInfoService);
            System.out.println("Hepas Server 02 is ready");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}