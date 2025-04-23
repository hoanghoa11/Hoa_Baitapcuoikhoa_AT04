package Testcase;

import Page.BrandPage;
import Page.DashboardPage;
import Page.LoginPage;
import com.hoa.constants.ConfigData;
import com.hoa.helpers.CaptureHelper;
import com.hoa.helpers.ExcelHelper;
import com.hoa.keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    BrandPage brandPage;
    @Test(priority = 1)
    public void testAddBrand_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/data.xlsx", "Brand");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        WebUI.waitForPageLoaded();
        CaptureHelper.captureScreenshot("Brand screen");//chụp ảnh màn hình Brand
        brandPage.verifyRedirectBrandPageSuccess();
        brandPage.inputDataBrand(excelHelper.getCellData("Name Brand", 1),
                excelHelper.getCellData("Title Brand", 1),
                excelHelper.getCellData("Description Brand", 1));
        brandPage.verify_AddBrand_Success();
    }

    @Test(priority = 2)
    public void testEditBrand_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/data.xlsx", "Brand");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();

        brandPage.searchBrand(excelHelper.getCellData("Name Brand", 1));
//        DriverManager.getDriver().findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
      WebUI.sleep(1);

        brandPage.editBrand();
        brandPage.editDataBrand(excelHelper.getCellData("Name Brand", 2),
                excelHelper.getCellData("Title Brand", 2),
                excelHelper.getCellData("Description Brand", 2));
        brandPage.verify_EditBrand_Success();
        brandPage.clickMenuDashboard();
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.searchBrand(excelHelper.getCellData("Name Brand", 2));
        WebUI.sleep(1);
    }
    @Test(priority = 3)
    public void testDeleteBrand_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/data.xlsx", "Brand");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();
        brandPage.searchBrand(excelHelper.getCellData("Name Brand", 2));
        WebUI.sleep(1);
        brandPage.deleteBrand();
        brandPage.verify_DeleteBrand_Success();
    }
}
