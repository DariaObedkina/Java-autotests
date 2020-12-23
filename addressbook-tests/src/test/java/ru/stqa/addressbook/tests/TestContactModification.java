package ru.stqa.addressbook.tests;

import org.junit.Test;
import ru.stqa.addressbook.model.ContactData;

public class TestContactModification extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("TestNameChanged","TestLastNameChanged","TestNick","TestAddress","12345678910", "test@test.test"));
        app.getContactHelper().submitContactModification();
    }
}
