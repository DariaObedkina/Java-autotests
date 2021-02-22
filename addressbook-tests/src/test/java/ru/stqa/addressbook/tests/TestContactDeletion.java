package ru.stqa.addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.List;

public class TestContactDeletion extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.goTo().gotoAddnewPage();
            app.getContactHelper().createContact(new ContactData("TestName","TestLastName","TestNick","TestAddress","123456789", "test@test.test"));
            app.goTo().returnToHomePage();
        }
        List<ContactData> contactsBefore = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(contactsBefore.size()-1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptContactAlert();
        app.goTo().waitForHomePage();
        List<ContactData> contactsAfter = app.getContactHelper().getContactList();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size()-1);

        contactsBefore.remove(contactsBefore.size()-1);
        Assert.assertEquals(contactsBefore,contactsAfter);
    }
}
