package com.sherry.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *use OOP to programming
 *each Programming is correspond to one function
 */
public class SmallChangeSysOOP {
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



    public void mainMenu(){
        System.out.println("Display the SamllChange APP.....");

        do {
            System.out.println("===============Chose The Menu=============");
            System.out.println("\t\t\t1. The Detail");
            System.out.println("\t\t\t2. Income");
            System.out.println("\t\t\t3. Expense");
            System.out.println("\t\t\t4. Exit System");
            System.out.println("Please input the number (1-4)");
            key = scanner.next();
            // Use switch the control
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("Your input is wrong, please input again");
            }
        } while (loop);

    }

    public void detail(){
        System.out.println(details);
    }

    public void income(){
        System.out.println("The Income is: ");
        money = scanner.nextDouble();
        while (money <= 0) {
            System.out.println("Your input should over 0, please input again.");
            money = scanner.nextDouble();
        }
        System.out.println("Your income "+money+" was stored successfully.");
        balance += money;
        date = new Date();
        details += "\nIncome\t+" + money + "\t" + sdf.format(date) + "\t" + balance;

    }

    public void pay(){
        System.out.println("The Expense is: ");
        money = scanner.nextDouble();
        while (money <= 0 || money > balance) {
            System.out.println("Exceed your balance or your input leas than 0 , please input again.");
            money = scanner.nextDouble();
        }
        System.out.println("Your expense "+money+" was stored successfully.");
        System.out.println("Please input the statement of expense.");
        note = scanner.next();
        System.out.println("Your note \" "+note+" \" was stored successfully.");
        balance -= money;
        date = new Date();
        details += "\n"  + note + "\t" + "-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }


    public void exit(){
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
    }
}
