package com.sherry.houserent.utility;


/**
 Role of Untility Classes.
 Handle user input for various situations
 and be able to get the user's console input as required by the programmer.
 */

import java.util.*;
/**


 */
public class Utility {
    //静态属性。。
    private static Scanner scanner = new Scanner(System.in);


    /**
     * Function: Reads a menu option entered by the keyboard, value: range 1--5
     * @return 1——5
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("Your input is wrong, please input it again: ");
            } else break;
        }
        return c;
    }

    /**
     * Function: Read a character entered on the keyboard
     * @return one char
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }
    /**
     * Function: Reads a character entered on the keyboard, and returns the specified default value if you press Enter directly; otherwise, it returns the entered character.
     * @param defaultValue The specified default value.
     * @return defaultValue or the entered character
     */

    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * Function: Read the keyboard input integer, the length is less than 2 bits
     * @return int
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Your input number is wrong, please input it again: ");
            }
        }
        return n;
    }
    /**
     * Function: Read the keyboard input integer or default value, if directly enter, then return the default value, otherwise return the input integer
     * @param defaultValue The specified default value.
     * @return Integer or default value
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }

            //error
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Your input number is wrong, please input it again: ");
            }
        }
        return n;
    }

    /**
     * Function: Reads a string of specified length from the keyboard.能：读取键盘输入的指定长度的字符串功
     * @param limit Length of restrictions限制的长度
     * @return String of specified length
     */

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * Function: read the keyboard input of the specified length of the string or the default value,
     * if the direct return, return the default value, otherwise return the string
     * @param limit Length of restrictions
     * @param defaultValue Specified default value
     * @return String of specified length
     */

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }


    /**
     * Function: Read the confirmation option of keyboard input, Y or N.
     * Encapsulate small functions, into a single method.
     * @return Y or N
     */
    public static char readConfirmSelection() {
        System.out.println("Input your choice: Y or N.");
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Your input is wrong, please input it again: ");
            }
        }
        return c;
    }

    /**
     * Function: Read a string
     * @param limit read the length of the string
     * @param blankReturn If true, the empty string can be read.
     * 					  If false, the empty string cannot be read.
     *
     *	If the input is null, or if the input is greater than the length of limit,
     *	                  you will be prompted to re-enter it.
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {


        String line = "";


        while (scanner.hasNextLine()) {
            line = scanner.nextLine();


            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("The input length（cannot more than " + limit + "）Error, Please input again: ");
                continue;
            }
            break;
        }

        return line;
    }
}
