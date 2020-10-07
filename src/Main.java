import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SimulatorGUI sim = new SimulatorGUI();
        sim.setSize(600, 400);
        sim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sim.setResizable(false);
        sim.setVisible(true);
    }
}
