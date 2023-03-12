package org.example.Util;

import java.util.Scanner;

public class ScannerUtil {
    public static int getAction() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter action: ");
            try {
                int n = scanner.nextInt();
                return n;
            } catch (RuntimeException e) {
                System.out.println("Hato kirildi. Son kiriting Mazgi.");
            }
        }

    }
    public static String getPhoneNumber(){
        System.out.println("Enter 0 to exit.");
        System.out.print("or Enter Phone :");
        String phone = ScannerUtil.scannerStr.nextLine();
        if (phone.length() == 13 && phone.startsWith("+998")) return phone;
        return null;
    }
    public static String getPassword(){
        System.out.println("Enter 0 to exit.");
        System.out.print("or Enter Password :");
        return ScannerUtil.scannerStr.nextLine();
    }

    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerStr = new Scanner(System.in);
}
