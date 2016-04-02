package br.ufrn.imd.sid;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import br.ufrn.imd.controller.GameRun;

public class RemotePalitinhosImpl extends UnicastRemoteObject implements RemotePalitinhos {

	private GameRun game;
	
	
		
	public static void main(String[] args) {
		try {
			Registry r = LocateRegistry.getRegistry();
			r.bind("palitinhos", new RemotePalitinhosImpl());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
