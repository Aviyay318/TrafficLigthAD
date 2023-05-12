import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Road extends JPanel {
    private BufferedImage road;
    private List<TrafficLight> trafficLight;
    private Car car;
    public Road(int x,int y,int width,int height){
       this.setBounds(x,y,width,height);
       this.setLayout(null);
       this.trafficLight = new ArrayList<>();
       createTrafficList();
       createBackGround();
       this.car =  new Car(10,450,80,80);
       this.car.start();
       gameLoop();
    }

    private void createTrafficList() {
        this.trafficLight.add(new TrafficLight(new Entity(500,450,40,80)));
        this.trafficLight.add(new TrafficLight(new Entity(800,450,40,80)));
      //  this.trafficLight.add(new TrafficLight(new Entity(500,200,40,80)));
      //  this.trafficLight.add(new TrafficLight(new Entity(800,200,40,80)));
        for (TrafficLight t:this.trafficLight) {
            t.start();
        }



    }

    private void createBackGround() {
        try {
            this.road = ImageIO.read(new File("res/road_1.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void gameLoop(){
        new Thread(()->{
           while (true){
               for (TrafficLight t:this.trafficLight) {
                       if(!t.needToStop(this.car)){
                           this.car.setCanDrive(true);
                       }else {
                           this.car.setCanDrive(false);
                       }
                       break;
                   }

             Utils.sleep(25);
             repaint();
           }
        }).start();
    }



    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(this.road,0,0,Constants.WIDTH,Constants.HEIGHT,null);
        for (TrafficLight t:this.trafficLight) {
            t.paint(graphics);
        }
        this.car.paint(graphics);

    }

}
