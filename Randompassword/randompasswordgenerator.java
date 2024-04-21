import java.security.SecureRandom;
import java.util.Scanner;

public class randompasswordgenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the desired length of the password: ");
        int passwordLength = scanner.nextInt();

        
        if (passwordLength <= 0) {
            System.out.println("Please enter a positive password length.");
            return;
        }

        
        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialCharacters = scanner.next().equalsIgnoreCase("y");

        
        String password = generatePassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialCharacters);

        
        System.out.println("Your generated password is: " + password);

       
        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialCharacters) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        String allChars = "";
        if (includeLowercase) {
            allChars += lowercaseChars;
        }
        if (includeUppercase) {
            allChars += uppercaseChars;
        }
        if (includeNumbers) {
            allChars += numberChars;
        }
        if (includeSpecialCharacters) {
            allChars += specialChars;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
