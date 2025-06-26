package oopsjava.day2ConstructorsInstancevsClassAccesModifiers;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void showDetails() {
        System.out.println("ID: " + employeeID + ", Department: " + department + ", Salary: ₹" + getSalary());
    }

    public static void main(String[] args) {
        Manager m = new Manager(501, "HR", 50000);
        m.showDetails();
        m.setSalary(55000);
        m.showDetails();
    }
}