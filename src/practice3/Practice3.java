package practice3;


import java.io.*;
import java.util.*;

public class Practice3 {

    public static int cattlecount = 0;
    public static String cattleOptions = "0";

    public static Object[][] Cattle = new Object[100][4];
    

    public static void main(String[] args) {
        cattlemenu();

    }
//This method will get input from the user and will store it in the 2D array which has been formed. 

    public static void add_record() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ID number of The Cattle");
            int cattle_id = input.nextInt();
            try {

                while (true) {
                    for (int i = 0; i < Cattle.length; i++) {

                        if (Cattle[i][0].equals(cattle_id)) {
                            System.out.println("ID alreadyy exists..\nEnter new ID");
                            cattle_id = input.nextInt();
                        }

                    }
                }
            } catch (Exception e) {
                System.out.println("");

            }
            System.out.println("Enter the Age of The Cattle");
            int cattle_age = input.nextInt();
            System.out.println("Enter Cattle Name ");
            String cattle_name = input.next();
            for (int i = 0; i < cattle_name.length(); i++) {
                if (!Character.isLetter(cattle_name.charAt(i))) {
                    System.out.println("Invalid Input");
                    cattle_name = input.next();

                }
            }
            System.out.println("Enter Cattle Origin without any space ");
            String cattle_origin = input.next();
            for (int i = 0; i < cattle_origin.length(); i++) {
                if (!Character.isLetter(cattle_origin.charAt(i))) {
                    System.out.println("Invalid Input");
                    cattle_origin = input.next();

                }
            }

            for (int i = cattlecount; i < Cattle.length; i++) {
                if (Cattle[i][0] == null) {
                    Cattle[i][0] = cattle_id;
                    Cattle[i][1] = cattle_age;
                    Cattle[i][2] = cattle_name;
                    Cattle[i][3] = cattle_origin;
                    cattlecount++;
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println("Error...");
        }
    }
//This method will help the user to view the alredy stored data in the program.

    public static void view_record() {
        if (cattlecount > 0) {
            System.out.println("ID                  Age                Name                Origin");
            for (int i = 0; i < Cattle.length; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Cattle[i][0] == null) {
                        break;
                    }
                    System.out.printf("%-20s", Cattle[i][j]);
                }
                System.out.println();

            }
        } else {
            System.out.println("Please Add Data First");
        }
    }
//This method will get and ID from the user and if it is present in the array, this method will facilitate the user to upadat eany information for the give specific ID.

    public static void update_record() {
        if (cattlecount > 0) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Enter The ID of The Cattle you want to Update");
                int ID_ToUpdate = input.nextInt();
                for (int i = 0; i < Cattle.length; i++) {
                    if (Cattle[i][0].equals(ID_ToUpdate)) {
                        System.out.println("Enter Cattle age ");
                        int cattle_age = input.nextInt();
                        System.out.println("Enter Cattle Name");
                        String cattle_name = input.next();
                        boolean validinput = true;
                        for (int a = 0; a < cattle_name.length(); a++) {
                            if (!Character.isLetter(cattle_name.charAt(a))) {
                                validinput = false;
                                System.out.println("Invalid Input");
                                cattle_name = input.next();
                                break;
                            }
                        }
                        System.out.println("Enter Cattle Origin");
                        String cattle_origin = input.next();
                        boolean valid_input = true;
                        for (int a = 0; a < cattle_origin.length(); a++) {
                            if (!Character.isLetter(cattle_origin.charAt(a))) {
                                valid_input = false;
                                System.out.println("Invalid Input");
                                cattle_origin = input.next();
                                break;

                            }
                        }
                        Cattle[i][1] = cattle_age;
                        Cattle[i][2] = cattle_name;
                        Cattle[i][3] = cattle_origin;
                        break;

                    }
                }
            } catch (Exception e) {
                System.out.println("Error...");
            }
        } else {
            System.out.println("Please Enter Some Data First");
        }
    }
//This method will get an ID as a input and will search in the arry if that ID is present or not, if iot is present, it wiil shoe only that specific ID details and its Information.

    public static void search_record() {
        if (cattlecount > 0) {
            Scanner input = new Scanner(System.in);

            try {
                System.out.println("Enter The ID of the Cattle you want to search");
                int search = input.nextInt();
                for (int i = 0; i < Cattle.length; i++) {
                    if (Cattle[i][0].equals(search)) {

                        System.out.println("ID                  Age                Name                Origin");
                        for (int j = 0; j < 4; j++) {
                            System.out.printf("%-20s", Cattle[i][j]);
                        }
                        System.out.println();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("No Such ID Found");

            }
        } else {
            System.out.println("Please Enter some data first");
        }
    }
//This mrthod will get the ID as an input from the user and will delete it from the record.

    public static void delete_ind_record() {
        if (cattlecount > 0) {
            Scanner input = new Scanner(System.in);

            try {
                System.out.println("Please Enter The ID of the Cattle you want to Delete");
                int ID_ToDel = input.nextInt();
                for (int i = 0; i < Cattle.length; i++) {
                    if (Cattle[i][0].equals(ID_ToDel)) {
                        Cattle[i][0] = null;
                        Cattle[i][1] = null;
                        Cattle[i][2] = null;
                        Cattle[i][3] = null;
                        System.out.println("Data Deleted!");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error...");

            }
        } else {
            System.out.println("Please Enter Some Data First");
        }
    }
//This method will delete all the record which is stored in thr array.

    public static void del_all_record() {
        if (cattlecount > 0) {
            Scanner input = new Scanner(System.in);

            try {
                System.out.println("To delete all data press 1...");
                int del = input.nextInt();
                if (del == 1) {
                    for (int i = 0; i < Cattle.length; i++) {
                        for (int j = 0; j < Cattle[i].length; j++) {
                            Cattle[i][j] = null;
                            System.out.println("All data has been erased..");
                            cattlecount = 0;
                            break;
                        }
                    }
                } else {
                    System.out.println("Deletion Process Halted!!!");
                    cattlemenu();
                }
            } catch (Exception e) {
                System.out.println("Deletion Process Halted!!!");

            }
        } else {
            System.out.println("Please Enter Some Data First");
        }
    }
//THis method will create a textfile in which output of this program will be stored.

    public static void create_file() {
        if (cattlecount > 0) {
            try {
                File myobj = new File("record.txt");
                PrintWriter pw = new PrintWriter(myobj);
                for (int i = 0; i < Cattle.length; i++) {
                    for (int j = 0; j < Cattle[i].length; j++) {
                        pw.println(Cattle[i][j]);

                    }
                }
                System.out.println("Data Entered");
                pw.close();
            } catch (IOException e) {
                System.out.println("Error...");
            }
        } else {
            System.out.println("Please Enter Some Data First");
        }
    }
//It access the data which is stored in text file and show it in the console in the more understandable format.

    public static void read_file() {
        try {
            int count = 1;
            File myobj = new File("record.txt");
            Scanner myReader = new Scanner(myobj);
            System.out.println("ID                  Age                Name                Origin");
            while (myReader.hasNextLine()) {
                String v1 = myReader.nextLine();
                System.out.printf("%-20s", v1);
                if (count % 4 == 0) {
                    System.out.println("");

                }
                count++;

            }

            myReader.close();
        } catch (IOException e) {
            System.out.println("Error...");
        }
    }
//THis method will delete all data stored in the file and will reolaceit with null.

    public static void delete_file() {
        if (cattlecount > 0) {
            try {
                File myobj = new File("record.txt");
                PrintWriter pw = new PrintWriter(myobj);
                for (int i = 0; i < Cattle.length; i++) {
                    for (int j = 0; j < Cattle[i].length; j++) {
                        pw.println(Cattle[i][j] = 0);

                    }
                }
                System.out.println("Data Deleted");
                pw.close();
                cattlecount = 0;
            } catch (IOException e) {
                System.out.println("Error...");
            }
        } else {
            System.out.println("Please Enter Some Data First");
        }
    }
//This is the method from where all the other methods will be called or acessed.

    public static void cattlemenu() {
        Scanner input = new Scanner(System.in);

        boolean shouldBreak = true;
        while (shouldBreak) {
            System.out.printf("Press %n 1.ADD Record %n 2.View Record %n 3.Search Record %n 4.Update Record %n 5.Delete Individual Record %n 6.Delete All Record %n 7.Write into File %n 8.Read from File %n 9.Delete data stored in File and Exit %n");
            String cattleOptions = input.next();
            switch (cattleOptions) {
                case "1":
                    add_record();
                    break;
                case "2":
                    view_record();
                    break;
                case "3":
                    search_record();
                    break;
                case "4":
                    update_record();
                    break;
                case "5":
                    delete_ind_record();
                    break;
                case "6":
                    del_all_record();

                    break;
                case "7":
                    create_file();
                    break;
                case "8":
                    read_file();
                    break;
                case "9":
                    delete_file();
                    shouldBreak = false;
                    System.out.println("Programm Closing...");
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }

        }

    }
}
