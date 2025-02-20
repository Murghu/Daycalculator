# Combined Day Calculator

This is a simple Java program that calculates the day of the week for a given date and determines a future or past day based on a given number of days.

## Features
- Accepts a date in `yyyy-MM-dd` format and determines the corresponding day of the week.
- Takes a day name as input and calculates the day after a given number of days (or before, if the number is negative).
- Handles invalid inputs gracefully.
- Ensures valid date input and prevents incorrect formatting.
- Uses modular arithmetic for day calculations.
- Provides user-friendly error messages.

## Implementation
- Uses `LocalDate` and `DateTimeFormatter` from Java's `java.time` package.
- Implements input validation using exception handling.
- Uses a switch-case structure for day name conversions.
- Allows both future and past day calculations based on user input.

