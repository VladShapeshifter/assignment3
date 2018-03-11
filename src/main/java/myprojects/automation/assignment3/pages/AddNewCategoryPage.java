package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class AddNewCategoryPage {
    private WebDriver driver;

    private By nameField = By.id("name_1");
    private By linkRewriteField = By.id("link_rewrite_1");
    private By saveButton = By.id("category_form_submit_btn");

    private static Random random = new Random();
    private static int getRandomNumber() {
        return random.nextInt();
    }

    private static String name = "Test Category Number " + getRandomNumber();
    private String linkRewrite = name.toLowerCase();

    public AddNewCategoryPage(WebDriver driver) {
        this.driver = driver;
    }



    public void fillInName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillInLinkRewrite() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkRewriteField));
        driver.findElement(linkRewriteField).sendKeys(linkRewrite);
    }

    public void clickOnSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
    }

    public static String getName() {
        return name;
    }
}
