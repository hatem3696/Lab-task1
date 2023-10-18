import java.util.Scanner;

enum EmployeeType {
    OFFICER, STAFF
}

public class EmployeeLeaveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Employee " + i + " Information:");
            System.out.print("Employee ID: ");
            String employeeID = scanner.nextLine();
            System.out.print("Employee Name: ");
            String employeeName = scanner.nextLine();
            System.out.print("Date of Birth (dd/mm/yyyy): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Joining Date (dd/mm/yyyy): ");
            String joiningDate = scanner.nextLine();

            // Check if it's a leap year (2024)
            boolean leapYear = Integer.parseInt(dateOfBirth.split("/")[2]) % 4 == 0;

            System.out.print("Employee Type (Officer/Staff): ");
            String employeeTypeInput = scanner.nextLine();
            EmployeeType employeeType = EmployeeType.valueOf(employeeTypeInput.toUpperCase());

            int totalVacationLeave = employeeType == EmployeeType.OFFICER ? 15 : 10;
            int totalSickLeave = employeeType == EmployeeType.OFFICER ? 10 : 7;

            int vacationLeave = calculateLeave(joiningDate, totalVacationLeave, leapYear);
            int sickLeave = calculateLeave(joiningDate, totalSickLeave, leapYear);

            System.out.println("\nEmployee Details:");
            System.out.println("Employee ID: " + employeeID);
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Date of Birth: " + dateOfBirth);
            System.out.println("Email: " + email);
            System.out.println("Joining Date: " + joiningDate);
            System.out.println("Vacation Leave: " + vacationLeave);
            System.out.println("Sick Leave: " + sickLeave);
            System.out.println("-----------------------------");
        }
    }

    // Function to calculate leave days using generics
    private static <T extends Number> int calculateLeave(String joiningDate, T totalLeaveDays, boolean leapYear) {
        // Calculate leave days using the provided formula and leap year check.
        String yearEnd = "31/12/2023";
        int daysInYear = leapYear ? 366 : 365;

        String[] joiningParts = joiningDate.split("/");
        int joiningDay = Integer.parseInt(joiningParts[0]);
        int joiningMonth = Integer.parseInt(joiningParts[1]);

        int yearEndDay = 31;
        int yearEndMonth = 12;

        int leaveDays = ((yearEndDay - joiningDay + 1) + (yearEndMonth - joiningMonth) * 30) * totalLeaveDays.intValue() / daysInYear;

        if (leaveDays >= 0.5) {
            return (int) (double) leaveDays;
        } else {
            return (int) (double) leaveDays;
        }
    }
}
