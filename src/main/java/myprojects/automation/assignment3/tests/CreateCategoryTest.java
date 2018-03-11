package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.pages.AddNewCategoryPage;
import myprojects.automation.assignment3.pages.CategoriesPage;
import myprojects.automation.assignment3.pages.DashboardPage;
import myprojects.automation.assignment3.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) {
        // TODO prepare driver object
        // WebDriver driver = getConfiguredDriver();
        // ...
        WebDriver driver = getConfiguredDriver();

        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillInEmail();
        loginPage.fillInPassword();
        loginPage.clickOnLoginButton();

        // create category
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.selectCategoriesMenuItem();

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickOnAddCategoryButton();

        AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
        addNewCategoryPage.fillInName();
//        addNewCategoryPage.fillInLinkRewrite();
        addNewCategoryPage.clickOnSaveButton();

        // check that new category appears in CategoriesPage table
        categoriesPage.checkIfCategoryCreatedSuccessfully();
        categoriesPage.sortCategoriesByNameAsc();
        categoriesPage.checkCreatedCategoryPresence();

        // finish script
        dashboardPage.clickOnUserIcon();
        dashboardPage.clickOnExitButton();

        quiteDriver(driver);
    }
}
