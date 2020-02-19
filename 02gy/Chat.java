import java.net.*;
import java.io.*;
import java.util.*;

class MulticastRadio {
  private static final Set<DataOutputStream> outs = new HashSet<>();

  public static void addClient(DataOutputStream out) {
    outs.add(out);
  }

  public static void removeClient(DataOutputStream out) {
    outs.remove(out);
  }

  public static void multicast( String message ){
     System.out.println("A client has sent a message: " + message);
     for( DataOutputStream out: outs ){
       try {
         out.writeUTF(message);
         out.flush();
       } catch( IOException e ){ System.err.println(e); }
     }
  }
  
}

class ChatHandler extends Thread {
  private Socket socket;
  MulticastRadio radio;

  ChatHandler(MulticastRadio _radio, Socket _socket) {
    this.radio = _radio;
    this.socket = _socket;
  }

  public void run() {
    try {
      try {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        radio.addClient( out );
        try {
          while(true){  // exit when connection is closed
            String message = in.readUTF();
            radio.multicast(message);
          }
        } finally {
          radio.removeClient( out );
        }
      } finally {
        System.out.println("A client has disconnected.");
        socket.close();
      }
    } catch( IOException e ){ System.err.println(e); }
  }
}

class ChatServer {

  public static void main( String[] args ) throws IOException {
    ServerSocket ss = new ServerSocket(1234);
    MulticastRadio radio = new MulticastRadio();
    while(true){
      System.out.println("The server is waiting for a connection.");
      Socket s = ss.accept();
      System.out.println("A client has connected.");
      ChatHandler handler = new ChatHandler(radio, s);
      handler.start();
    }
  }

}


class ChatClient {
  public static void main( String[] args ) throws Exception {
    try (
      Socket socket = new Socket("localhost",1234);
    ){
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      DataInputStream in = new DataInputStream(socket.getInputStream());
      System.out.println("Established connection.");
      (new Runnable {
        while( true ){
          String message = in.readUTF();
          System.out.println("A message has arrived: " + message);
      }).run();
      }
    }
  }
}

