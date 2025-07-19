package APP.module.Sorting;

import APP.module.Actions.*;
import APP.module.*;
import java.util.*;

public class ProjectSorting extends Actions
{
    @Override
    public void showActionsInformation()
    {
        throw new UnsupportedOperationException("The requested operation is not Supported.");
    }
    public String readUserInput()
    {
        throw new UnsupportedOperationException("the requested operation is not Supported.");
    }
    @Override
    public void executeAction(String command)
    {
        List<Map.Entry<String, ToDoItem>> entries = new ArrayList<>(ToDoList.tasks.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, ToDoItem>>()
        {
            @Override
            public int compare(Map.Entry<String, ToDoItem> firstTask, Map.Entry<String, ToDoItem> secondTask)
            {
                String firstProject = firstTask.getValue().getProjectName();
                String secondProject = secondTask.getValue().getProjectName();

                int result = firstProject.compareTo(secondProject);
                return result;
            }
        });
        ToDoList.tasks.clear();
        entries.forEach(entry ->
        {
           ToDoList.tasks.put(entry.getKey(), entry.getValue());
        });
        System.out.println("Task successfully sorted.");
    }
}
