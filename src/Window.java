import javax.swing.*;

public class Window extends JFrame {

    public Window(){
       this.setSize(Constants.WIDTH,Constants.HEIGHT);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setResizable(false);
       this.setLayout(null);
       this.add(new Road(0,0,Constants.WIDTH,Constants.HEIGHT));
       this.setVisible(true);
    }
}
