import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TrafficLight extends Thread {

    private int color;
    public static final int RED = 1;
    public static final int GREEN = 2;
    private int type;
    public static final int HUMAN = 1;
    public static final int CAR = 2;

    private Entity entity;
    private Map<Integer, Integer> trafficTime;

    public TrafficLight(Entity entity) {
        this.trafficTime = new HashMap<>();
        setTime();
        this.entity = entity;
    }

    private void setTime() {
        Random random = new Random();
        this.trafficTime.put(1, random.nextInt(3, 8));
        this.trafficTime.put(2, random.nextInt(2, 7));
        this.color = random.nextInt(1, 3);
    }

    private void changeColor() {
        Utils.sleep(this.trafficTime.get(this.color) * 1000);
        switch (this.color) {
            case RED -> this.color = GREEN;
            case GREEN -> this.color = RED;
        }
    }

    public boolean needToStop(Car car) {
        boolean stop = false;
        int distance = this.entity.getX() - car.distance();
        if (distance <= 30 && distance >= 0) {
            if (this.color == RED) {
                stop = true;
            } else {
            }
        }
        System.out.println("distance : " + distance + " can drive : " + stop + " light : " + this.color);
        return stop;
    }

    private Color paintColor() {
        Color myColor = null;
        switch (this.color) {
            case RED -> myColor = Color.RED;
            case GREEN -> myColor = Color.GREEN;
        }
        return myColor;
    }

    public void run() {
        while (true) {
            changeColor();
        }
    }


    public boolean isPassed(Car car){
        boolean isPassed = false;
        if (this.entity.getX()<car.getX()){
            System.out.println(this.entity.getX()+" tttttttt " +car.getX());
            isPassed = true;
        }
        return isPassed;
    }
    public void paint(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(this.entity.getX(), this.entity.getY(), this.entity.getWidth(), this.entity.getHeight());
        graphics.setColor(paintColor());
        graphics.fillOval(this.entity.getX() + 4, this.entity.getY(), 30, 30);
    }
}
