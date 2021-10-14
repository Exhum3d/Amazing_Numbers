package numbers;

import java.io.ObjectStreamClass;
import java.util.*;

class Validations {
    // region Mutually Exclusive Validation
    public static String validateMutuallyExclusive(HashMap<String, Boolean> params, int numParams) {
        if ((params.containsKey("duck") && params.containsKey("spy")) && ((params.get("duck").equals(true) && params.get("spy").equals(true)) || (params.get("duck").equals(false) && params.get("spy").equals(false)))) {
            return "duck-spy";

        } else if ((params.containsKey("square") && params.containsKey("sunny")) && ((params.get("square").equals(true) && params.get("sunny").equals(true)) || (params.get("square").equals(false) && params.get("sunny").equals(false)))) {
            return "square-sunny";
        } else if ((params.containsKey("odd") && params.containsKey("even")) && ((params.get("odd").equals(true) && params.get("even").equals(true)) || (params.get("even").equals(false) && params.get("odd").equals(false)))) {
            return "odd-even";
        } else if ((params.containsKey("happy") && params.containsKey("sad")) && ((params.get("happy").equals(true) && params.get("sad").equals(true)) || (params.get("happy").equals(false) && params.get("sad").equals(false)))) {
            return "happy-sad";
        }
        return "";
    }

    public static void showErrorMutuallyExclusive(String error) {

        if ("duck-spy".equals(error)) {
            System.out.printf("The request contains mutually exclusive properties: [DUCK, SPY]\n");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
        } else if ("square-sunny".equals(error)) {
            System.out.printf("The request contains mutually exclusive properties: [SQUARE, SUNNY]\n");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
        } else if ("odd-even".equals(error)) {
            System.out.printf("The request contains mutually exclusive properties: [ODD, EVEN]\n");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
        } else if ("happy-sad".equals(error)) {
            System.out.printf("The request contains mutually exclusive properties: [HAPPY, SAD]\n");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
        } else if ("happy-sad".equals(error)) {
            System.out.printf("The request contains mutually exclusive properties: [HAPPY, SAD]\n");
            System.out.println("There are no numbers with these properties.");
            System.out.println();
        }
    }

    // endregion
    // region Check If Parameters Exist Validation
    public static String validateParamsExist(HashMap<String, Boolean> params) {
        Set<String> setOfParameters = params.keySet();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        String[] properties = {"buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny", "jumping", "even", "odd", "happy", "sad"};
        List<String> list = Arrays.asList(properties);

        for (String param : setOfParameters) {
            if (!list.contains(param)) {
                sb.append(param).append("||");
                counter++;
            }
        }

        if (counter == 1) {
            return "one-property-is-wrong " + sb.toString().toUpperCase();
        } else if (counter > 1 && counter < 15) {
            return "all-properties-are-wrong " + sb.toString().toUpperCase();
        }
        return "";
    }

    public static void showErrorParamsExist(String error) {
        String[] errors = error.split(" ");
        String str = errors[1].replace("||", ", ");

        if (errors[0].equals("one-property-is-wrong")) {
            System.out.printf("The property [%s] is wrong.\n", str.substring(0, str.length() - 2));
            System.out.println("Available properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
        } else if (errors[0].equals("all-properties-are-wrong")) {
            System.out.printf("The properties [%s] are wrong.\n", str.substring(0, str.length() - 2));
            System.out.println("Available properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
        }
    }

    // endregion
    // region Check If Natural Validation
    public static String validateParamIsNatural(String input) {
        String[] params = input.split(" ");
        String error = new String();
        long firstNumber = 0;
        try {
            firstNumber = Long.parseLong(params[0]);
        } catch (NumberFormatException nfe) {
            error = "has-error";
        }

        long secondNumber = 0;
        if (params.length > 1) {
            try {
                secondNumber = Long.parseLong(params[1]);
            } catch (NumberFormatException nfe) {
                error = "second-has-error";
            }

        }

        if ("has-error".equals(error) || Long.signum(firstNumber) == -1) {
            return "first-param-not-natural";
        } else if ("second-has-error".equals(error) || Long.signum(secondNumber) == -1) {
            return "second-param-not-natural";
        }
        return "";
    }

    public static void showErrorParamIsNatural(String error) {

        if ("first-param-not-natural".equals(error)) {
            System.out.println();
            System.out.println("The first parameter should be a natural number or zero.");
            System.out.println();
        } else if ("second-param-not-natural".equals(error)) {
            System.out.println();
            System.out.println("The second parameter should be a natural number or zero.");
            System.out.println();
        }
    }

    // endregion
    // region Duplicate Validation
    public static String validateDuplicate(String input) {
        String[] params = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < params.length; i++) {
            for (int j = i + 1; j < params.length; j++) {
                if (params[i].contains(params[j]) && (params[i].charAt(0) == '-' || params[j].charAt(0) == '-')) {
                    sb.append(params[i]).append(", ").append(params[j]);
                    break;
                } else if (params[j].contains(params[i]) && (params[i].charAt(0) == '-' || params[j].charAt(0) == '-')) {
                    sb.append(params[i]).append(", ").append(params[j]);
                    break;
                }
            }
        }
        return sb.toString();
    }
    // endregion
}

class Properties {

    private final LinkedHashMap<String, Boolean> properties = new LinkedHashMap<>();
    public long number;

    public Properties(long number) {
        this.number = number;
    }

    // region Set/Show Properties Methods
    private void setProperties() {

        this.properties.put("buzz", checkIfBuzz(this.number));
        this.properties.put("duck", checkIfDuck(this.number));
        this.properties.put("palindromic", checkIfPalindromic(this.number));
        this.properties.put("gapful", checkIfGapful(this.number));
        this.properties.put("spy", checkIfSpy(this.number));
        this.properties.put("square", checkIfSquare(this.number));
        this.properties.put("sunny", checkIfSunny(this.number));
        this.properties.put("jumping", checkIfJumping(this.number));
        this.properties.put("happy", checkIfHappy(this.number));
        this.properties.put("sad", !checkIfHappy(this.number));
        this.properties.put("even", checkParity(this.number));
        this.properties.put("odd", !checkParity(this.number));
    }

    public String showProperties() {
        setProperties();

        StringBuilder sb = new StringBuilder();

        Set<String> setOfProperties = this.properties.keySet();

        for (String property : setOfProperties) {
            if (properties.get(property) == true) {
                sb.append(property).append(", ");
            }
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    // endregion
    // region Public Methods
    public void showPropertiesSingle() {
        setProperties();

        Set<String> setOfProperties = this.properties.keySet();
        System.out.printf("Properties of %d\n", number);
        for (String property : setOfProperties) {
            System.out.printf("%15s: %b\n", property, properties.get(property));
        }
        System.out.println();
    }

    public void showPropertiesForTwo(int range) {

        int internalCounter = 0;

        while (internalCounter != range) {
            String finalString = showProperties();
            System.out.printf("%d is %s\n", this.number, finalString);
            this.number++;
            internalCounter++;
        }
        System.out.println();
    }

    public void showPropertiesForMultiple(int range, HashMap<String, Boolean> params) {
        int internalCounter = 0;

        while (internalCounter != range) {
            setProperties();
            int equalsCounter = 0;
            Set<String> keysOfParams = params.keySet();
            for (String key : keysOfParams) {
                if (params.get(key).equals(this.properties.get(key))) {
                    equalsCounter++;
                }
            }
            if (equalsCounter == params.size()) {
                String finalString = showProperties();
                System.out.printf("%d is %s\n", this.number, finalString);
                internalCounter++;
            }
            this.number++;
        }
        System.out.println();

    }

    // endregion
    // region Private Methods
    private boolean checkParity(long number) {

        return number % 2 == 0;
    }

    private boolean checkIfBuzz(long number) {

        if (number % 7 == 0 || number % 10 == 7) {
            return true;
        }
        return false;
    }

    private boolean checkIfDuck(long number) {

        String numberStringified = Long.toString(number);
        if (numberStringified.charAt(0) == '0') {
            return false;
        } else if (numberStringified.contains("0")) {
            return true;
        }
        return false;
    }

    private boolean checkIfPalindromic(long number) {

        String numberStringified = Integer.toString((int) number);
        char[] reverseNumber = new char[numberStringified.length()];
        for (int i = 0; i < reverseNumber.length; i++) {
            reverseNumber[i] = numberStringified.charAt(numberStringified.length() - i - 1);
        }

        String comparator = new String(reverseNumber);

        if (numberStringified.equals(comparator)) {
            return true;
        }
        return false;
    }

    private boolean checkIfGapful(long number) {

        String numberStr = Long.toString(number);
        char[] divisor = new char[2];
        divisor[0] = numberStr.charAt(0);
        divisor[1] = numberStr.charAt(numberStr.length() - 1);
        String divisorString = new String(divisor);
        if (Integer.parseInt(divisorString) != 0 && Long.parseLong(numberStr) % Integer.parseInt(divisorString) == 0 && numberStr.length() > 2) {
            return true;
        }
        return false;
    }

    private boolean checkIfSpy(long number) {
        long sum = 0;
        long product = 1;
        while (number > 0) {
            long digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        if (sum == product) {
            return true;
        }
        return false;
    }

    private boolean checkIfSquare(long number) {
        double sq = Math.sqrt(number);

        return (sq - Math.floor(sq) == 0);
    }

    private boolean checkIfSunny(long number) {
        if (checkIfSquare(number)) {
            return false;
        }
        if (checkIfSquare(number + 1)) {
            return true;
        }
        return false;
    }

    private boolean checkIfJumping(long number) {
        String digits = Long.toString(number);
        int counter = 0;
        for (int i = 0; i < digits.length() - 1; i++) {
            if (digits.charAt(i) == '9' && digits.charAt(i + 1) == '0') {
                return false;
            } else if (digits.charAt(i) + 1 == digits.charAt(i + 1) || digits.charAt(i) - 1 == digits.charAt(i + 1)) {
                counter++;
            }
        }
        if (counter == digits.length() - 1) {
            return true;
        }
        return false;
    }

    private boolean checkIfHappy(long number) {
        int sum = 0;
        int iterator = 0;
        int counter2 = 0;

        long[] digits = new long[50];
        while (number != 0) {
            digits[counter2] = number % 10;
            number /= 10;
            counter2++;
        }
        while (iterator < 100) {
            for (int i = 0; i < counter2; i++) {
                sum += Math.pow(digits[i], 2);
            }
            if (sum == 1) {
                return true;
            }
            counter2 = 0;
            do {
                digits[counter2++] = sum % 10;
                sum /= 10;

            }
            while (sum != 0);
            iterator++;
        }

        return sum == 1;

    }
    // endregion
}

public class Main {
    // region Welcome method
    public static void welcome() {

        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
    }

    // endregion
    //region Display Instructions Method
    public static void displayInstructions() {

        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    // endregion
    // region Get Number of Parameters Method
    public static int getNumberOfParams(String input) {

        int counter = 0;
        String[] arr = input.split(" ");
        for (String string : arr) {
            counter++;
        }
        return counter;
    }

    // endregion
    // region Get Parameters List
    public static HashMap getParamsList(String input) {
        HashMap<String, Boolean> parameters = new HashMap<>();

        String[] arr = input.toLowerCase().split(" ");

        String[] props = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "jumping", "spy", "square", "sunny", "happy", "sad"};
        List<String> properties = Arrays.asList(props);
        if (arr.length <= 2) {
            parameters.put("NotFound", true);
            return parameters;
        }

        for (int i = 2; i < arr.length; i++) {
            StringBuilder trimmer = new StringBuilder(arr[i]);
            if (trimmer.charAt(0) == '-') {
                parameters.put(trimmer.toString().substring(1), false);
            } else {
                parameters.put(arr[i], true);
            }
        }

        Set<String> setOfParameters = parameters.keySet();
        for (String key : setOfParameters) {
            if (properties.contains(key)) {
                parameters.put(key, parameters.get(key));
            }
        }
        //System.out.println(parameters);
        return parameters;
    }

    // endregion
    // region Split Input Method
    public static String[] splitInput(String input) {
        return input.split(" ");
    }

    // endregion
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String errorNatural = new String();
            String errorMutually = new String();
            String errorExists = new String();

            System.out.print("Enter a request: ");
            String input = scanner.nextLine();
            System.out.println();

            String[] str = splitInput(input);
            int numberOfParams = getNumberOfParams(input);
            HashMap<String, Boolean> params = getParamsList(input);

//            System.out.println(getParamsList(input));

            // region Validations

            if (numberOfParams < 3) {
                errorNatural = Validations.validateParamIsNatural(input);
                if (!"".equals(errorNatural)) {
                    Validations.showErrorParamIsNatural(errorNatural);
                    continue;
                }
            } else {
                errorExists = Validations.validateParamsExist(params);
                if (!"".equals(errorExists)) {
                    Validations.showErrorParamsExist(errorExists);
                    continue;
                }
                errorMutually = Validations.validateMutuallyExclusive(params, numberOfParams);
                if (!"".equals(errorMutually)) {
                    Validations.showErrorMutuallyExclusive(errorMutually);
                    continue;
                }
            }
            String toValidate = Validations.validateDuplicate(input);
            if (toValidate.length() > 2) {
                System.out.printf("The request contains mutually exclusive properties: [%s]\n", toValidate.toUpperCase());
                System.out.println("There are no numbers with these properties.");
                System.out.println();
                continue;
            }
            // endregion
            Properties properties = new Properties(Long.parseLong(str[0]));

            if (Long.parseLong(str[0]) == 0) {
                System.out.println();
                System.out.println("Goodbye!");
                break;
            }
            switch (numberOfParams) {
                case 1:
                    properties.showPropertiesSingle();
                    continue;
                case 2:
                    int range = Integer.parseInt(str[1]);
                    properties.showPropertiesForTwo(range);
                    continue;
                default:
                    range = Integer.parseInt(str[1]);
                    properties.showPropertiesForMultiple(range, params);
                    continue;
            }
        }
    }

    public static void main(String[] args) {
        welcome();
        displayInstructions();
        displayMenu();
    }
}
