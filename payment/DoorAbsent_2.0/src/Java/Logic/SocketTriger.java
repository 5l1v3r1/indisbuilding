package Java.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketTriger extends Thread {
    
    ServerSocket listener;
    
    public SocketTriger(ServerSocket listener){
        this.listener=listener;
    }
    
    @Override
    public void run(){
        ObjectInputStream in = null;
        Socket socket = null;
        try {
            socket = listener.accept();
            in = new ObjectInputStream(socket.getInputStream());
            writeTriger((String) in.readObject());
        } catch (SocketException ex) {
            System.out.println("koneksi IP :"+socket.getInetAddress()+" terputus");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void writeTriger(String listener){
        try {
            File file = new File("resources/socket.txt");
            String fileFos = String.valueOf(file.getAbsolutePath()).replaceAll("\\\\", "//");
            OutputStream fos = new FileOutputStream(fileFos);
            try (Writer osw = new OutputStreamWriter(fos)) {
                osw.append(listener);
                osw.flush();
                osw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String readTriger(){
        String listener = null;
        try {
            File file = new File("resources/socket.txt");
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader readText = new BufferedReader(fileReader);
            String triger;
            while((triger = readText.readLine()) != null){
                listener = triger;
            }
            readText.close();
            fileReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return listener; 
    }
    
}
