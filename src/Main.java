import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        String input;

        do {
            System.out.println("\nWelcome to SmartTasker:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Get Daily Motivation");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter due date (yyyy-mm-dd): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    taskManager.addTask(title, dueDate);
                    break;
                case "2":
                    System.out.println("\nTasks:");
                    for (int i = 0; i < taskManager.getTasks().size(); i++) {
                        System.out.println((i + 1) + ". " + taskManager.getTasks().get(i));
                    }
                    break;
                case "3":
                    System.out.print("Enter task number to mark complete: ");
                    int completeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    taskManager.markTaskComplete(completeIndex);
                    break;
                case "4":
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    taskManager.deleteTask(deleteIndex);
                    break;
                case "5":
                    MotivationService.getDailyMotivation();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!input.equals("6"));

        scanner.close();
    }
}
