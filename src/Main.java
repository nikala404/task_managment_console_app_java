import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Task> taskContainer = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();

        while (!valid) {
            System.out.println("Commands: \n 1. Save The Task \n 2. Get All Tasks \n 3. Update The Task \n 4. Delete The Task \n 5. Exit");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Input Task Name:");
                    String taskName = sc.nextLine();
                    System.out.println("Description:");
                    String taskDesc = sc.nextLine();
                    if (!taskDesc.isEmpty() && !taskName.isEmpty() && !taskContainer.containsKey(taskName)) {
                        Task task = new Task();
                        task.setDescription(taskDesc);
                        task.setAuthor(name);
                        task.setName(taskName);
                        task.saveTheTask(task, taskContainer);

                    } else {
                        System.out.println("Not Valid info. Try Again");
                    }
                    break;

                case 2:

                    Task.getAllTask(taskContainer );
                    break;
                case 3:
                    System.out.println("Task Name:");
                    String primaryTaskName = sc.nextLine();
                    if(taskContainer.containsKey(primaryTaskName)){
                        System.out.println("Input New Task Name:");
                        String newTaskName = sc.nextLine();
                        System.out.println("Input New Description:");
                        String newTaskDesc = sc.nextLine();
                        if (!newTaskDesc.isEmpty() && !newTaskName.isEmpty()) {
                            Task newTask = new Task();
                            newTask.setDescription(newTaskDesc);
                            newTask.setAuthor(name);
                            newTask.setName(newTaskName);
                            newTask.updateTask(primaryTaskName, newTask, taskContainer);
                        }  else{
                            System.out.println("Something is missing");
                        }
                    }else{
                        System.out.println("Task does not exists");
                    }
                    break;



                case 5:
                    valid = true;
                    sc.close();
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }

}