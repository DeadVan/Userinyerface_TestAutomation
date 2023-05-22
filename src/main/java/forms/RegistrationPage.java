package forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Random;

public class RegistrationPage extends Form {
    public RegistrationPage() {
        super(By.xpath("//div[contains(@class,'page-indicator')]"), "login-form__container");
    }

    private final ITextBox password = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Choose Password')]"),"password");
    private final ITextBox emailFirtsHalf = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Your email')]"),"email firts half");
    private final ITextBox emailSecondHalf = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"),"email second half");
    private final IButton tearDownButton = getElementFactory().getButton(By.xpath("//span[contains(@class,'icon icon-chevron-down')]"),"list of domains");
    private final ICheckBox termsAndCondition = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox__box')]"),"terms and conditions");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'button--secondary')]"),"Next Button");
    private final IButton sendToBottom = getElementFactory().getButton(By.xpath("//span[contains(@class,'highlight')]"),"Send To Bottom");
    private final IButton heloBtn = getElementFactory().getButton(By.xpath("//a[contains(@class,'help-form__help-button')]"),"help form");
    private final ILabel coockiesText = getElementFactory().getLabel(By.xpath("//p[contains(@class,'cookies__message')]"),"coockies text");
    private final IButton acceptCoockies = getElementFactory().getButton(By.xpath("//button[contains(normalize-space(),'Not really, no')]"),"No, literaly no button");
    private final ILabel timer = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer timer--white timer--center')]"),"timer");


    public void acceptCoockies(){
        coockiesText.state().waitForDisplayed();
        acceptCoockies.click();
    }
    public boolean checkIfcoockiesTextDissapeared(){
        return coockiesText.state().waitForNotDisplayed();
    }

    public void clicksendToBottom(){
        sendToBottom.clickAndWait();
    }
    public boolean checkIfhelpFormDisappeared(){
        return heloBtn.state().waitForDisplayed();
    }
    public String checkTimer() {
        return timer.getText();
    }

    public RegistrationPage fillPasword(final String passwords){
        password.clearAndType(passwords);
        return this;
    }
    public RegistrationPage fillEmailFirtsHalf(final String emailFH){
        emailFirtsHalf.clearAndType(emailFH);
        return this;
    }
    public RegistrationPage fillEmailSecondsHalf(final String emailSH){
        emailSecondHalf.clearAndType(emailSH);
        return this;
    }
    public void clickTearDown()
    {
        tearDownButton.click();
    }
    public void chooseEmail() {
        List<ILabel> labels = getElementFactory().findElements(By.className("dropdown__list-item"), ElementType.LABEL);
        int index = new Random().nextInt(labels.size());
        labels.get(index).click();
    }
    public void checkTermsAndConditions(){
        termsAndCondition.check();
    }
    public void clickNextBtn()
    {
        nextButton.click();
    }

}
