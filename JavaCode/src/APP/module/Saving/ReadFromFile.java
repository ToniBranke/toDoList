package Saving;

import Actions.*;
import module.*;
import Sorting.*;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile extends Actions
{
    @Override
    public void showActionsInformation()
    {
        System.out.println("\n Please enter path to read: \n \n Enter 0 to RETURN");
    }

    @Override
    public String readUserInput()
    {
        while(true)
        {
            System.out.println("\n path: ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            return userInput;

        }
    }
    @Override
    public void executeAction(String path)
    {
        try
        {
            Scanner in = new Scanner (new File(path));
            while (in.hasNextLine())
            {
                String file = in.nextLine();
                String[] parts = file.split(",");
                ToDoItem toDoItem = ToDoItem.buildItem(parts[0], parts[1], DateSorting.parseDate("dd-mm-yyyy",parts[2])
                ,parts[3],parts[4]);
                if(ToDoList.tasks.get(parts[0]) != null)
                {
                    ToDoList.tasks.replace(parts[0], toDoItem);
                }
                else
                    ToDoList.tasks.put(parts[0], toDoItem);
            }
            in.close();
            System.out.println("Tasks are being read!");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Path or File Not Found");
        }
    }
}
