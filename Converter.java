import java.util.Set;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Converter {

    private static Hashtable <String, Double> table = new Hashtable <>();
    public static void main(String[] args) {

        table.put("ft2cm", 30.48);
        table.put("cm2ft", 0.033);
        table.put("ml2km", 1.61);
        table.put("km2ml", 0.62);
        table.put("in2cm", 2.54);
        table.put("cm2in", 0.39);
        table.put("oz2gr", 28.35);
        table.put("gr2oz", 0.035);
        table.put("lb2kg", 0.45);

        Set <String> listOfKeys = table.keySet();
        Scanner sc = new Scanner(System.in);
        String command;
        double value;
        boolean proceed = true;

        System.out.println("*** Available commands ***");
        for(String x: listOfKeys) {
            System.out.println(x);
        }

        try {

           while(proceed){

                System.out.print("Command>>>\n");
                command = sc.next();
                System.out.print("Value>>>\n");
                value = sc.nextDouble();
                convert(command, value);

                System.out.println("Continue? y/n\n");
                if(sc.nextInt() == 'n') proceed = false;
            }
        }

        catch (InputMismatchException ime) {
            System.out.println("Wrong input!");
        }
    }

    private static void convert(String command, double value) throws InputMismatchException {
        if(table.containsKey(command)) {
            double result = table.get(command) * value;
            String unit = command.substring(command.length() - 2);
            System.out.println("Result: " + result + " " + unit);
        }
        else {
            System.out.println("Sorry, command not found");
        }
    }
}