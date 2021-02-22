package ru.stqa.addressbook.tests;


import org.junit.*;
import ru.stqa.addressbook.model.GroupData;

import java.util.Set;


public class TestGroupDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    ensurePreconditions();
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedGroup);
      Assert.assertEquals(before,after);

  }

  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

}
