import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindow {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String windowID=driver.getWindowHandle();
        System.out.println(windowID);
    }
}
