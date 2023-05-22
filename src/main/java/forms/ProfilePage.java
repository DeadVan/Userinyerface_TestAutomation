package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementFactory;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.CheckBox;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static Utils.SettingsReader.readJsonInt;
import static aquality.selenium.browser.AqualityServices.getLogger;

public class ProfilePage extends Form {
    public ProfilePage() {
        super(By.xpath("//div[contains(@class,'avatar-and-interests__form')]"), "avatar-and-interests__form");
    }

    private final IButton uploadButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'avatar-and-interests__upload-button')]"), "upload");
    private final ICheckBox unselectAll = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']//span[@class='checkbox__box']"), "Unselect All");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//button[normalize-space()='Next']"),"Next Button");

    ITextBox interestsContainer = AqualityServices.getElementFactory().getTextBox(By.className("avatar-and-interests"), "Interests Container");






    public void uploadPicture(final String filepath) {
        uploadButton.click();
        File file = new File(filepath);
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            getLogger().info(e.getMessage());
        }

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(readJsonInt("delay"));

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        robot.delay(readJsonInt("delay"));

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(readJsonInt("delay"));

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(readJsonInt("delay"));
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void checkUnselectAll() {
        unselectAll.check();
    }
public void selectRandomCheckboxes(int numCheckboxes) {
        List<ICheckBox> checkBoxes = interestsContainer.findChildElements(By.className("checkbox__label"), ElementType.CHECKBOX);
        Collections.shuffle(checkBoxes);
    for (int i = 0; i < numCheckboxes && i < checkBoxes.size(); i++) {
        checkBoxes.get(i).state().waitForDisplayed();
        checkBoxes.get(i).check();
    }
}

    public void clickNextBtn(){
        nextBtn.click();
    }

}
