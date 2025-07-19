package APP.module;

import java.util.*;

import APP.module.Actions.*;
import APP.module.Sorting.*;
import APP.module.Saving.*;

public class ToDoList
{
    public static Map<String, ToDoItem> tasks = new LinkedHashMap<>();
    public static boolean applicationRunning = true;

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
    public void executeAction(int actionNumber)
    {
        Actions action;
        switch (actionNumber)
        {
            case Actions.ADD_TASK:
                action = new AddItems();
                action.showActionsInformation();
                String command = action.readUserInput();
                if (!command.equals("0"))
                {
                    action.executeAction(command);
                }
                break;

            case Actions.MARK_AS_DONE:
                if(tasks.size()>0)
                {
                    action = new MarkAsDone();
                    action.showActionsInformation();
                    String id = action.readUserInput();
                    if(!id.equals("0"))
                        action.executeAction(id);
                }
                else
                {
                    System.out.println("No tasks to mark as Done, add one first.");
                }
                break;

            case Actions.REMOVE_TASK:
                if(tasks.size() > 0)
                {
                    action = new RemoveItem();
                    action.showActionsInformation();
                    String id = action.readUserInput();
                    if(!id.equals("0"))
                        action.executeAction(id);
                    else
                        System.out.println("No tasks to remove, add one first.");
                    break;
                }
            case Actions.EDIT_TASK:
                if (tasks.size() > 0)
                {
                    action = new EditTask();
                    action.showActionsInformation();
                    String editCommand = action.readUserInput();
                    if (!editCommand.equals("0"))
                        action.executeAction(editCommand);
                    else
                        System.out.println("No tasks to edit, add one first.");
                    break;
                }
            case Actions.DISPLAY_ALL_TASKS:
                if(tasks.size() > 0)
                {
                    action = new DisplayItems();
                    action.showActionsInformation();
                    action.executeAction(null);
                }
                else
                    System.out.println("No tasks to display, add one first.");
                break;

            case Actions.SORT_TASKS_BY_DATE:
                action = new DateSorting();
                action.executeAction(null);
                break;

            case Actions.SORT_TASKS_PROJECT:
                action = new ProjectSorting();
                action.executeAction(null);
                break;

            case Actions.SAVE_TASKS_TO_FILE:
                if(tasks.size() > 0)
                {
                    action = new SaveToFile();
                    action.showActionsInformation();
                    String path = action.readUserInput();
                    if (!path.equals("0"))
                        action.executeAction(path);
                    else
                        System.out.println("No tasks to save, add one first.");
                    break;
                }

            case Actions.READ_FROM_FILE:
                action = new ReadFromFile();
                action.showActionsInformation();
                String path = action.readUserInput();
                if(!path.equals("0"))
                    action.executeAction(path);
                break;

            case Actions.EXIT:
                applicationRunning = false;
                break;
        }
    }
    public void showApplicationTitle()
    {
        System.out.println("ToDoList Application \n -----------------------------------");
    }
    public void showAvailableActions()
    {
        System.out.println("\n 1. Add a Task " +
                "\n 2. Mark a Task as done" +
                "\n 3. Remove a Task" +
                "\n 4. Edit Task" +
                "\n 5. Display all tasks" +
                "\n 6. Sort Tasks by Date" +
                "\n 7. Sort Tasks by Project" +
                "\n 8. Save Tasks to a File" +
                "\n 9. read from File" +
                "\n 10. Exit" +
                "\n");
    }
    public int readAction()
    {
        List<Integer> availableActions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        while (true)
        {
            try {
                System.out.println("Enter action: ");
                Scanner scan = new Scanner(System.in);
                int action = scan.nextInt();
                if (availableActions.contains(action))
                    return action;
                else
                    System.out.println("Invalid action, please enter a valid Action from the List: .");
            }
            catch (Exception e)
            {
                System.out.println("Action must be a number.");
            }
        }
    }
}
