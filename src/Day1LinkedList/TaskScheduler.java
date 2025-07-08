package Day1LinkedList;

import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    Task head = null;

    public void addTaskAtEnd(Task newTask) {
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addTaskAtBeginning(Task newTask) {
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addTaskAtPosition(Task newTask, int pos) {
        if (pos == 0) {
            addTaskAtBeginning(newTask);
            return;
        }
        Task temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id && head.next == head) {
            head = null;
            return;
        }

        Task temp = head, prev = null;
        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        Task temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int p) {
        Task temp = head;
        boolean found = false;
        if (head == null) return;
        do {
            if (temp.priority == p) {
                System.out.println(temp.taskId + " | " + temp.taskName);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks with given priority.");
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        Task current = null;

        while (true) {
            System.out.println("\n1.AddBegin 2.AddEnd 3.AddPos 4.Delete 5.Display 6.SearchPriority 7.NextTask 8.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter ID, Name, Priority, DueDate: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int p = sc.nextInt();
                    String date = sc.next();
                    Task t = new Task(id, name, p, date);
                    if (ch == 1) scheduler.addTaskAtBeginning(t);
                    else if (ch == 2) scheduler.addTaskAtEnd(t);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        scheduler.addTaskAtPosition(t, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    scheduler.deleteTask(sc.nextInt());
                    break;
                case 5:
                    scheduler.displayTasks();
                    break;
                case 6:
                    System.out.print("Priority to search: ");
                    scheduler.searchByPriority(sc.nextInt());
                    break;
                case 7:
                    if (current == null) current = scheduler.head;
                    if (current != null) {
                        System.out.println("Current Task: " + current.taskName);
                        current = current.next;
                    } else {
                        System.out.println("No tasks.");
                    }
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}