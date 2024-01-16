import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        boolean run = true;
        Scanner input = new Scanner(System.in);
        while (run) {

            try {
                System.out.println("Welcome to the unit converter.");

                boolean validInput = false;
                double unitlessNum = 0.0;

                while (!validInput) {
                    try {
                        System.out.println("Please input amount (non-negative number):");
                        while (!input.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a valid number for the amount.");
                            input.next();
                        }
                        unitlessNum = input.nextDouble();

                        if (unitlessNum >= 0) {
                            validInput = true;
                        } else {
                            System.out.println("The amount cannot be negative. Please try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("An unexpected error occurred. Please try again.");
                        input.next();
                    }

                }
                String previousUnit = "";
                String unit1 = "";
                String unit2 = "";
                boolean inConversion = false;
                boolean Validunit1 = false;

                while (!Validunit1) {
                    try {
                        Set<String> allowedUnits = new HashSet<>(
                                Arrays.asList("km", "mi", "lbs", "kg", "in", "m", "f", "c"));

                        input.nextLine();
                        while (!allowedUnits.contains(unit1)) {
                            System.out.println("Input unit to convert from: ");
                            unit1 = input.nextLine().toLowerCase();
                            if (!allowedUnits.contains(unit1)) {
                                System.out.println("Invalid unit. Please choose from: " + allowedUnits);
                            } else {
                                Validunit1 = true;
                            }
                        }
                        previousUnit = unit1;
                        inConversion = true;
                    } finally {

                    }

                }
                boolean Validunit2 = false;

                while (!Validunit2) {
                    try {
                        Set<String> allowedUnits = new HashSet<>(
                                Arrays.asList("km", "mi", "lbs", "kg", "in", "m", "f", "c"));

                        input.nextLine();
                        previousUnit = unit1;
                        inConversion = true;
                        while (!allowedUnits.contains(unit2) || (inConversion && unit2.equals(previousUnit))) {
                            System.out.println("Input unit to convert to: ");
                            unit2 = input.nextLine().toLowerCase();
                            if (!allowedUnits.contains(unit2)) {
                                System.out.println("Invalid unit. Please choose from: " + allowedUnits);
                            } else {
                                Validunit2 = true;
                            }
                        }
                    } finally {

                    }

                }

                double convertedValue = 0.0;
                if ("mi".equals(previousUnit) && "km".equals(unit2)) {
                    convertedValue = unitlessNum * 1.60934;
                } else if ("lbs".equals(previousUnit) && "kg".equals(unit2)) {
                    convertedValue = unitlessNum * 0.453592;
                } else if ("in".equals(previousUnit) && "m".equals(unit2)) {
                    convertedValue = unitlessNum * 0.0254;
                } else if ("f".equals(previousUnit) && "c".equals(unit2)) {
                    convertedValue = (unitlessNum - 32) * 5 / 9;
                } else if ("km".equals(previousUnit) && "mi".equals(unit2)) {
                    convertedValue = unitlessNum * .621371;
                } else if ("kg".equals(previousUnit) && "lbs".equals(unit2)) {
                    convertedValue = unitlessNum * 2.20462;
                } else if ("m".equals(previousUnit) && "in".equals(unit2)) {
                    convertedValue = unitlessNum * 39.3701;
                } else if ("c".equals(previousUnit) && "f".equals(unit2)) {
                    convertedValue = (unitlessNum * 9 / 5) + 32;
                }

                System.out.println(unitlessNum + " " + previousUnit + " is equal to " + convertedValue + " " + unit2);

                System.out.println("Would you like to perform another conversion? (Enter 'exit' or '-1' to quit)");
                String choice = input.nextLine();
                if ("exit".equalsIgnoreCase(choice) || "-1".equals(choice)) {
                    break;
                } else {
                    validInput = false;
                    Validunit1 = false;
                    Validunit2 = false;

                }
            } finally {

            }

        }
        input.close();
    }
}