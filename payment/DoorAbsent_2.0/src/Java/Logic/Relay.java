package Java.Logic;

import java.io.IOException;

public class Relay {
    private ProcessBuilder lockOn;
    private ProcessBuilder lockOff;
    
    public Relay(){
        lockOff = new ProcessBuilder("sudo","python","phyton/relay0_0.py");
        lockOn = new ProcessBuilder("sudo","python","phyton/relay0_1.py");
    }
    
    public void activate(boolean lock){
        try{
            if(lock == true){
                try{
                Process p1 = Runtime.getRuntime().exec("sudo python phyton/relay0_0.py");
                lockOff.start();
                }catch (IOException e){}
            }else{
                try{
                Process p2 = Runtime.getRuntime().exec("sudo python phyton/relay0_1.py");
                lockOn.start();
                }catch(IOException e){}
            }
        }catch(Exception e){
            System.out.println("Error on reading file:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
