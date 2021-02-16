import java.io.*;
import java.net.*;

public class r0ach{
    public static void main(String[] args){
        String ip="127.0.0.1";
        int port =44535;
       try{ System.out.println("establishing connection >>");
            Socket s = new Socket(ip,port);
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            DataInputStream input = new DataInputStream(s.getInputStream()); 
            BufferedReader input_br_reader=new BufferedReader(new InputStreamReader(System.in));             
            String cmd="";
            while(cmd!="s/exit"){
            System.out.println("enter the command >> [enter s/exit to exit ] \n");               
            cmd=input_br_reader.readLine();
            output.writeUTF(cmd);
            output.flush(); 
            String reply=input.readUTF();
            System.out.println("[payload : ] >> " + reply);
            }
            output.close();
            s.close();         
        }catch(Exception e){
            System.out.println(e);
        }
    }
}   
 
