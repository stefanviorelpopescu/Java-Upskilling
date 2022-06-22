package tdd;

public enum Operation
{
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/"),
    MOD("%")
    ;

    String operation;

    Operation(String operation)
    {
        this.operation = operation;
    }

    public static Operation fromInput(String input) {
        for (Operation operation : Operation.values()) {
            if (operation.operation.equals(input)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation");
    }

//    public static Operation fromString(String input) {
//        switch (input) {
//            case "+" :
//                return PLUS;
//            case "-" :
//                return MINUS;
//            case "*" :
//                return TIMES;
//            case "/" :
//                return DIVIDE;
//            default :
//                throw new IllegalArgumentException("Invalid operation");
//        }
//    }
}
