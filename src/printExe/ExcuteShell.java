package printExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExcuteShell extends Thread {
  
  int time;
  
  public  ExcuteShell(int time) {
    this.time = time;
  }
  
  @Override
  public void run() {
    System.out.println("xianchengyunxing");
    Process process = null;  
    try {  
        process = Runtime.getRuntime().exec("ps -ef");  
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));  
        String line = "";  
        int exitValue = process.waitFor();  
        while (exitValue != 0) {
          line = input.readLine();
          System.out.println(line);  
        }  
        input.close();  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
  }
  
  public static void main(String[] args) throws InterruptedException {
    new ExcuteShell(1000).start();
  }
}
