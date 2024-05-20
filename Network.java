package synchcro;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Network {
    public static void main(String[] args) throws InterruptedException {
        int  Connectionsnum, numberOfDecives;
        ArrayList<Device> devices = new ArrayList<>();

       Scanner input1 = new Scanner(System.in); 

        System.out.println("What is number of WI-FI Connections?");
        Connectionsnum = input1.nextInt();
        Router router = new Router(Connectionsnum);

        System.out.println("What is number of devices Clients want to connect?");
        numberOfDecives = input1.nextInt();


        for (int i = 0; i < numberOfDecives; i++) {
            Device newDevice = new Device(input1.next(),input1.next(), router);
            devices.add(newDevice);
        }

        for (int i = 0; i < numberOfDecives; i++) {
            sleep(1000);
            devices.get(i).start();
        }
    }
}