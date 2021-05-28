package nativeapp.android.keyboard;

import io.appium.java_client.android.nativekey.AndroidKey;

import java.util.HashMap;
import java.util.Map;

public class AsciiKeyTyper {

    private static Map<Character, AndroidKeyStore> strokeMap = init();

    private static Map<Character, AndroidKeyStore> init() {
        return new HashMap<Character, AndroidKeyStore>(){
            private static final long serialVersionUID = 1L;{
                put('\n',new AndroidKeyStore(AndroidKey.ENTER,false));
                put('\t',new AndroidKeyStore(AndroidKey.TAB,false));
                put('\r',new AndroidKeyStore(AndroidKey.HOME,false));
                put(' ',new AndroidKeyStore(AndroidKey.SPACE,false));
                put('!',new AndroidKeyStore(AndroidKey.DIGIT_1,true));
                put('"',new AndroidKeyStore(AndroidKey.APOSTROPHE,true));
                put('#',new AndroidKeyStore(AndroidKey.DIGIT_3,true));
                put('$',new AndroidKeyStore(AndroidKey.DIGIT_4,true));
                put('%',new AndroidKeyStore(AndroidKey.DIGIT_5,true));
                put('&',new AndroidKeyStore(AndroidKey.DIGIT_7,true));
                put('\'',new AndroidKeyStore(AndroidKey.APOSTROPHE,false));
                put('(',new AndroidKeyStore(AndroidKey.LEFT_BRACKET,true));
                put(')',new AndroidKeyStore(AndroidKey.RIGHT_BRACKET,true));
                put('*',new AndroidKeyStore(AndroidKey.STAR,true));
                put('+',new AndroidKeyStore(AndroidKey.PLUS,true));
                put(',',new AndroidKeyStore(AndroidKey.COMMA,false));
                put('-',new AndroidKeyStore(AndroidKey.MINUS,false));
                put('.',new AndroidKeyStore(AndroidKey.PERIOD,false));
                put('/',new AndroidKeyStore(AndroidKey.SLASH,false));
                for(int i='0';i<=(int)'9';i++){
                    put((char)i,new AndroidKeyStore(AndroidKey.valueOf("DIGIT_" +(char)i),false));
                }
                put(':',new AndroidKeyStore(AndroidKey.SEMICOLON,true));
                put(';',new AndroidKeyStore(AndroidKey.SEMICOLON,false));
                put('<',new AndroidKeyStore(AndroidKey.APOSTROPHE,true));
                put('=',new AndroidKeyStore(AndroidKey.EQUALS,false));
                put('>',new AndroidKeyStore(AndroidKey.PERIOD,true));
                put('?',new AndroidKeyStore(AndroidKey.SLASH,true));
                put('@',new AndroidKeyStore(AndroidKey.AT,true));
                for(char i='A';i<='Z';i++){
                    put(i,new AndroidKeyStore(AndroidKey.valueOf(Character.toString(i)),true));
                    put(Character.toLowerCase(i),new AndroidKeyStore(AndroidKey.valueOf(Character.toString(i)),false));
                }
                put('[',new AndroidKeyStore(AndroidKey.LEFT_BRACKET,false));
                put('\\',new AndroidKeyStore(AndroidKey.BACKSLASH,false));
                put(']',new AndroidKeyStore(AndroidKey.RIGHT_BRACKET,false));
                put('^',new AndroidKeyStore(AndroidKey.DIGIT_6,true));
                put('_',new AndroidKeyStore(AndroidKey.MINUS,true));
                put('`',new AndroidKeyStore(AndroidKey.APOSTROPHE,false));
                put('{',new AndroidKeyStore(AndroidKey.LEFT_BRACKET,true));
                put('|',new AndroidKeyStore(AndroidKey.BACKSLASH,true));
                put('}',new AndroidKeyStore(AndroidKey.RIGHT_BRACKET,true));
                put('~',new AndroidKeyStore(AndroidKey.APOSTROPHE,true));
            }};
    }

    public static void type(String text) {
        text.chars().forEachOrdered(i -> {
//            System.out.println((char)i);
            strokeMap.get((char)i).type();
        });
    }
}
