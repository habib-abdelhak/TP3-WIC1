package emetteur;

import java.io.*;
import java.net.*;

public class emeteur {
	public static void main(String arvg[])
	{int port =9005;
	
	String host="localhost";
	try {
		InetAddress adr = InetAddress.getByName(host);
		DatagramSocket socket= new DatagramSocket();
		
		String fileName = "C:\\Users\\blue\\eclipse-workspace\\tp3\\src\\emetteur\\resaux.txt";
		File file = new File(fileName);
		byte[] name= file.getName().getBytes();	 
		DatagramPacket packet = new DatagramPacket(name,name.length,adr,port);
		socket.send(packet);
		byte[] reponse = new byte [9003];
		packet = new DatagramPacket(reponse,reponse.length);
		socket.receive(packet);
		String rep = new String(packet.getData(),0,packet.getLength());
		System.out.println(rep);
		FileInputStream input= new FileInputStream(file);
		while(input.read(reponse) != -1) {
			packet = new DatagramPacket(reponse,reponse.length, packet.getAddress(),packet.getPort());
			socket.send(packet);
		}}
		
		catch(Exception e) {
			System.out.println("Erreur:"+e);
		}
		}

}
            
   

