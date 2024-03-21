package Helpers;

public class Helpers {

    public static long randomInt(int maxValue){

        return Math.round(Math.random() * (maxValue));

    }
    public static void wait(int seconds){
        try{
            int i = seconds * 1000;
            Thread.sleep(i);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
