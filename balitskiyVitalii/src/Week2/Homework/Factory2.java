package Week2.Homework;

/**
 * Created by vitalii on 30.01.17.
 */
public class Factory2 {
    public static void main(String[] args) {
        AlarmFactory factory = new MisterFactory();
        Alarm clock = factory.geClocktAlarm();
        Alarm mom = factory.getMomAlarm();
        Alarm cock = factory.getCockAlarm();

        clock.snooze();
        mom.snooze();
        cock.snooze();
    }
}

interface Alarm{
    void snooze();
}
class ClockAlarm implements Alarm{

    @Override
    public void snooze() {
        System.out.println("Pi pi piiii");
    }
}
class MomAlarm implements Alarm{

    @Override
    public void snooze() {
        System.out.println("Hey get up guy its morning");
    }
}
class CockAlarm implements Alarm{

    @Override
    public void snooze() {
        System.out.println("KuKuRiKu");
    }
}
interface AlarmFactory{
    Alarm geClocktAlarm();
    Alarm getMomAlarm();
    Alarm getCockAlarm();
}
class MisterFactory implements AlarmFactory{

    @Override
    public Alarm geClocktAlarm() {
        return new ClockAlarm();
    }

    @Override
    public Alarm getMomAlarm() {
        return new MomAlarm();
    }

    @Override
    public Alarm getCockAlarm() {
        return new CockAlarm();
    }
}