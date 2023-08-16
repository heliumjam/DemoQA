package manager;

import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;

public interface HelperStudent extends HelperBase{

    default void selectForms(){
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }
    default void selectPracticeForm(){
        click(By.xpath("//span[normalize-space()='Practice Form']"));
    }

    default void fillForm(StudentDTO studentDTO){
        type(By.id("firstName"), studentDTO.getFirstName());
        type(By.id("lastName"), studentDTO.getLastName());
        type(By.id("userEmail"), studentDTO.getEmail());
        click(By.id("userEmail-label"));
        selectGender(studentDTO.getGender());
        type(By.id("userNumber"), studentDTO.getPhone());
        type(By.id("dateOfBirthInput"), studentDTO.getBirthday());
       click(By.id("userEmail-label"));
        addSubject(studentDTO.getSubjects());
        selectHobby(studentDTO.getHobby());
        
        type(By.id("currentAddress"), studentDTO.getAddress());
        typeState(studentDTO.getState());
        typeCity(studentDTO.getCity());
    }

    default void typeBDay(String birthday){
    }

    default void selectGender(Gender gender){
        JavascriptExecutor js = (JavascriptExecutor) wd;


        if(gender.equals(Gender.MALE)){
            js.executeScript("document.querySelector(\"label[for='hobbies-checkbox-1']\").click();");
          //  click(By.id("gender-radio-1"));
           // click(By.xpath("//label[@for='hobbies-checkbox-1']"));
        } else if (gender.equals(Gender.FEMALE)){
            js.executeScript("document.querySelector(\"label[for='hobbies-checkbox-2']\").click();");
        } else {
            js.executeScript("document.querySelector(\"label[for='hobbies-checkbox-3']\").click();");
        }
    }

    default void addSubject(String subjects){
        String[] split = subjects.split(",");
        String locator = "subjectsInput";
        click(By.id(locator));
        for(String subject : split){
            wd.findElement(By.id(locator)).sendKeys(subject);
            wd.findElement(By.id(locator)).sendKeys(Keys.ENTER);
        }
    }

    default void selectHobby(List<Hobby> hobbies){

        for(Hobby hobby : hobbies){
            switch (hobby){
                case SPORTS:
                    click(By.id("hobbies-checkbox-1"));
                    break;
                case READING:
                    click(By.id("hobbies-checkbox-2"));
                    break;
                case MUSIC:
                    click(By.id("hobbies-checkbox-3"));
                    break;
            }
        }
    }

    default void typeState(String state){
        wd.findElement(By.id("react-select-3-input")).sendKeys(state);
        wd.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }
    default void typeCity(String city){
        wd.findElement(By.id("react-select-4-input")).sendKeys(city);
        wd.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    default void submit(){
        click(By.id("submit"));
    }
}
