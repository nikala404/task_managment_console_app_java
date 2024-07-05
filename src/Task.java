import java.util.HashMap;


import static java.lang.System.out;

public class Task {
    private String name;
    private String description;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Task(String name, String description, String author){
//        this.name = name;
//        this.description = description;
//        this.author = author;
//    }


    public void saveTheTask(Task task, HashMap<String, Task> taskContainer){
        taskContainer.put(task.name,task);
        System.out.println(taskContainer.get(task.name));
        System.out.println("Task added successfully");
    }

    static void getAllTask(HashMap<String , Task> taskContainer){
    for (Task tasks : taskContainer.values()){
    out.println("Tasks:" + tasks.toString());
    }
    }

    public void updateTask(String taskName, Task task, HashMap<String ,Task> taskContainer){
            taskContainer.remove(taskName);
            taskContainer.put(task.name, task);
            System.out.println("Task Updated Successfully");
    }



    @Override
    public String toString(){

        return "Name:" + name + "\n" + "Desc:" + description + "\n" +"Author:" + author;
    }

}
