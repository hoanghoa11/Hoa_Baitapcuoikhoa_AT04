package Page;

import com.hoa.keywords.WebUI;
import com.hoa.constants.ConfigData;
import com.hoa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CategoryPage {
//    private WebDriver driver;

    private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By headerCategory = By.xpath("//h1[normalize-space()='All categories']");
    private By inputSearchCategory = By.xpath("//input[@id='search']");
    private By headerAddNewCategory = By.xpath("//h5[normalize-space()='Category Information']");

    private By inputNameCategory = By.xpath("//input[@id='name']");
    private By dropdownParentCategory = By.xpath("(//div[@class='col-md-9'])[2]//div//button");
    private By searchParentCategory = By.xpath("(//input[@aria-label='Search'])[1]");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By dropdownTypeCategory = By.xpath("(//div[@class='col-md-9'])[4]//div//button");
    private By selectTypeCateGory = By.xpath("//li[@class='selected active']");
    private By chooseBannerImage = By.xpath("(//label[@for='signinSrEmail'])[1]/following-sibling::div//div[@class='input-group']");
    private By selectImage1 = By.xpath("//div[@title='pexels-photo-12334699.jpeg']");
    private By buttonAddFileImage =By.xpath("//button[normalize-space()='Add Files']");
    private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By dropdownFilterAttribute = By.xpath("(//div[@class='col-md-9'])[9]//div//button");
    private By dropdownEditFilterAttribute = By.xpath("(//div[@class='col-md-9'])[10]//div//button");
    private By selectValueFilterAttribute = By.xpath("//a[@id='bs-select-3-1']");
    private By buttonSaveCategory = By.xpath("//button[@type='submit']");

    private By messageSuccess = By.xpath("//span[@data-notify='message']");

    private By firstIconEditCategory = By.xpath("//tbody/tr[1]/td[10]/a[1]");
    private By messageEditSuccess = By.xpath("//span[@data-notify='message']");
    private By firstIconDeleteCategory = By.xpath("//tbody//tr[1]//td[10]//a[@title='Delete']");
    private By selectDeleteCategory = By.xpath("//a[@id='delete-link']");
    private By messageDeleteSuccess = By.xpath("//span[@data-notify='message']");
    private By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");

    public void clickMenuDashboard(){
        WebUI.clickElement(menuDashBoard);
    }

    public void verifyRedirectCategoryPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerCategory).isDisplayed(), "Không tìm thấy  header page");
        Assert.assertEquals(DriverManager.getDriver().findElement(headerCategory).getText(), "All categories", "Header màn Category không đúng");
    }

    public void clickButtonAddNew() {
        WebUI.clickElement(buttonAddNewCategory);
    }
    public void clickButtonEditCategory() {
        WebUI.clickElement(firstIconEditCategory);
    }

    public void clickButtonDelete() {
        WebUI.waitForElementVisible(firstIconDeleteCategory);
        WebUI.clickElement(firstIconDeleteCategory);
        WebUI.sleep(1);
        WebUI.clickElement(selectDeleteCategory);
        WebUI.waitForPageLoaded();
    }

    public void verifyRedirectAddCategoryPage() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerAddNewCategory).isDisplayed(), "Không tìm thấy  header page");
        Assert.assertEquals(DriverManager.getDriver().findElement(headerAddNewCategory).getText(), "Category Information", "Header màn Category không đúng");
    }

    public void inputDataCategory(String categoryName, String parentCategory, String orderingNumber, String title, String description ) {
        DriverManager.getDriver().findElement(inputNameCategory).clear();
        WebUI.setText(inputNameCategory,categoryName);

        WebUI.clickElement(dropdownParentCategory);
        WebUI.setText(searchParentCategory,parentCategory);
        WebUI.setKey(searchParentCategory, Keys.ENTER);

        WebUI.setText(inputOrderingNumber,orderingNumber);

        WebUI.clickElement(dropdownTypeCategory);
        WebUI.clickElement(selectTypeCateGory);

        WebUI.clickElement(chooseBannerImage);
//        WebUI.sleep(2);
        WebUI.waitForElementVisible(selectImage1);

        WebUI.clickElement(selectImage1);
        WebUI.clickElement(buttonAddFileImage);

        WebUI.setText(inputMetaTitle,title);
        WebUI.setText(inputMetaDescription,description);

        WebUI.clickElement(dropdownFilterAttribute);
        WebUI.clickElement(selectValueFilterAttribute);

        WebUI.clickElement(buttonSaveCategory);
    }

    public void inputEditDataCategory(String categoryName, String parentCategory, String orderingNumber, String title, String description ) {
        DriverManager.getDriver().findElement(inputNameCategory).clear();
        WebUI.setText(inputNameCategory,categoryName);

        WebUI.clickElement(dropdownParentCategory);
        WebUI.setText(searchParentCategory,parentCategory);
        WebUI.setKey(searchParentCategory, Keys.ENTER);

        DriverManager.getDriver().findElement(inputOrderingNumber).clear();
        WebUI.setText(inputOrderingNumber,orderingNumber);

        WebUI.clickElement(dropdownTypeCategory);
        WebUI.clickElement(selectTypeCateGory);

        WebUI.clickElement(chooseBannerImage);
        WebUI.waitForElementVisible(selectImage1);
        WebUI.clickElement(selectImage1);
        WebUI.clickElement(buttonAddFileImage);

        DriverManager.getDriver().findElement(inputMetaTitle).clear();
        WebUI.setText(inputMetaTitle,title);

        DriverManager.getDriver().findElement(inputMetaDescription).clear();
        WebUI.setText(inputMetaDescription,description);

        WebUI.clickElement(dropdownEditFilterAttribute);
        WebUI.clickElement(selectValueFilterAttribute);

        WebUI.clickElement(buttonSaveCategory);
    }

    public void verifyAddCategorySuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(messageSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageSuccess).getText(), "Category has been inserted successfully", "Nội dung message không chính xác");
    }

    public void searchCategory(String categoryName){
            WebUI.setText(inputSearchCategory, categoryName);
            WebUI.setKey(inputSearchCategory,Keys.ENTER);
            WebUI.sleep(1);
    }
    public void verifyEditCategorySuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(messageEditSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageEditSuccess).getText(), "Category has been updated successfully", "Nội dung message không chính xác");
    }

    public void verifyDeleteCategory_Success(){
        Assert.assertTrue(DriverManager.getDriver().findElement(messageDeleteSuccess).isDisplayed(), "Lỗi, Không xóa được category");
        Assert.assertEquals(DriverManager.getDriver().findElement(messageDeleteSuccess).getText(), "Category has been deleted successfully", "Nội dung message không chính xác");
    }
}
