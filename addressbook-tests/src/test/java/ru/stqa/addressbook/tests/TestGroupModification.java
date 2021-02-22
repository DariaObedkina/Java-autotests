package ru.stqa.addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.addressbook.model.GroupData;
import java.util.Set;

public class TestGroupModification extends TestBase {

    @Test
    public void testGroupModification() throws Exception {
        ensurePreconditions();
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test").withHeader("test").withFooter("test");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size(),after.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);

    }

    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

}
