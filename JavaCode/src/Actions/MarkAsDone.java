package Actions;

import java.util.Scanner;
import Actions.*;
import module.*;

public class MarkAsDone extends Actions
{
    @Override
    public void showActionsInformation()
    {
        System.out.println("");
        System.out.println("To mark task as done, enter ID and press ENTER: ");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }
    @Override
    public String readUserInput()
    {
        while(true)
        {
            System.out.println("");
            System.out.print("Enter task ID: ");
            Scanner sc = new Scanner(System.in);
            try
            {
                String userInput = sc.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if(userInputAsNum != 0)
                {
                    ToDoItem toDoItem = ToDoList.tasks.get(userInput);
                    if (toDoItem != null)
                    {
                        return userInput;
                    }
                    else
                    {
                        System.out.println("There is no task woith this ID, try again.");
                    }
                }
                else
                {
                    return userInput;                   //??????
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter a valid ID or 0 to RETURN.");
            }
        }
    }

    @Override
    public void executeAction(String command)
}
