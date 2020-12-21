package ru.stqa.addressbook.tests;

import org.junit.*;
import ru.stqa.addressbook.model.GroupData;

public class TestGroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test", "testH", "testF"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
