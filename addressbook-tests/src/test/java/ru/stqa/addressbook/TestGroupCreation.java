package ru.stqa.addressbook;

import org.junit.*;

public class TestGroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test", "testH", "testF"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
