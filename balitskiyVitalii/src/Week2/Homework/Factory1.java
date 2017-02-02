package Week2.Homework;

/**
 * Created by vitalii on 30.01.17.
 */
public class Factory1 {

    public static void main(String[] args) {

        Factory factory = new SamsungFactory();
        Radio radio = factory.getRadio();
        Telephone phone = factory.getPhone();
        TVSet televizor = factory.getTV();

        radio.turnOn();
        televizor.turnOn();
        phone.ring();
    }



}

interface TVSet{
    void turnOn();
}

interface Radio{
    void turnOn();
}

interface Telephone{
    void ring();
        }

class SamsungTV implements TVSet{

    @Override
    public void turnOn() {
        System.out.println("Dobrui ve4ir druzi @SAMSUNG");
    }
}
class SamsungRadio implements Radio{

    @Override
    public void turnOn() {
        System.out.println("Kyiv na zvyazku @SAMSUNG");
    }
}

class SamsungPhone implements Telephone{

    @Override
    public void ring() {
        System.out.println("Vizmit sluhavku @SAMSUNG");
    }
}

interface Factory{
    TVSet getTV();
    Radio getRadio();
    Telephone getPhone();
}

class SamsungFactory implements Factory{

    @Override
    public TVSet getTV() {
        return new SamsungTV();
    }

    @Override
    public Radio getRadio() {
        return new SamsungRadio();
    }

    @Override
    public Telephone getPhone() {
        return new SamsungPhone();
    }
}