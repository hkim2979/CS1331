import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("List of operations: add subtract multiply divide alphabetize");

        System.out.println("Enter an operation: ");
        String operation = input.next();
        String operationLower = operation.toLowerCase();

        switch (operationLower) {
            case "add":
                System.out.println("Enter two integers: ");
                if (input.hasNextInt()) {
                    int firstAddNum = input.nextInt();
                    int secondAddNum = input.nextInt();
                    int totalAdd = firstAddNum + secondAddNum;
                    System.out.println("Answer: " + totalAdd);
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "subtract":
                System.out.println("Enter two integers: ");
                if (input.hasNextInt()) {
                    int firstSubNum = input.nextInt();
                    int secondSubNum = input.nextInt();
                    int totalSub = firstSubNum - secondSubNum;
                    System.out.println("Answer: " + totalSub);
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "multiply":
                System.out.println("Enter two doubles: ");
                if (input.hasNextDouble()) {
                    double firstMultiNum = input.nextDouble();
                    double secondMultiNum = input.nextDouble();
                    double totalMulti = firstMultiNum * secondMultiNum;
                    System.out.printf("Answer: " + "%.2f\n", totalMulti);
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "divide":
                System.out.println("Enter two doubles: ");
                if (input.hasNextDouble()) {
                    double firstDivNum = input.nextDouble();
                    double secondDivNum = input.nextDouble();
                    if (secondDivNum != 0) {
                        double totalDiv = firstDivNum / secondDivNum;
                        System.out.printf("Answer: " + "%.2f\n", totalDiv);
                    }
                    else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "alphabetize":
                System.out.println("Enter two words: ");
                if (input.hasNext()) {
                    String firstStr = input.next();
                    String secondStr = input.next();

                    String firstStrLower = firstStr.toLowerCase();
                    String secondStrLower = secondStr.toLowerCase();

                    if (!firstStrLower.equals(secondStrLower)) {
                        if (firstStrLower.compareTo(secondStrLower) < 0) {
                            System.out.println("Answer: " + firstStr + " comes before " + secondStr + " alphabetically.");
                        }
                        else if (firstStrLower.compareTo(secondStrLower) > 0) {
                            System.out.println("Answer: " + secondStr + " comes before " + firstStr + " alphabetically.");
                        }
                    }
                    else {
                        System.out.println("Answer: Chicken or Egg.");
                    }
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}