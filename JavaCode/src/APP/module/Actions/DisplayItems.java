package Actions;

import module.ToDoList;
import Sorting.*;

public class DisplayItems extends Actions
{
    @Override
    public void showActionsInformation()
    {
        System.out.println("");
        System.out.println("Here are all the items in the List");
    }

    @Override
    public String readUserInput()
    {
        throw new UnsupportedOperationException("the requested operation is not yet supported.");
    }

    @Override
    public void executeAction(String command)
    {
        ToDoList.tasks.forEach((key, toDoItem) ->
        {
            System.out.println("ID: " + key+ " , Title: " + toDoItem.getTitle() + ", Due Date: "
                    + DateSorting.convertDateToString(toDoItem.getDueDate(), "dd-mm-yyyy")
                    + ", Status " + toDoItem.getStatus() + ", Project: " + toDoItem.getProjectName()
            );
        });
    }
}
