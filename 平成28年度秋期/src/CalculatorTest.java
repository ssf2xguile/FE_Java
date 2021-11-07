import java.util.HashMap;
import java.util.Map;

public class CalculatorTest {
    public static void main(String[] args) {
        Map<Character, Key> map = new HashMap<Character, Key>();
        //文字と列挙OperationKeyの定数の対応をmapに格納する
        for(OperationKey key : OperationKey.values()){
            map.put("+=*/=C".charAt(key.ordinal()), key);
        }
        //数字と列挙DigitKeyの定数の対応をmapに格納する
        for(DigitKey key :DigitKey.values()){
            map.put("0123456789".charAt(key.ordinal()), key);
        }
        
        Calculator calc = new Calculator();
        String chars = args[0];
        //chaarsの各文字をキーの定数に変換し、メソッドonKeyPressedを呼び出す。
        for(int i = 0; i < chars.length(); i++){
            calc.onKeyPressed(map.get(chars.charAt(i)));
        }
    }
}
