package ru.stqa.addressbook.tests;

import org.junit.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

public class TestContactDeletion extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddnewPage();
            app.getContactHelper().createContact(new ContactData("TestName","TestLastName","TestNick","TestAddress","123456789", "test@test.test"));
            app.getNavigationHelper().returnToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptContactAlert();
    }
}
