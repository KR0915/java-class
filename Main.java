import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String[]> schedules = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            schedules.add(line.split(","));
        }
        
        while (scanner.hasNextLine()) {
            String[] newSchedule = scanner.nextLine().split(",");
            String startNew = newSchedule[0];
            String endNew = newSchedule[1];
            boolean overlap = false;
            
            for (String[] existingSchedule : schedules) {
                String startExisting = existingSchedule[0];
                String endExisting = existingSchedule[1];
                
                if (doOverlap(startExisting, endExisting, startNew, endNew)) {
                    overlap = true;
                    System.out.println(startNew + " - " + endNew + " は重複しています");
                    break;
                }
            }
            
            if (!overlap) {
                System.out.println(startNew + " - " + endNew + " は重複しません");
            }
        }
        
        scanner.close();
    }
    
    public static boolean doOverlap(String start1, String end1, String start2, String end2) {
        return !((end1.compareTo(start2) <= 0) || (end2.compareTo(start1) <= 0));
    }
}