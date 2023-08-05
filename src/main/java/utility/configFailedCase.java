package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class configFailedCase implements IRetryAnalyzer {
    private int min = 0;
    private int max = 2;
    @Override
    public boolean retry(ITestResult result) {
        if (min < max) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (min +1));
            min++;
            return true;
        }
        return false;
    }
}
