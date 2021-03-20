package by.belstu.it.kovalev;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.WeakHashMap;


import static java.lang.Math.*;

import static java.lang.System.out;

/**  Класса Java Test
 *   Содержит код выполнненных заданий из лаборатораной работ номер 2 */
public class JavaTest {
    static int sint;

//        ЗАДАНUЕ 2
    final int final_const = 1;
    public final int public_final_const = 2;
    public static final int  public_static_final_const = 3;

    /** @return ничего не возвращает
     *  @throws JavaTest не выбрасывает ошибок
     *  @param args - массuв строк*/
    public static void main(String[] args) {
//        ЗАДАНUЕ 1

        /** {@value symbol_char}
         * @see Переменная типа char */char symbol_char = 'a';
        int number_int = 123;
        short number_short = 12;
        byte number_byte = 1;
        long number_long = 1234;
        boolean value_boolean = false;
        double number_double = 3.4;
        String value_string = "Hi, I'm a string!";

        out.println(value_string + number_int);
        out.println(value_string + symbol_char);
        out.println(value_string + number_double);
        byte byte_result = (byte) (number_byte + number_long);
        out.println(byte_result);
        int int_result = (int) (number_double + number_long);
        out.println(int_result);
        long long_result = number_int + 2147483647;
        out.println(long_result);
        out.println(sint);
        boolean boolean_result_1 = value_boolean && true;
        out.println(boolean_result_1);
        boolean boolean_result_2 = value_boolean ^ true;
        out.println(boolean_result_2);
        //        boolean boolean_result_1 = value_boolean + true; - нельзя
        BigInteger bigInteger = new BigInteger("9223372036854775807");
        out.println(bigInteger);
        //        long big_number = 9223372036854775807;
        BigInteger bigInteger_2 = new BigInteger("7ffffffffff",16);
        out.println(bigInteger_2);
        //        long big_number =0x7fff_ffff_fff;
        char symbol_2 = 'a';
        out.println(symbol_2);
        char symbol_3 = '\u0061';
        out.println(symbol_3);
        char symbol_4 = 97;
        out.println(symbol_4);
        out.println( 3.45 % 2.4);
        out.println( 1.0/0.0);
        out.println(  0.0/0.0);
        out.println(Float.intBitsToFloat(0x7F800000));
        out.println(Float.intBitsToFloat(0xFF800000));
//        ЗАДАНUЕ 3
        out.println(Math.PI);
        out.println(Math.E);
        out.println(Math.round(Math.PI));
        out.println(Math.round(Math.E));
        out.println(Math.min(Math.PI,Math.E));
        out.println(Math.random());
//        ЗАДАНUЕ 4
        Boolean Bool_object = false;
        Character Character_object = 's';
        Integer Integer_object = 456;
        Byte Byte_object = 1;
        Short Short_object = 12;
        Long Long_object = Long.valueOf(92233720);
        Double Double_object = 2.2;
        out.println(Bool_object & false);
        out.println(Integer_object + 4);
        out.println(Bool_object & false);
        out.println(Long.MAX_VALUE);
        out.println(Long.MIN_VALUE);
        out.println(Double.MAX_VALUE);
        out.println(Double.MAX_VALUE);

        Byte Byte_object_1 = 1;
        Integer Integer_object_1 = 12;

        byte unboxing_byte = Byte_object_1.byteValue();
        int unboxing_int = Integer_object_1.intValue();

        out.println(Integer.parseInt("234"));
        out.println(Integer.toHexString(54));
        out.println(Integer.compare(54,32));
        out.println(Integer.toString(32));
        out.println(Integer.bitCount(3));
        Double Double_object_2 = (0.0/0.0);
        out.println(Double_object_2.isNaN());

//      Задание 4
        String s34 = "2345";
        Integer string_number = Integer.parseInt(s34);
        out.println(s34.getBytes());
        String string_byte = new String(s34.getBytes());
        Boolean bool_string_1 = new Boolean(s34);
        boolean bool_string_2 = s34.isEmpty();
        String s43= "2345";
        out.println(s43 == s34);
        out.println(s43.equals(s34));
        out.println(s43.compareTo(s34));
        String null_string = null;
        out.println(null_string == s34);
//        out.println(null_string.equals(s34));- нельзя
//        out.println(s43.compareTo(null_string)); - нельзя
        String[] numbers = s34.split("3");
        out.println(numbers[0]);
        out.println(numbers[1]);
        out.println(s34.contains("3"));
        out.println(s34.hashCode());
        out.println(s34.indexOf("3"));
        out.println(s34.length());
        out.println(s34.replace("34","replaced"));
//      Задание 5
        char[][] c1 ={{'1','2'},{'1','2','3'},{'1','2','3','4'}};
        char[] c2[] ={{'1','2'},{'1','2','3'},{'1','2','3','4'}};
        char c3[][] ={{'1','2'},{'1','2','3'},{'1','2','3','4'}};
        char[] massive = new char[0];

        c1 = new char[3][];
        c1[0] = new char[4];
        c1[1] = new char[3];
        c1[2] = new char[2];
        out.println(c1.length);
        for (char[] x:c1) {
                out.print(x.length);
            out.println();
        }
        boolean comRez = (c2==c3);
        out.println(comRez);
        c2 = c3;
        for (char[] x:c2) {
            for(char l:x)
            {
                out.print(l);
            }
            out.println();
        }

        WrapperString wrapped_string = new WrapperString("Hi!");
        out.println(wrapped_string);

        wrapped_string.aclass.replace('H','P');
        out.println(wrapped_string);

        wrapped_string.aclass.delete('P');
        out.println(wrapped_string);


    }
}
