package ru.stqa.addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class TestContactCreation extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> contactsBefore = app.getContactHelper().getContactList();
        app.goTo().gotoAddnewPage();
        ContactData contact = new ContactData("TestName","TestLastName","TestNick","TestAddress","123456789", "test@test.test");
        app.getContactHelper().createContact(contact);
        app.goTo().returnToHomePage();
        List<ContactData> contactsAfter = app.getContactHelper().getContactList();
        Assert.assertEquals(contactsBefore.size(),contactsAfter.size()-1);

        contactsBefore.add(contact);
        Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        Assert.assertEquals(contactsBefore, contactsAfter);


    }
}
