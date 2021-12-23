package com.day20200104.test1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Test_RMI_Registry {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(3333);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
