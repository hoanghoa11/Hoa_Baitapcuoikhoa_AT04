package Testcase;

import Page.*;
import com.hoa.keywords.WebUI;
import com.hoa.utils.LogUtils;
import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CategoryPage categoryPage;
    BrandPage brandPage;

    @Test
    public void testOpenAddProductPage() {
        loginPage = new LoginPage();
       dashboardPage= loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddProductPageSuccess();
    }

    @Test
    public void testOpenCategoryPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        categoryPage = dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();
    }
    @Test
    public void testOpenBrandPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();
    }

    @Test
    public void logout() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage = dashboardPage.clickLogout();
        loginPage.verifyRedirectLoginPage();
    }
}
