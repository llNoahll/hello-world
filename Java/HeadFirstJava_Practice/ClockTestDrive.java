package clocktestdrive;

import java.util.Scanner;


class Clock
{
    private String time;
    public String getTime() {
        return time;
    }
    public void setTime(String new_time) {
        time = new_time;
    }
}


public class ClockTestDrive
{
    public static void main(String[] args)
    {
        Clock c = new Clock();
        c.setTime("1245");
        String tod = c.getTime();
        System.out.println("Time: " + tod);
    }
}
