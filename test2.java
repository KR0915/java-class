import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        
        List<String[]> schedules = new ArrayList<>();
        schedules.add(new String[]{"2022-10-15T09:30:00", "2022-10-15T11:00:00"});
        schedules.add(new String[]{"2022-10-15T10:30:00", "2022-10-15T12:00:00"});
        schedules.add(new String[]{"2022-10-15T12:30:00", "2022-10-15T13:30:00"});
        schedules.add(new String[]{"2022-10-15T15:30:00", "2022-10-15T16:30:00"});
        schedules.add(new String[]{"2022-10-15T16:00:00", "2022-10-15T17:00:00"});

        
        LocalDateTime startDateTime = LocalDateTime.parse("2022-10-15T09:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endDateTime = LocalDateTime.parse("2022-10-15T18:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        
        LocalDateTime currentDateTime = startDateTime;
        for (String[] schedule : schedules) {
            LocalDateTime scheduleStart = LocalDateTime.parse(schedule[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            LocalDateTime scheduleEnd = LocalDateTime.parse(schedule[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            if (currentDateTime.isBefore(scheduleStart)) {
                printInterval(currentDateTime, scheduleStart);
            }
            currentDateTime = scheduleEnd;
        }
        if (currentDateTime.isBefore(endDateTime)) {
            printInterval(currentDateTime, endDateTime);
        }
    }

    private static void printInterval(LocalDateTime start, LocalDateTime end) {
        if (start.plusHours(1).isBefore(end)) {
            System.out.println(start + " - " + start.plusHours(1));
            printInterval(start.plusHours(1), end);
        }
    }
}
