package controller;

import junit.framework.TestCase;
import model.Laboratory;
import model.Student;
import repository.FileDataPersistence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 23.03.2018.
 */
public class LaboratoriesControllerTest extends TestCase {

    LaboratoriesController ctrl;
    public void setUp() throws Exception {
        super.setUp();
        ctrl=new LaboratoriesController("testStudents.txt", "testLaboratories.txt");

    }

    public void tearDown() throws Exception {
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

    public void testSaveStudent4() throws Exception {

        //name(length!=2)
        Student s4=new Student("aaaa3333","Arimie ",3);
        boolean r4=ctrl.saveStudent(s4);
        assertEquals(r4,false);

    }

    public void testSaveStudent5() throws Exception {

        //regNr empty
        Student s5=new Student("","Arimie ",3);
        boolean r5=ctrl.saveStudent(s5);
        assertEquals(r5,false);


    }


    public void testSaveStudent() throws Exception {

        //adding an existing student
        Student s1=new Student("aaaa1111","Arimie Andreea",932);
        boolean r1=ctrl.saveStudent(s1);
        assertEquals(r1,true);

        //group
        Student s2=new Student("aaaa223","Arimie Andreea",1090);
        boolean r2=ctrl.saveStudent(s2);
        assertEquals(r2,false);

        //regNr
        Student s3=new Student("aaaa223","Arimie Andreea",3);
        boolean r3=ctrl.saveStudent(s3);
        assertEquals(r3,false);

        //name(length!=2)
        Student s4=new Student("aaaa3333","Arimie ",3);
        boolean r4=ctrl.saveStudent(s4);
        assertEquals(r4,false);

        //regNr empty
        Student s5=new Student("aj99","Arimie ",3);
        boolean r5=ctrl.saveStudent(s5);
        assertEquals(r5,false);


    }

    public void testSaveLaboratory() throws Exception {
        Laboratory l1=new Laboratory(4, "29/03/2018" ,4 ,"nnop1998");
        boolean r1=ctrl.saveLaboratory(l1);
        assertEquals(r1,false);

        //date
        Laboratory l2=new Laboratory(5, "29/03/2017" ,4 ,"nnop1998");
        boolean r2=ctrl.saveLaboratory(l2);
        assertEquals(r2,false);

        //nrLab<1
        Laboratory l3=new Laboratory(-5, "29/03/2018" ,4 ,"nnop1998");
        boolean r3=ctrl.saveLaboratory(l3);
        assertEquals(r3,false);

        //pbnr
        Laboratory l4=new Laboratory(5, "29/03/2018" ,19 ,"nnop1998");
        boolean r4=ctrl.saveLaboratory(l4);
        assertEquals(r4,false);

    }

    public void testAddGrade() throws Exception {

    }

    public void testPassedStudents() throws Exception {
        List<Student> passedStudents=new ArrayList<Student>();
        passedStudents=ctrl.passedStudents();
        Student s1=new Student("yyyy9999","Vancea Vlad",989);
        Student s2=new Student("aaie1856","as nb",932);
        Student s3=new Student("asdf1234","as we",932);
        Student s4=new Student("nnop1998","Monica Iovan",945);
        Student s5=new Student("nnop0000","Monica Der",930);


        //student having grade<5
        boolean r1=passedStudents.contains(s1);
        assertEquals(r1,false);

        boolean r2=passedStudents.contains(s2);
        assertEquals(r2,true);

        boolean r3=passedStudents.contains(s3);
        assertEquals(r3,true);

        //when student has not participated to the lab=>false
        boolean r4=passedStudents.contains(s4);
        assertEquals(r4,false);

        //when student is not in our database
        boolean r5=passedStudents.contains(s5);
        assertEquals(r4,false);

    }

}