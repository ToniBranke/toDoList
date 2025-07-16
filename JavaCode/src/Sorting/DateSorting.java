package Sorting;

import Actions.*;
import module.*;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateSorting extends Actions
{
    @Override
    public void showActionsInformation()
    {
        throw new UnsupportedOperationException("the requested Operation is not Supported.");
    }

    @Override
    public String readUserInput()
    {
        throw new UnsupportedOperationException("the requested Operation is not Supported.");
    }

    @Override
    public void executeAction(String command)
    {
        List<Map.Entry<String, ToDoItem>> entries = new ArrayList<>(ToDoList.tasks.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, ToDoItem>>()
        {
            @Override
            public int compare(Map.Entry<String, ToDoItem> task1, Map.Entry<String, ToDoItem> task2)
            {
                LocalDate dueDateFirstTask = task1.getValue().getDueDate();
                LocalDate dueDateSecondTask = task2.getValue().getDueDate();
                int result = dueDateFirstTask.compareTo(dueDateSecondTask);
                return result;
            }
        });
        ToDoList.tasks.clear();
        entries.forEach((entry) ->
        {
            ToDoList.tasks.put(entry.getKey(), entry.getValue());
        });
        System.out.println("Task successfully sorted. ");
    }

    public static boolean isDateVAlid(String format, String value)
    {
        DateTimeFormatter formattings = DateTimeFormatter.ofPattern(format);
        try
        {
            LocalDate localDate = LocalDate.parse(value, formattings);
            String result = localDate.format(formattings);
            return result.equals(value);
        }
        catch (DateTimeParseException err)
        {

        }
        return false;
    }

    public static String convertDateToString(LocalDate date, String format)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try
        {
            result = date.format(formatter);
        }
        catch (DateTimeParseException e)
        {

        }
        return result;
    }

    public static LocalDate pareeDate(String format, String value)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(value, formatter);
        return localDate;
    }
}
