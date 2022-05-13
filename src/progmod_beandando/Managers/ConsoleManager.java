package progmod_beandando.Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleManager {

    private static BufferedReader GetBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void WriteMessage(String message) {
        System.out.print(message);
    }

    public static String ReadString(String message) {
        WriteMessage(message);

        BufferedReader reader = GetBufferedReader();
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            WriteMessage("ReadLine error: " + e.getMessage());
        }

        return input.trim();
    }

    public static int ReadInt(String message){
        int input = -1;

        try{
            String sinput = ReadString(message);
            input = Integer.parseInt(sinput);
        }catch(Exception e){
            input = -1;
        }

        return input;
    }

    public static boolean ReadBoolean(String message, String trueString, String falseString){
        boolean input = false;

        try{
            String sinput = ReadString(message);
            if(sinput.toLowerCase().equals(trueString.toLowerCase())){
                input = true;
            }else if(sinput.toLowerCase().equals(falseString.toLowerCase())){
                input = false;
            }else{
                input = false;
            }
        }catch(Exception e){
            input = false;
        }

        return input;
    }

    public static void Clear() {
        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                WriteMessage("Failed to clear console.");
            }
        } else {
            try {
                Runtime.getRuntime().exec("clear");
            } catch (Exception e) {
                WriteMessage("Failed to clear console.");
            }
        }

        System.out.flush();
    }
}
