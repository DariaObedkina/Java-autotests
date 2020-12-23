package ru.stqa.addressbook.tests;

import org.junit.Test;

public class TestContactDeletion extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptContactAlert();
    }
}
