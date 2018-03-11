package myprojects.automation.assignment3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {
    private WebDriver driver;

    private By addCategoryButton = By.id("page-header-desc-category-new_category");
    private By succsessfullNotification = By.cssSelector("div.alert.alert-success");
    private By sortCategoriesByNameAscButton = By.cssSelector("tr:nth-child(1) > th:nth-child(3) a:nth-child(1)");

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddCategoryButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(addCategoryButton));
        driver.findElement(addCategoryButton).click();
    }

    public void checkIfCategoryCreatedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(succsessfullNotification));
    }

    public void sortCategoriesByNameAsc() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(sortCategoriesByNameAscButton));
        driver.findElement(sortCategoriesByNameAscButton).click();
    }

    public void checkCreatedCategoryPresence() {
        driver.findElement(By.xpath("//*[contains(text(), '" + AddNewCategoryPage.getName() +"')]"));
    }
}
