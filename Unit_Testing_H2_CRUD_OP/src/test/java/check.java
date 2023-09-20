import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class check {
    @Test(description = "Check Scanner Class Input")
    public static void checkScanner()
    {
        Scanner kb = new Scanner(System.in);
        int i =10;
        int num = kb.nextInt();
        Assert.assertEquals(i,num);
    }
}
