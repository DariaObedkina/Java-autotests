package ru.stqa.addressbook;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      login("admin", "secret");
    }

    protected void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
      driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    private void login(String username, String password) {
      driver.get("https://localhost/addressbook/#");
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void gotoGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    @After
    public void tearDown() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
    }
}
