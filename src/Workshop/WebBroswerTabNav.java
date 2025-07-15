package Workshop;

import java.util.*;

interface NavigationManager {
    void visit(String url);
    void back();
    void forward();
    void currentTab();
}

class DesktopBrowserNavigation implements NavigationManager {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentTab = null;

    @Override
    public void visit(String url) {
        if (currentTab != null) {
            backStack.push(currentTab);
        }
        currentTab = url;
        forwardStack.clear();
        System.out.println("Visited: " + url);
    }

    @Override
    public void back() {
        if (backStack.isEmpty()) {
            System.out.println("No tabs in back history.");
            return;
        }
        forwardStack.push(currentTab);
        currentTab = backStack.pop();
        System.out.println("Moved Back to: " + currentTab);
    }

    @Override
    public void forward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No tabs in forward history.");
            return;
        }
        backStack.push(currentTab);
        currentTab = forwardStack.pop();
        System.out.println("Moved Forward to: " + currentTab);
    }

    @Override
    public void currentTab() {
        if (currentTab == null) {
            System.out.println("No tab currently open.");
        } else {
            System.out.println("Current Tab: " + currentTab);
        }
    }
}

public class WebBroswerTabNav {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavigationManager browser = new DesktopBrowserNavigation();

        while (true) {
            System.out.println("\n=== Browser Menu ===");
            System.out.println("1. Visit new URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Show Current Tab");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue; 
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit: ");
                    String url = sc.nextLine();
                    browser.visit(url);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.forward();
                    break;
                case 4:
                    browser.currentTab();
                    break;
                case 5:
                    System.out.println("Exiting browser.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
