import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class check {
    @Test(description = "Check Scanner Class Input")
    public static void checkScanner() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input
/*        Scanner kb = new Scanner(System.in);
        int i =10;
        int num = kb.nextInt();
        //int num=10;
        System.out.println(num);
        Assert.assertEquals(i,num);*/
    }
}
