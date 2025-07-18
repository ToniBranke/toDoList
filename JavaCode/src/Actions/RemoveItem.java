package Actions;

import Actions.*;
import module.*;
import java.util.Scanner;


public class RemoveItem extends Actions
{
    @Override
    public void showActionsInformation()
    {
        System.out.println("");
        System.out.println("to remove a Item, enter ID and press ENTER");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput()
    {
        while (true)
        {
            System.out.println("");
            System.out.println("Please enter ID: ");
            Scanner in = new Scanner(System.in);
            try
            {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if(userInputAsNum != 0 ) {
                    ToDoItem toDoItem = new ToDoItem();
                    if (toDoItem != null) {
                        return userInput;
                    }
                    else
                        System.out.println("ID doesnt exist please enter another ID: ");
                    }
                else
                    return userInput;
            }
            catch (Exception e)
            {
                System.out.println("please enter a valid ID or 0 to RETURN");
            }
        }
    }

    @Override
    public void executeAction(String command)
    {
        ToDoList.tasks.remove(command);

        System.out.println("Task with ID: "+ command + " was successfully removed ...");
    }
}
