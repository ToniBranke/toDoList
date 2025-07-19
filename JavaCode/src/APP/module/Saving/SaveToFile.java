package Saving;

import Actions.*;
import module.*;
import Sorting.*;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SaveToFile extends Actions
{
    @Override
    public String readUserInput()
    {
        while (true)
        {
            System.out.println("\n Please enter your Path: ");

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
            PrintWriter pw = new PrintWriter(new FileOutputStream(path));
            List<String> lines = ToDoList.tasks.entrySet().stream().map(entry -> entry.getValue().toString()).collect(Collectors.toList());

            lines.forEach((line) ->
            {
                pw.println(line);
            });
            pw.close();
            System.out.println("task successfully saved into file: " + path);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Path or file do not exist ... ");
        }
    }

}
