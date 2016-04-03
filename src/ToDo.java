import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by johnjastrow on 4/1/16.
 */
public class ToDo {
    public static void main(String[] args) {
      ArrayList<ToDoItem> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create to-do item");
            System.out.println("2. Toggle to-do item");
            System.out.println("3. List to-do items");
            System.out.println("Q. Quit");

            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "1" : {
                    System.out.println("Enter your to-do item:");
                    String text = scanner.nextLine();

                    ToDoItem item = new ToDoItem(text, false);
                    items.add(item);
                    break;
                }
                case "2" : {
                    System.out.println("Enter the number of the item you want to toggle:");
                    int itemNum = Integer.valueOf(scanner.nextLine());
                    ToDoItem item = items.get(itemNum-1);
                    item.isDone = !item.isDone;
                    break;
                }
                case "3" : {
                    displayList(items);
                    break;
                }
                case "Q": return;
                default: System.out.println("Invalid option");
            }
        }
    }

    private static void displayList(ArrayList<ToDoItem> items){
        int i = 1;
        for (ToDoItem item : items) {
            String checkbox = "[ ] ";
            if (item.isDone) {
                checkbox = "[x] ";
            }
            System.out.println(String.format("%s%s. %s", checkbox, String.valueOf(i), item.text));
            i++;
        }
    }
}