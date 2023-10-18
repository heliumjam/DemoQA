import manager.HelperStudent;
import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentFormTests extends TestBase implements HelperStudent {

    @BeforeMethod
    public void preconditions(){

        selectForms();
        selectPracticeForm();
    }

    @Test
    public void fillStudentFormPositive(){

        List<Hobby> hobby = new ArrayList<>();
        hobby.add(Hobby.MUSIC);
        hobby.add(Hobby.READING);


        StudentDTO studentDTO = StudentDTO.builder()
                .firstName("Jack")
                .lastName("Bee")
                .email("jjbbbb@tteeest.com")
                .gender(Gender.MALE)
                .phone("12345677777")
                .birthday("4 01 1934")
                .subjects("Maths,Physics")
                .hobby(hobby)
                .address("Street, 10")
                .state("NCR")
                .city("Delhi")
                .build();

        hideFooter();
        hideDiv();
        fillForm(studentDTO);
        submit();

    }


}
