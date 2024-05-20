package synchcro;

 import static java.lang.Thread.sleep;

public class Router {
    public boolean[] connected;
    public int Devicesnum, connectedDevices;
    public Semaphore semaphore;

    Router(int Devicesnum) {
        this.Devicesnum = Devicesnum;
        semaphore = new Semaphore(Devicesnum);
        connected = new boolean[Devicesnum];
    }

    public synchronized int connect(Device device) throws InterruptedException {
        for (int i = 0; i < Devicesnum; i++) {
            if(!connected[i]){
                connectedDevices++;
                device.ID = i + 1;
                connected[i] = true;
                sleep(100);
                break;
            }
        }
        return device.ID;
    }

    public synchronized void disconnect(Device device){
        connectedDevices--;
        connected[device.ID-1] = false;
        notify();
        System.out.println("Connection " + device.ID + "(" + ": " + device.name + ")"+ " Logged out");
    }

    public synchronized void arrived(Device device){
        System.out.println( device.name +" (" + device.type + ")" +" arrived");
}

}


