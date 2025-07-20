package APP.module.Actions;

import APP.module.Sorting.DateSorting;
import APP.module.*;

import java.util.Scanner;

public class AddItems extends Actions
{
    @Override
    public void showActionsInformation()
    {
        System.out.println("");
        System.out.println("To add a new task, please follow the instructions and press ENTER:");
        System.out.println("ID, Title, Due Date (dd-mm,yyyy), Status, Project Name");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput()
    {
        while (true)
        {
            System.out.println("");
            System.out.println("choose and enter a Action: ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            if (!userInput.equals("0")) {
                String[] parts = userInput.split(",");
                if (parts.length == 5) {
                    if (DateSorting.isDateValid("dd-mm-yyyy", parts[2])) {
                        if (ToDoList.tasks.get(parts[0]) == null) {
                            return userInput;
                        } else {
                            System.out.println("A task with this ID already exists, try again: ");
                        }
                    } else {
                        System.out.println("The date entered is invalid, please try again: ");
                    }
                } else {
                    System.out.println("Please follow the Instructions, try again: ");
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void executeAction(String command)
    {
        String[] parts = command.split(",");
        ToDoItem toDoItem = ToDoItem.buildItem(parts[0], parts[1], DateSorting.parseDate("dd-mm-yyyy", parts[2]), parts[3], parts[4]);

        ToDoList.tasks.put(toDoItem.getID(), toDoItem);
        System.out.println("Successfully added task with ID: " + toDoItem.getID());
    }
}

