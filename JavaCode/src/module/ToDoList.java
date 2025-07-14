package module;

import java.util.LinkedHashMap;
import java.util.Map;

public class ToDoList
{
    public static Map<String, ToDoItem> tasks = new LinkedHashMap<>();
    public boolean applicationRunning = false;

    public void start()
    {
        applicationRunning = true;
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

    }
}
