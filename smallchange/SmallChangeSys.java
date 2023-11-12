package com.sherry.smallchange;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

//one phase of code to finish one function
public class SmallChangeSys {

    public static void main(String[] args) {


        //define relevant variables
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String details = "-------------The Detail-------------";

        double money = 0;
        double balance = 0;
        String note = "";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        do {
            System.out.println("===============The Menu=============");
            System.out.println("\t\t\t1. The Detail");
            System.out.println("\t\t\t2. Revenue");
            System.out.println("\t\t\t3. Expense");
            System.out.println("\t\t\t4. Quit System");
            System.out.println("Please input the number (1-4)");
            key = scanner.next();
            // Use switch the control
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("The Revenue is: ");
                    money = scanner.nextDouble();
                    while (money <= 0) {
                        System.out.println("Your input should over 0, please input again.");
                        money = scanner.nextDouble();

                    }
                    balance += money;
                    date = new Date();
                    details += "\nCredit\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.println("The Expense is: ");
                    money = scanner.nextDouble();
                    while (money <= 0 || money > balance) {
                        System.out.println("Exceed your balance or your input leas than 0 , please input again.");
                        money = scanner.nextDouble();
                    }
                    System.out.println("Please input the statement of expense.");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
                    details += "\n" + "-" + note + "\t" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    String choice = "";
                    while (true) {
                        System.out.println("Are you sure to exit the system?y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }
                    if ("y".equals(choice)) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("Your input is wrong, please input again");
            }
        } while (loop);
        System.out.println("Quit the small change program.");
    }
}


