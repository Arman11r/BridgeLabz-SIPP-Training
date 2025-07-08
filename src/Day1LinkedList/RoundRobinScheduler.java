package Day1LinkedList;

import java.util.*;

class Process {
    int pid, burstTime, priority, remainingTime;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    Process head = null;

    public void addProcess(Process p) {
        if (head == null) {
            head = p;
            p.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = p;
            p.next = head;
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;
        Process temp = head, prev = null;

        do {
            if (temp.pid == pid) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else {
                    if (temp == head) {
                        Process last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes.");
            return;
        }

        int totalWaitingTime = 0, totalTurnaroundTime = 0, n = 0;
        Process temp = head;
        while (temp.next != head) {
            n++;
            temp = temp.next;
        }
        n++;

        int time = 0;
        Process current = head;

        while (true) {
            boolean allDone = true;
            do {
                if (current.remainingTime > 0) {
                    allDone = false;
                    if (current.remainingTime > timeQuantum) {
                        time += timeQuantum;
                        current.remainingTime -= timeQuantum;
                    } else {
                        time += current.remainingTime;
                        totalTurnaroundTime += time;
                        totalWaitingTime += (time - current.burstTime);
                        current.remainingTime = 0;
                        removeProcess(current.pid);
                    }
                }
                current = current.next;
            } while (current != head);

            if (allDone) break;
        }

        System.out.println("Avg Waiting Time: " + (double) totalWaitingTime / n);
        System.out.println("Avg Turnaround Time: " + (double) totalTurnaroundTime / n);
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("Empty queue.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("PID: " + temp.pid + " | BT: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Simulate 4.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter PID, BT, Priority: ");
                    scheduler.addProcess(new Process(sc.nextInt(), sc.nextInt(), sc.nextInt()));
                    break;
                case 2:
                    scheduler.displayQueue();
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    scheduler.simulate(sc.nextInt());
                    break;
                case 4:
                    return;
            }
        }
    }
}