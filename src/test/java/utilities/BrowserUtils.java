package utilities;

public class BrowserUtils {

    public static void wait(int seconds){
        seconds *=1000;
        try{
            Thread.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
