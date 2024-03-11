import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println(calc(sc.nextLine()));
    }

    public static String calc(String input) throws Exception {
        String[] args = input.split(" ");
        if (args.length > 3) {
            throw new ArrayIndexOutOfBoundsException("Формат не удовлетворяет заданию");
        }
            if (eqv(args[0]) && eqv(args[2])) {
                for (int i = 0; i < args.length; i++) {
                    if (eqv(args[i])) {
                        ARGS ar = ARGS.valueOf(args[i]);
                        args[i] = ar.getNumber();
                    }
                }

                int[] numInt = new int[args.length];
                for (int i = 0; i < args.length; i++) {
                    if (i != 1) {
                        numInt[i] = Integer.parseInt(args[i]);
                    }
                }

                int resolt = switch (args[1]) {
                    case ("+") -> (numInt[0] + numInt[2]);
                    case ("-") -> (numInt[0] - numInt[2]);
                    case ("*") -> (numInt[0] * numInt[2]);
                    case ("/") -> (numInt[0] / numInt[2]);

                    default -> throw new IllegalStateException("Не верный знак операции " + args[1]);
                };
                if(resolt>0) {
                    return convert(resolt);
                } throw new Exception("Римские цифры не могут быть меньше 0");
            }
            if(eqv(args[0]) || eqv(args[2])){
                throw new Exception("Разные типы операндов");
            }
            int[] numInt = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                if (i != 1) {
                    numInt[i] = Integer.parseInt(args[i]);
                   }
            }
            if ((numInt[0] > 0 && numInt[0] <= 10) && (numInt[2] > 0 && numInt[2] <= 10)) {
                int resolt = switch (args[1]) {
                    case ("+") -> (numInt[0] + numInt[2]);
                    case ("-") -> (numInt[0] - numInt[2]);
                    case ("*") -> (numInt[0] * numInt[2]);
                    case ("/") -> (numInt[0] / numInt[2]);

                    default -> throw new IllegalStateException("Не верный знак операции " + args[1]);
                };
                return Integer.toString(resolt);
            } else {
                throw new Exception("Диапозон больше заданного");
            }
        }
        public static boolean eqv (String i){
            for (ARGS constant : ARGS.values()) {
                if (constant.name().equals(i)) {
                    return true;
                }
            }
            return false;
        }

        public static String convert ( int resolt){
            String[] romanNumbers = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] arabicNumbers = { 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String romanNumber = "";
            for (int i = 0; i < romanNumbers.length; i++) {
                while (resolt >= arabicNumbers[i]) {
                    romanNumber += romanNumbers[i];
                    resolt -= arabicNumbers[i];
                }
            }
            return romanNumber;
        }

}