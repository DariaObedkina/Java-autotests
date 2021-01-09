package ru.stqa.addressbook.tests;

import org.junit.*;
import ru.stqa.addressbook.model.GroupData;

public class TestGroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test", "test", "test"));
  }

}
