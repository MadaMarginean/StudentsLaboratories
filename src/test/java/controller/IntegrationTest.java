package controller;

import junit.framework.TestCase;
import model.Student;

public class IntegrationTest extends TestCase {
    LaboratoriesController ctrl;

    public void setUp() throws Exception {
        super.setUp();
        ctrl=new LaboratoriesController("testStudents.txt", "testLaboratories.txt");

    }

    public void testSaveStudent1() throws Exception {

        //adding an existing student
        Student s1 = new Student("aaaa1111", "Arimie Andreea", 932);
        boolean r1 = ctrl.saveStudent(s1);
        assertEquals(r1, false);
    }


    public void testSaveStudent2() throws Exception {

        //group
        Student s2=new Student("aaaa2222","Arimie Andreea",1090);
        boolean r2=ctrl.saveStudent(s2);
        assertEquals(r2,false);
    }

    public void testSaveStudent3() throws Exception {

        //regNr
        Student s3=new Student("aaaa222","Arimie Andreea",3);
        boolean r3=ctrl.saveStudent(s3);
        assertEquals(r3,false);

    }

    public void unitTestA() throws Exception {
        this.testSaveStudent1();
    }

    public void integrationTestB() throws Exception {
        this.testSaveStudent1();
        this.testSaveStudent2();
    }

    public void integrationTestC() throws Exception {
        this.testSaveStudent1();
        this.testSaveStudent2();
        this.testSaveStudent3();
    }
}
