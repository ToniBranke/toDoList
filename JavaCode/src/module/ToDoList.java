package module;

import java.util.LinkedHashMap;
import java.util.Map;
import Actions.*;
import Sorting.*;
import Saving.*;

public class ToDoList
{
    public static Map<String, ToDoItem> tasks = new LinkedHashMap<>();
    public boolean applicationRunning = true;

    public void start()
    {
        showApplicationTitle();
        while(ToDoList.applicationRunning)
        {
            showAvailableActions();
            int actionNumber = readAction();
            executeAction(actionNumber);
        }

    }
    public void executeAction(int action)
    {

    }
    public void showApplicationTitle()
    {

    }
    public void showApplicationActions()
    {

    }
    public int readAction()
    {
        return 0;
    }
}
