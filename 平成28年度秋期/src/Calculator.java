import java.util.Stack;

public class Calculator {
    private final Stack<Integer> stack = new Stack<Integer>();
    private Key pendingKey;

    public Calculator(){
        stack.push(0);
    }

    public void onKeyPressed(Key key){
        System.out.println(key);
        if (key instanceof DigitKey){
            if(pendingKey == OperationKey.EQUAL){
                reset();
            }
            key.opetateOn(stack);
            System.out.println(stack.peek());
        } else if (key == OperationKey.CLEAR){
            reset();
            System.out.println(stack.peek());
        } else {
            try {
                if (pendingKey != null){
                    pendingKey.opetateOn(stack);
                }
                System.out.println(stack.peek());
                pendingKey = key;
                if(key != OperationKey.EQUAL){
                    stack.push(0);
                }
            } catch (ArithmeticException e) {
                System.out.println("Error");
                reset();
            }
        }
    }

    private void reset(){
        stack.clear();
        stack.push(0);
        pendingKey = null;
    }
}
