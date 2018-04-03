package StudentsLaboratoriesMV;

import controller.LaboratoriesController;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.Student;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void addSuccessfull() {
        LaboratoriesController controller = new LaboratoriesController("students.txt", "laboratories.txt");
        Student student = new Student("mmie1941", "denis crudu", 932);
        Boolean success = controller.saveStudent(student);
        //assertEquals(success, true);
        assertTrue(success);
        controller.saveStudent(student);
    }

    public void addUnsuccessfull() {
        LaboratoriesController controller = new LaboratoriesController("students.txt", "laboratories.txt");
        Student student = new Student("26", "denis crudu", 932);
        Boolean success = controller.saveStudent(student);

        assertTrue(success);
    }
}
