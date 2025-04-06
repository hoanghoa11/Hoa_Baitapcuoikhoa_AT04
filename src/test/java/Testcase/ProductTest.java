package Testcase;

import Page.DashboardPage;
import Page.LoginPage;
import Page.ProductPage;
import com.hoa.constants.ConfigData;
import com.hoa.helpers.ExcelHelper;
import com.hoa.keywords.WebUI;
import common.BaseTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    @Test
    public void testAddNewProduct_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Product");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddProductPageSuccess();
        productPage.inputDataProduct(excelHelper.getCellData("Product Name", 1),
                excelHelper.getCellData("Category Name", 1),
                excelHelper.getCellData("Brand Name", 1),
                excelHelper.getCellData("Unit", 1),
                excelHelper.getCellData("Weight", 1),
                excelHelper.getCellData("Purchase", 1),
                excelHelper.getCellData("Tag", 1),
                excelHelper.getCellData("Unit Price", 1),
                excelHelper.getCellData("Discount", 1),
                excelHelper.getCellData("Quantity", 1));
        productPage.verifyAddProductSuccess();
       //  productPage.clickButtonAllProducts();
        //search lại sp vừa tạo
        productPage.searchProduct(excelHelper.getCellData("Product Name", 1));
        //vào màn product detail user
        productPage.clickIconViewProductDetail();
        WebUI.sleep(1);
        productPage.userViewProductDetails(excelHelper.getCellData("Product Name", 1));
    }


    @Test
    public void testEditProduct_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Product");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();

        productPage.searchProduct(excelHelper.getCellData("Product Name", 1));
        WebUI.sleep(1);
        productPage.clickButtonEditProducts();
        productPage.editProduct(excelHelper.getCellData("Product Name", 2),
                excelHelper.getCellData("Category Name", 2),
                excelHelper.getCellData("Brand Name", 2),
                excelHelper.getCellData("Unit", 2),
                excelHelper.getCellData("Weight", 2),
                excelHelper.getCellData("Purchase", 2),
                excelHelper.getCellData("Tag", 2),
                excelHelper.getCellData("Unit Price", 2),
                excelHelper.getCellData("Discount", 2),
                excelHelper.getCellData("Quantity", 2));
        productPage.verifyEditProductSuccess();
    }

    @Test
    public void testDeleteProduct_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Product");
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();

        productPage.searchProduct(excelHelper.getCellData("Product Name", 1));
        productPage.clickButtonDeleteProduct();
        productPage.verifyDeleteProductSuccess();
        // research lại tên sp cua delete
        productPage.researchProduct(excelHelper.getCellData("Product Name", 2));
    }

    @Test
    public void testCheckDataOnProductTable() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.searchProduct("K");
        productPage.checkSearchTableByColumn(2, "K"); // so sanh chứa
    }

}
