package synchcro;

public class Device extends Thread {
	   public String name, type;
	   public int ID;
	   public  Router router;

	   public Device(String name, String type, Router router) {
	        this.name = name;
	        this.type = type;
	        this.router = router;
	        ID = 1;
	    }

	    @Override
	    public void run() {
	        try {
	            router.arrived(this);
	            router.semaphore.wait(this);
	            ID = router.connect(this);
	            System.out.println("Connection " + ID + ": " + name + " Occupied");

	            activity();
	            router.disconnect(this);
	            router.semaphore.signal();

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	    }

	    public void activity() throws InterruptedException {
	        System.out.println("Connection " + ID + ": " + name + " Performs online activity");
	        sleep(2000);
	    }
	}
