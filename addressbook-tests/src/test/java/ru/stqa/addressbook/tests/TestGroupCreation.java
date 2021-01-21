package ru.stqa.addressbook.tests;

import org.junit.*;
import ru.stqa.addressbook.model.GroupData;

public class TestGroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test", "test", "test"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
  }

}
