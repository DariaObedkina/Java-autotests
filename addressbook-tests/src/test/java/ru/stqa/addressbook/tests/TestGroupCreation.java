package ru.stqa.addressbook.tests;

import org.junit.*;
import ru.stqa.addressbook.model.GroupData;

import java.util.Set;

public class TestGroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group  = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size()+1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }

}
