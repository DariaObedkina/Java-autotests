package ru.stqa.addressbook.tests;

import org.junit.Test;
import ru.stqa.addressbook.model.ContactData;

public class TestContactCreation extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddnewPage();
        app.getContactHelper().fillContactForm(new ContactData("TestName","TestLastName","TestNick","TestAddress","123456789", "test@test.test"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }
}
