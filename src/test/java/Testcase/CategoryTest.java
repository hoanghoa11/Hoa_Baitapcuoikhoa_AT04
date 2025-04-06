package Testcase;

import Page.CategoryPage;
import Page.DashboardPage;
import Page.LoginPage;
import com.hoa.constants.ConfigData;
import com.hoa.helpers.CaptureHelper;
import com.hoa.helpers.ExcelHelper;
import com.hoa.keywords.WebUI;
import common.BaseTest;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;

    @Test
    public void testAddCategory_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Category");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage = dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonAddNew();
        categoryPage.inputDataCategory(excelHelper.getCellData("Category Name", 1),
                excelHelper.getCellData("ParentCategory", 1),
                excelHelper.getCellData("OrderingNumber", 1),
                excelHelper.getCellData("Title", 1),
                excelHelper.getCellData("Description", 1));
        categoryPage.verifyAddCategorySuccess();
        categoryPage.searchCategory(excelHelper.getCellData("Category Name", 1));
        CaptureHelper.captureScreenshot("testAddCategory_Success");
    }

    @Test
    public void testEditCategory_Success(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Category");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();
        WebUI.sleep(2);
        categoryPage.clickButtonEditCategory();
        categoryPage.inputEditDataCategory(excelHelper.getCellData("Category Name", 2),
                excelHelper.getCellData("ParentCategory", 2),
                excelHelper.getCellData("OrderingNumber", 2),
                excelHelper.getCellData("Title", 2),
                excelHelper.getCellData("Description", 2));
        categoryPage.verifyEditCategorySuccess();
        categoryPage.clickMenuDashboard();
        dashboardPage.clickMenuCategory();
        categoryPage.searchCategory(excelHelper.getCellData("Category Name", 2));
    }
    @Test
    public void testDeleteCategory_Success(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Category");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();
        categoryPage.searchCategory(excelHelper.getCellData("Category Name", 2));
        WebUI.sleep(2);
        categoryPage.clickButtonDelete();
        categoryPage.verifyDeleteCategory_Success();
        categoryPage.searchCategory(excelHelper.getCellData("Category Name", 2));
    }
}
