/*
 * NAME : MUHAMMAD IRMAN SYAKIR BIN ISMAIL
 * MATRIC NUM : S62354
 */
package busticketsystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import javax.swing.*;

/**
 * Username = Irman Password = 2022
 */
public class MatDanBusTicket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        String user, password, yn, search, again, choice = null, from = null, place = null, DESTINATION = "KUALA TERENGGANU", ticket_type = null,
                Type_tc = null, Date = null, price = null, Seat = null;
        double totalPrice = 0.0, PRICE;
        int y = 1, end = 0;
        int available[] = new int[6];

        for (int i = 1; i < 4; i++) {
            //Display dialog box to insert information
            user = JOptionPane.showInputDialog("Insert Your Username: ");
            password = JOptionPane.showInputDialog("Insert Your Password: ");

            for (int seatArr = 1; seatArr <= 5; seatArr++) {
                available[seatArr] = 30;
            }

            if (user.equals("Irman") && password.equals("2022")) {

                for (int x = 1; x == 1;) {
                    System.out.println("\n***************************************************************");
                    System.out.println("** BUS RESERVATION AND TICKETING SYSTEM BY Matdan’s company  **");
                    System.out.println("***************************************************************");
                    System.out.println("** [1] Book A Ticket                 **************************");
                    System.out.println("** [2] Exit                          **************************");
                    System.out.println("***************************************************************");
                    if (totalPrice != 0.0) {
                        System.out.println("** Total Price For Ticket : RM " + totalPrice + "           *****************");
                    }
                    System.out.println("***************************************************************\n");

                    for (x = 1; x == 1;) {
                        choice = InputChoice(choice);

                        //if CHOICE is "1" display the DESTINATION//
                        if (choice.equals("1")) {

                            //adult,kid or sr citizen +calling mnethod tc type
                            ticket_type = TicketType(ticket_type);
                            System.out.println("Ticket For : " + ticket_type);

                            if (ticket_type.equals("Adult")) {

                                //the DESTINATION DETAILS//
                                //display the "Destination", every destination "Fare", and the "Seat" available//
                                System.out.println("\nThe shown price is for adult");
                                System.out.println("********************************************************************");
                                System.out.println("**   From              |    DESTINATION     |    FARE    |  SEAT  **");
                                System.out.println("********************************************************************");
                                System.out.println("** 1.)KUANTAN          |    K.TERENGGANU    |  RM 19.60  |   " + available[1] + "   **");
                                System.out.println("** 2.)KUALA LUMPUR     |    K.TERENGGANU    |  RM 43.50  |   " + available[2] + "   **");
                                System.out.println("** 3.)SEREMBAN         |    K.TERENGGANU    |  RM 49.00  |   " + available[3] + "   **");
                                System.out.println("** 4.)IPOH             |    K.TERENGGANU    |  RM 63.70  |   " + available[4] + "   **");
                                System.out.println("** 5.)ALOR SETAR       |    K.TERENGGANU    |  RM 60.50  |   " + available[5] + "   **");
                                System.out.println("********************************************************************");
                                System.out.println("** Kid 70% Cheaper Than Adult price                               **");
                                System.out.println("** Senior Cetizen 50% Cheaper Than Adult price                    **");
                                System.out.println("********************************************************************\n");

                            } else if (ticket_type.equals("Kid")) {
                                System.out.println("\nThe shown price is for kid");
                                System.out.println("********************************************************************");
                                System.out.println("**   From              |    DESTINATION     |    FARE    |  SEAT  **");
                                System.out.println("********************************************************************");
                                System.out.println("** 1.)KUANTAN          |    K.TERENGGANU    |  RM 5.88   |   " + available[1] + "   **");
                                System.out.println("** 2.)KUALA LUMPUR     |    K.TERENGGANU    |  RM 13.05  |   " + available[2] + "   **");
                                System.out.println("** 3.)SEREMBAN         |    K.TERENGGANU    |  RM 14.70  |   " + available[3] + "   **");
                                System.out.println("** 4.)IPOH             |    K.TERENGGANU    |  RM 19.11  |   " + available[4] + "   **");
                                System.out.println("** 5.)ALOR SETAR       |    K.TERENGGANU    |  RM 18.15  |   " + available[5] + "   **");
                                System.out.println("********************************************************************");
                                System.out.println("** Kid 70% Cheaper Than Adult price                               **");
                                System.out.println("** Senior Cetizen 50% Cheaper Than Adult price                    **");
                                System.out.println("********************************************************************\n");

                            } else if (ticket_type.equals("Sr. Citizen")) {
                                System.out.println("\nThe shown price is for Sr. Citizen");
                                System.out.println("********************************************************************");
                                System.out.println("**   From              |    DESTINATION     |    FARE    |  SEAT  **");
                                System.out.println("********************************************************************");
                                System.out.println("** 1.)KUANTAN          |    K.TERENGGANU    |  RM  9.80  |   " + available[1] + "   **");
                                System.out.println("** 2.)KUALA LUMPUR     |    K.TERENGGANU    |  RM 21.75  |   " + available[2] + "   **");
                                System.out.println("** 3.)SEREMBAN         |    K.TERENGGANU    |  RM 24.50  |   " + available[3] + "   **");
                                System.out.println("** 4.)IPOH             |    K.TERENGGANU    |  RM 31.85  |   " + available[4] + "   **");
                                System.out.println("** 5.)ALOR SETAR       |    K.TERENGGANU    |  RM 30.25  |   " + available[5] + "   **");
                                System.out.println("********************************************************************");
                                System.out.println("** Kid 70% Cheaper Than Adult price                               **");
                                System.out.println("** Senior Cetizen 50% Cheaper Than Adult price                    **");
                                System.out.println("********************************************************************\n");
                            }

                            //Date + calling method date
                            Date = GetDateInput(Date);
                            System.out.println("\nOnboard Date : " + Date + "\n");

                            //Choose Destination + calling method place
                            place = ChoosePlace(place);
                            System.out.println("From : " + place + "\tTo\tDestination :" + DESTINATION + "\n");

                            //adult,kid or sr citizen +calling mnethod tc type
                            Type_tc = OneWayOrReturn(Type_tc);
                            System.out.println("Ticket Type : " + Type_tc + "\n");

                            //price + calling price method
                            price = Ticket_Price(ticket_type, place, Type_tc);
                            System.out.println("Price : " + price + "\n");

                            //Pick seat
                            Seat = PickSeat(Seat);
                            System.out.println("Seat : " + Seat + "\n");

                            //Ticket number, Destination, Price, Category, Date, Time, and seat number.
                            //calling method
                            PrintReceipt(Date, place, DESTINATION, price, ticket_type, Type_tc, Date, Seat);

                            x = 0;

                        } //IF USER CHOOSE 2 AUTO EXIT
                        else if (choice.equals("2")) {
                            end = 1;
                            x = 0;
                            System.out.println("Thank You!");
                        } //IF USER INPUT OTHER NUMBERS THAN 1 OR 2
                        else {
                            System.out.println("Invalid Input!\n");
                            x = 1;
                        }
                    }

                    for (y = 1; y == 1;) {
                        if (end == 1) {
                            break;
                        }
                        System.out.print("\nDo you want another transaction? [Y/N]: ");
                        yn = input.next();

                        if (yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("Y")) {
                            x = 1;
                            y = 0;
                        } else if (yn.equalsIgnoreCase("n") || yn.equalsIgnoreCase("N")) {
                            System.out.println("\nThank You!!!");
                            break;
                        } else {
                            System.out.println("Invalid Input!!!");
                            y = 1;
                        }
                    }

                    PRICE = Double.parseDouble(price);
                    totalPrice = totalPrice + PRICE;
                }
                i = 4;
            } else {
                JOptionPane.showMessageDialog(null, "\nInvalid user or password!\n", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
                if (i == 3) {
                    JOptionPane.showMessageDialog(null, "\nYou have been reached limit of try!\n", "Wrong Input", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public static String InputChoice(String choice) {
        Scanner input = new Scanner(System.in);
        System.out.print("ENTER CHOICE: ");
        choice = input.next();
        return choice;
    }

    public static String ChoosePlace(String from) {
        int place = 0;
        Scanner input = new Scanner(System.in);
        for (int x = 1; x == 1;) {
            System.out.print("Please choose place you will waiting for the bus (Insert number 1 - 5 only): ");
            place = input.nextInt();

            //if Inputed integers are "<1" or ">5", display error and go back to Inputing//
            if (place < 1 || place > 5) {
                System.out.println("Invalid Input!\n");
                x = 1;
            } else {
                //destination
                if (place == 1) {
                    from = "KUANTAN";
                } else if (place == 2) {
                    from = "KUALA LUMPUR";
                } else if (place == 3) {
                    from = "SEREMBAN";
                } else if (place == 4) {
                    from = "IPOH";
                } else if (place == 5) {
                    from = "ALOR SETAR";
                }
                x = 0;
            }
        }
        return from;
    }

    public static String TicketType(String ticket_type) {
        int tc = 0;
        Scanner input = new Scanner(System.in);
        for (int x = 1; x == 1;) {
            System.out.print("Please choose your ticket type (1 = Adult , 2 = Kid , 3 = Sr Citizen): ");
            tc = input.nextInt();

            //if Inputed integers are "<1" or ">5", display error and go back to Inputing//
            if (tc < 1 || tc > 3) {
                System.out.println("Invalid Input!\n");
                x = 1;
            } else {
                //destination
                if (tc == 1) {
                    ticket_type = "Adult";
                } else if (tc == 2) {
                    ticket_type = "Kid";
                } else if (tc == 3) {
                    ticket_type = "Sr. Citizen";
                }
                x = 0;
            }
        }
        return ticket_type;
    }

    public static String OneWayOrReturn(String Type_tc) {
        int tc = 0;
        Scanner input = new Scanner(System.in);
        for (int x = 1; x == 1;) {
            System.out.print("Please choose your ticket type (1 = OneWay , 2 = Return): ");
            tc = input.nextInt();

            //if Inputed integers are "<1" or ">5", display error and go back to Inputing//
            if (tc < 1 || tc > 2) {
                System.out.println("Invalid Input!\n");
                x = 1;
            } else {
                //type
                if (tc == 1) {
                    Type_tc = "OneWay";
                } else if (tc == 2) {
                    Type_tc = "Return";
                }
                x = 0;
            }
        }
        return Type_tc;
    }

    public static String GetDateInput(String Date) {
        Scanner input = new Scanner(System.in);
        for (int x = 1; x == 1;) {
            System.out.println("Please Insert Onboard Date(Please follow this format = dd-mm-yr, Example: 01-01-2022): ");
            System.out.print("Date : \t");
            String dDate = input.next();

            String substr = dDate.substring(0, 2);
            int day = Integer.valueOf(substr);

            String substr2 = dDate.substring(3, 5);
            int mth = Integer.valueOf(substr2);

            String substr3 = dDate.substring(6, 10);
            int yr = Integer.valueOf(substr3);

            LocalDate date1 = LocalDate.now();
            LocalDate date2 = LocalDate.of(yr, mth, day);

            //System.out.println(date1);  
            //System.out.println(date2);  
            long days = ChronoUnit.DAYS.between(date1, date2);

            String result;
            if (mth == 1 || mth == 3 || mth == 5 || mth == 7 || mth == 8 || mth == 10 || mth == 12) {
                if (days < 0 || days > 31) {
                    System.out.println("Date for booking ticket MUST be within 1 month only\n");
                    x = 1;
                } else {
                    Date = dDate;
                    x = 0;
                }
            } else if (mth == 2 || mth == 4 || mth == 6 || mth == 9 || mth == 11) {
                if (days < 0 || days > 30) {
                    System.out.println("Date for booking ticket MUST be within 1 month only\n");
                    x = 1;
                } else {
                    Date = dDate;
                    x = 0;
                }
            }
        }

        return Date;
    }

    private static String Ticket_Price(String ticket_type, String place, String Type_tc) {
        String Price = null;
        double price = 0.0;
        // price for adult
        if (ticket_type.equals("Adult")) {
            if (place.equals("KUANTAN")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "19.60";
                } else {
                    price = 19.60 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("KUALA LUMPUR")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "43.50";
                } else {
                    price = 43.50 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("SEREMBAN")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "49.00";
                } else {
                    price = 49.00 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("IPOH")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "63.70";
                } else {
                    price = 63.70 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("ALOR SETAR")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "60.50";
                } else {
                    price = 60.50 * 2;
                    Price = Double.toString(price);
                }
            }
        } // price for kiddo
        else if (ticket_type.equals("Kid")) {
            if (place.equals("KUANTAN")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "5.88";
                } else {
                    price = 5.88 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("KUALA LUMPUR")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "13.05";
                } else {
                    price = 13.05 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("SEREMBAN")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "14.70";
                } else {
                    price = 14.70 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("IPOH")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "19.11";
                } else {
                    price = 19.11 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("ALOR SETAR")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "18.15";
                } else {
                    price = 18.15 * 2;
                    Price = Double.toString(price);
                }
            }
        } // price for senior
        else if (ticket_type.equals("Sr. Citizen")) {
            if (place.equals("KUANTAN")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "9.80";
                } else {
                    price = 9.80 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("KUALA LUMPUR")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "21.75";
                } else {
                    price = 21.75 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("SEREMBAN")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "24.50";
                } else {
                    price = 24.50 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("IPOH")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "31.85";
                } else {
                    price = 31.85 * 2;
                    Price = Double.toString(price);
                }
            } else if (place.equals("ALOR SETAR")) {
                if (Type_tc.equals("OneWay")) {
                    Price = "30.25";
                } else {
                    price = 30.25 * 2;
                    Price = Double.toString(price);
                }
            }
        }
        return Price;
    }

    public static String PickSeat(String Seat) {
        Scanner input = new Scanner(System.in);
        //Seat = input.next();

        int x = 0;
        String sT = null;
        String[] user_respo;
        String[] Rows = {"A |", "B |", "C |"};
        String[][] table = {
            {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"}
        };

        do {
            System.out.print("Choose your seat\n\n");
            String[] columns = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            for (int i = 0; i < columns.length; i++) {
                System.out.print("\t" + columns[i]);
            }
            System.out.println("\n");

            for (int row = 0; row < table.length; row++) {
                System.out.print(Rows[row]);
                for (int col = 0; col < table[row].length; col++) {
                    System.out.print("\t" + table[row][col]);
                }
                System.out.println();
            }
            //TABLE REPEAT

            System.out.print("\nPlease Choose your seat (Example : A1) ");
            if (x == 1) {
                System.out.print("\nIf already choose seat before, please insert the same seat number: ");
            }
            //Get seat number
            Seat = input.next();

            if (Seat.equals("A1") || Seat.equals("a1")) {
                sT = "1,1";
            } else if (Seat.equals("A2") || Seat.equals("a2")) {
                sT = "1,2";
            } else if (Seat.equals("A3") || Seat.equals("a3")) {
                sT = "1,3";
            } else if (Seat.equals("A4") || Seat.equals("a4")) {
                sT = "1,4";
            } else if (Seat.equals("A5") || Seat.equals("a5")) {
                sT = "1,5";
            } else if (Seat.equals("A6") || Seat.equals("a1")) {
                sT = "1,6";
            } else if (Seat.equals("A7") || Seat.equals("a7")) {
                sT = "1,7";
            } else if (Seat.equals("A8") || Seat.equals("a8")) {
                sT = "1,8";
            } else if (Seat.equals("A9") || Seat.equals("a9")) {
                sT = "1,9";
            } else if (Seat.equals("A10") || Seat.equals("a10")) {
                sT = "1,10";
            } else if (Seat.equals("B1") || Seat.equals("b1")) {
                sT = "2,1";
            } else if (Seat.equals("B2") || Seat.equals("b2")) {
                sT = "2,2";
            } else if (Seat.equals("B3") || Seat.equals("b3")) {
                sT = "2,3";
            } else if (Seat.equals("B4") || Seat.equals("b4")) {
                sT = "2,4";
            } else if (Seat.equals("B5") || Seat.equals("b5")) {
                sT = "2,5";
            } else if (Seat.equals("B6") || Seat.equals("b1")) {
                sT = "2,6";
            } else if (Seat.equals("B7") || Seat.equals("b7")) {
                sT = "2,7";
            } else if (Seat.equals("B8") || Seat.equals("b8")) {
                sT = "2,8";
            } else if (Seat.equals("B9") || Seat.equals("b9")) {
                sT = "2,9";
            } else if (Seat.equals("B10") || Seat.equals("b10")) {
                sT = "2,10";
            } else if (Seat.equals("C1") || Seat.equals("c1")) {
                sT = "3,1";
            } else if (Seat.equals("C2") || Seat.equals("c2")) {
                sT = "3,2";
            } else if (Seat.equals("C3") || Seat.equals("c3")) {
                sT = "3,3";
            } else if (Seat.equals("C4") || Seat.equals("c4")) {
                sT = "3,4";
            } else if (Seat.equals("C5") || Seat.equals("c5")) {
                sT = "3,5";
            } else if (Seat.equals("C6") || Seat.equals("c1")) {
                sT = "3,6";
            } else if (Seat.equals("C7") || Seat.equals("c7")) {
                sT = "3,7";
            } else if (Seat.equals("C8") || Seat.equals("c8")) {
                sT = "3,8";
            } else if (Seat.equals("C9") || Seat.equals("c9")) {
                sT = "3,9";
            } else if (Seat.equals("C10") || Seat.equals("c10")) {
                sT = "3,10";
            }

            user_respo = sT.split(",");
            int row1 = Integer.parseInt(user_respo[0]);
            int col2 = Integer.parseInt(user_respo[1]);
            //CHECK IF IT IS A NEGATIVE NUMBER OR NOT
            //MINUS 1 SINCE INDEX STARTS WITH 0
            if (Integer.parseInt(user_respo[0]) > 0 && Integer.parseInt(user_respo[1]) > 0) {
                //MINUS 1 SINCE INDEX STARTS WITH 0
                table[row1 - 1][col2 - 1] = "X";
            }
            x++;
        } while (x < 2);
        return Seat;
    }

    public static void PrintReceipt(String Date, String place, String DESTINATION, String price, String ticket_type, String Type_tc, String Date0, String Seat) throws FileNotFoundException {
        PrintWriter resultFile = new PrintWriter("receipt.txt");

        // Generate random integers in range 0 to 999
        Random tc = new Random();
        int TICKETNO = tc.nextInt(1000);

        // Print random integers
        System.out.println("Ticket No : " + TICKETNO);

        System.out.println("Ticket have been saved, check your receipt");
        //Ticket number, Destination, Price, Category, Date, Time, and seat number.
        resultFile.println("***************************************************************************************");
        resultFile.println("****\t\t\t\t\t\t\tTICKET NO : " + TICKETNO + "  \t  *****");
        resultFile.println("****\t\t\t\t\tBUS TICKET\t\t\t\t  *****");
        resultFile.println("****                                                                              *****");
        resultFile.println("****                                                                              *****");
        resultFile.println("****   FROM  :" + place + "  TO   " + DESTINATION + "\t\t\t\t\t\t  *****");
        resultFile.println("****   PRICE :" + price + "\t\t\t\t\t\t\t\t  *****");
        resultFile.println("****   CATEGORY :" + ticket_type + "(" + Type_tc + ")  \t\t\t\t\t\t  *****");
        resultFile.println("****   DATE :" + Date + "  \t\t\t\t\t\t\t  *****");
        resultFile.println("****   SEAT NO :" + Seat + "  \t\t\t\t\t\t\t\t  *****");
        resultFile.println("***************************************************************************************");
        resultFile.close();

    }

}
