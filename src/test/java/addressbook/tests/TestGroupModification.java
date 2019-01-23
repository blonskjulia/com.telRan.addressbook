package addressbook.tests;

import addressbook.model.Group;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGroupModification extends TestBase
{
    @Before
    public void preconditions()
    {
        app.getGroupHelper().openGroupsPage();
        if(!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
    }
    @Test
    public void testGroupModification()
    {
        app.getGroupHelper().openGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("modifyed")
                .setGroupHeader("new")
                .setGroupFooter("space"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        int after= app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before);
    }

}

