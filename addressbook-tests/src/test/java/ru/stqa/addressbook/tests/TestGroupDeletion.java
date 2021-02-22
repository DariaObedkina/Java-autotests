package ru.stqa.addressbook.tests;


import org.junit.*;
import ru.stqa.addressbook.model.GroupData;

import java.util.List;


public class TestGroupDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    ensurePreconditions();
    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(index);
      Assert.assertEquals(before,after);

  }

  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

}
