import java.util.*; 
import java.util.concurrent.*; 
 
public class Main { 
    static class Scan { 
        int id; 
        String name; 
        int duration; 
        String pause; 
 
        Scan(int id, String name, int duration, String pause) { 
            this.id = id; 
            this.name = name; 
            this.duration = duration; 
            this.pause = pause; 
        } 
    } 
 
    static class ScanController { 
        ArrayList<Scan> scans = new ArrayList<>(); 
        void handleCommand(String com, Scanner s) { 
             
            if (com.equals("add")) { 
                System.out.println("Enter details: format - id,name,duration,pause "); 
                String input = s.nextLine(); 
                String[] d = input.split(","); 
 
                int id = Integer.parseInt(d[0].trim()); 
                String name = d[1].trim(); 
                int duration = Integer.parseInt(d[2].trim()); 
                String pause = d[3].trim(); 
 
                Scan scan = new Scan(id, name, duration, pause); 
                scans.add(scan); 
                System.out.println("Added"); 
            } else if (com.equals("view")) { 
                for (Scan sc : scans) { 
                    System.out.println(sc.id + ", " + sc.name + ", " + sc.duration + ", " + sc.pause); 
                } 
            } else if (com.equals("remove")) { 
                System.out.println("Enter id: "); 
                int id = s.nextInt(); 
                s.nextLine();
                for (int i = 0; i < scans.size(); i++) { 
                    if (scans.get(i).id == id) { 
                        scans.remove(i); 
                        System.out.println("Removed"); 
                        break; 
                    } 
                } 
            } else if (com.equals("start")) { 
                for (Scan sc : scans) { 
                    System.out.println("Starting " + sc.name); 
                    try { 
                        Thread.sleep(sc.duration * 1000); 
                    } 
                    catch (Exception e) { 
                        System.out.println("Error"); 
                    } 
                    System.out.println("Completed " + sc.name); 
                } 
            } else if (com.equals("exit")) { 
                System.out.println("Program Finished."); 
                System.exit(0); 
            } else { 
                System.out.println("Command Invalid."); 
            } 
        } 
    } 
 
 
    public static void main(String[] args) { 
        ScanController scanController = new ScanController(); 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Commands: add, view, remove, start, exit");
        System.out.print("Enter command: ");
        
        while (true) { 
            String command = sc.nextLine(); 
            scanController.handleCommand(command, sc); 
            System.out.print("Enter command: ");
        } 
    } 
}


