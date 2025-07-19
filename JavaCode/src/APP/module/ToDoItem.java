package module;

import Sorting.*;

import java.time.LocalDate;

public class ToDoItem
{
    private String id;
    private String title;
    private LocalDate dueDate;
    private String status;
    private String projectName;

    public String getID()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public LocalDate getDueDate()
    {
        return dueDate;
    }
    public String getStatus()
    {
        return status;
    }
    public String getProjectName()
    {
        return projectName;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }
    public static ToDoItem buildItem(String id, String title, LocalDate dueDate, String status, String projectName)
    {
        ToDoItem toDoItem = new ToDoItem();

        toDoItem.setId(id);
        toDoItem.setTitle(title);
        toDoItem.setDueDate(dueDate);
        toDoItem.setStatus(status);
        toDoItem.setProjectName(projectName);
        return toDoItem;
    }

    public String toString()
    {
        return id + "," + title + "," + DateSorting.convertDateToString(dueDate, "dd-mm-yyyy") + "," + status + "," + projectName;
    }
}
