package com.sherry.houserent.view;

import com.sherry.houserent.domain.House;
import com.sherry.houserent.service.HouseService;
import com.sherry.houserent.utility.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);


    public void exit(){
        System.out.println("Are you sure to exit the system? (Y/N):");
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            loop = false;
        }
    }
    public void listHouses() {
        System.out.println("------------------House List------------------");
        System.out.println("Id\t\tOwner\t\tPhone\t\tAddress\t\tRent(month)\t\t Status\t\t");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            } else {
                System.out.println(houses[i]);
            }
        }
        System.out.println("--------------End of House List ----------------");

    }


    /*
     * Add the houses() and receive the house and use the add method.
     */
    public void addHouse() {
        System.out.println("------------------Add House------------------");
        System.out.println("Name: ");
        String name = Utility.readString(8);
        System.out.println("Phone: ");
        String phone = Utility.readString(12);
        System.out.println("Address: ");
        String address = Utility.readString(16);
        System.out.println("Rent: ");
        int rent = Utility.readInt();
        System.out.println("Status: ");
        String state = Utility.readString(8);
        // The id should be automatically generated by the system
        House newHouse = new House(1, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("Add successfully");
        } else {
            System.out.println("Add failed");
        }

    }

    public void deleteHouse() {
        System.out.println("------------------Delete House------------------");
        System.out.println("Please input the id of the house you want to delete: (-1 to exit)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("Delete cancelled");
            return;
        }
        while (delId < 1 || delId > houseService.getHouseNums()) {
            System.out.println("The id is not correct. Please input it again: ");
            delId = Utility.readInt();
        }
        System.out.println("Are you sure to delete the house? (Y/N):");
        char choice = Utility.readConfirmSelection();// this method has loop logic here.
        if (choice == 'Y') {
            houseService.delete(delId);
            System.out.println("Delete successfully");
        } else {
            System.out.println("Delete failed");
        }
    }

    public void reviseHouse(){
        System.out.println("------------------Revise House------------------");
        System.out.println("Please input the id of the house you want to revise: (-1 to exit)");
        int reviseId = Utility.readInt();
        if (reviseId == -1) {
            System.out.println("Revise cancelled");
            return;
        }
        while (reviseId < 1 || reviseId > houseService.getHouseNums()) {
            System.out.println("The id is not correct. Please input it again: ");
            reviseId = Utility.readInt();
        }
        System.out.println("Are you sure to revise the house? (Y/N):");
        char choice = Utility.readConfirmSelection();// this method has loop logic here.
        if (choice == 'Y') {
            houseService.revise(reviseId);
            System.out.println("Revise successfully");
        } else {
            System.out.println("Revise failed");
        }
    }

    public void searchHouse(){
        System.out.println("------------------Search House------------------");
        System.out.println("Please input the id of the house you want to search: (-1 to exit)");
        int searchId = Utility.readInt();
        if (searchId == -1) {
            System.out.println("Search cancelled");
            return;
        }
        while (searchId < 1 || searchId > houseService.getHouseNums()) {
            System.out.println("The id is not correct. Please input it again: ");
            searchId = Utility.readInt();
        }
        System.out.println("Are you sure to search the house? (Y/N):");
        char choice = Utility.readConfirmSelection();// this method has loop logic here.
        if (choice == 'Y') {
            houseService.search(searchId);
        } else {
            System.out.println("Search failed");
        }
    }



    public void mainMenu() {
        do {
            System.out.println("-----------House Service-----------");
            System.out.println("\t\t\t1.Add the house");
            System.out.println("\t\t\t2.Search the house");
            System.out.println("\t\t\t3.Delete the house");
            System.out.println("\t\t\t4.Revise the house");
            System.out.println("\t\t\t5.The house List");
            System.out.println("\t\t\t6.Exit the system");
            System.out.println("Please input your choice! (1-6): ");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    searchHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    reviseHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("Your input is not correct. Please input it again: ");
                    break;
            }
        } while (loop);
    }
}