import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindow {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //getWindowHandle()
        //String windowID=driver.getWindowHandle();
        // System.out.println(windowID);


        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();//open another window

        //getWindowHandle()
        Set<String> windowIDs=driver.getWindowHandles();
        //first method -iterator()
       /* Iterator<String> it =windowIDs.iterator();
        String parentWindowId=it.next();
        String childWindowId=it.next();
        System.out.println("Parent window id" +parentWindowId);
        System.out.println("child window id" +childWindowId);

        */
        //second method
        List<String> windowIdList= new ArrayList(windowIDs);
        //converting set into list
        String parentWindowId =windowIdList.get(0);
        String childWindowId =windowIdList.get(1);
        System.out.println("Parent window id" +parentWindowId);
        System.out.println("child window id" +childWindowId);


        //how  to switch between multiple windows
        driver.switchTo().window(parentWindowId);
        System.out.println("parent window title" +driver.getTitle());

        driver.switchTo().window(childWindowId);
        System.out.println("child window title" +driver.getTitle());

        //for each loop
        for(String winId:windowIdList){
            String title=driver.switchTo().window(winId).getTitle();
            if(title.equals("OrangeHRM")){
                driver.close();
            }
        }






    }
}
