package net.revature;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

public class WideningDriver {
    public static void main(String[] args) {


        float a = 15.5789f;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(a));

//        System.out.printf("'%5.2e'%n", a);

        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        printArray(charArray);
    }
}
