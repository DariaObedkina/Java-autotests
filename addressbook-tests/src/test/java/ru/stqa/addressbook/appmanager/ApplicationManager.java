package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
      driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    private void login(String username, String password) {
      driver.get("https://localhost/addressbook/#");
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void gotoGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    public void deleteSelectedGroups() {
      driver.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
    }

    public void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
    }
}
