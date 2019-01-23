package addressbook.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGroupDelition extends TestBase
{
    @Before()
    public void preconditions()
    {
        app.getGroupHelper().openGroupsPage();
        if(!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
    }

    @Test
    public void testGroupDelition()
    {
        app.getGroupHelper().openGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after= app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before-1);
    }

}
