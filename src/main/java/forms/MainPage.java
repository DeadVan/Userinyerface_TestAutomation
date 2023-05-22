package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    public MainPage() {
        super(By.xpath("//button[contains(@type,'button')]"), "NO Button");
    }

    private final IButton hereBtn = getElementFactory().getButton(By.xpath("//a[contains(@class,'start__link')]"),"hereBtn");


    public void clickHereBtn(){
        hereBtn.click();
    }

}
