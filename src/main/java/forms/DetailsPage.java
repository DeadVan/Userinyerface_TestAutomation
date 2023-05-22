package forms;


import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DetailsPage extends Form {
    public DetailsPage() {
        super(By.xpath("//div[contains(@class,'personal-details__form')]"), "personal-details form");
    }

}
