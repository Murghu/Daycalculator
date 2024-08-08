import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CombinedDayCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 1: Calculate the day of the week from a given date
        System.out.println("Enter a date (yyyy-MM-dd):");
        String inputDate = scanner.nextLine();

        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String dayOfWeek = date.getDayOfWeek().toString();
            System.out.println("The day of the week is: " + dayOfWeek);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }

        // Part 2: Calculate the future/past day based on a given number of days
        int days = getIntegerInput(scanner);
        System.out.println("You entered: " + days);

        System.out.print("Enter present day: ");
        String dayName = scanner.nextLine().trim();

        int day = getDayNumber(dayName);
        if (day == -1) {
            System.out.println("Invalid day name entered.");
            scanner.close();
            return;
        }

        int futureDayIndex = (day + days) % 7;
        if (futureDayIndex < 0) {
            futureDayIndex += 7; // Adjust for negative modulo result
        }

        String futureDayName = getDayName(futureDayIndex);

        if (futureDayName == null) {
            System.out.println("An error occurred in calculating the future day.");
            scanner.close();
            return;
        }

        System.out.println("The day " + Math.abs(days) + " days " + (days >= 0 ? "from" : "before") + " " + dayName + " is " + futureDayName);

        scanner.close();
    }

    public static int getIntegerInput(Scanner scanner) {
        while (true) {
            System.out.print("Please enter the number of days (an integer): ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer number.");
            }
        }
    }

    public static int getDayNumber(String dayName) {
        switch (dayName.toLowerCase()) {
            case "sunday":
                return 0;
            case "monday":
                return 1;
            case "tuesday":
                return 2;
            case "wednesday":
                return 3;
            case "thursday":
                return 4;
            case "friday":
                return 5;
            case "saturday":
                return 6;
            default:
                return -1; // Invalid day name
        }
    }

    public static String getDayName(int dayNumber) {
        switch (dayNumber) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return null; // Invalid day number
        }
    }
}
