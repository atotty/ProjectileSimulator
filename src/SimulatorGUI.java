import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulatorGUI extends JFrame {
    private List<Projectile> projectileList = new ArrayList<>();
    private boolean loaded = false;
    SimulatorPanel sim = new SimulatorPanel();

    public SimulatorGUI() {
        // info bar
        int textFieldChars = 4;
        JTextField xInput = new JTextField(textFieldChars);
        JTextField yInput = new JTextField(textFieldChars);
        JTextField speedInput = new JTextField(textFieldChars);
        JTextField angleInput = new JTextField(textFieldChars);
        JTextField timeInput = new JTextField(textFieldChars);

        List<JTextField> textFields = Arrays.asList(xInput, yInput, speedInput, angleInput, timeInput);

        JPanel infoBar = new JPanel();
        String[] labels = {"x: ", "y: ", "speed: ", "angle (deg): ", "time steps: "};
        int i = 0;
        for (JTextField textField : textFields) {
            Box vbox = Box.createVerticalBox();
            vbox.add(new JLabel(labels[i], null, JLabel.RIGHT));
            vbox.add(Box.createHorizontalStrut(10));
            vbox.add(textField);
            vbox.add(Box.createHorizontalStrut(10));
            infoBar.add(vbox);
            i++;
        }

        // buttons
        JButton addProjectileButton = new JButton("Add projectile");
        addProjectileButton.addActionListener(e -> {
            List<String> inputs = new ArrayList<>();
            for (JTextField textField : textFields) {
                String input = textField.getText();
                if (input == null || input.equals("")) {
                    return;
                }
                inputs.add(input);
            }

            projectileList.add(new Projectile(  Double.parseDouble(inputs.get(0)), // x
                                                Double.parseDouble(inputs.get(1)), // y
                                                Double.parseDouble(inputs.get(2)), // speed
                                                Double.parseDouble(inputs.get(3)), // angle
                                                Integer.parseInt(inputs.get(4))    // timeSteps
                                            ));
            loaded = true;

            sim.drawProjectiles(projectileList);
            System.out.println("Projectile created! " + projectileList.get(projectileList.size()-1));
        });

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(e -> updateProjectiles());
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            projectileList.clear();
            updateProjectiles();
        });

        // button panel
        JPanel buttonBar = new JPanel();
        buttonBar.add(addProjectileButton);
        buttonBar.add(stepButton);
        buttonBar.add(clearButton);

        // control panel
        Box controlPanel = Box.createVerticalBox();
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(infoBar);
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(buttonBar);

        // put it all under the simulator panel
        Box vbox = Box.createVerticalBox();
        vbox.add(Box.createVerticalStrut(10));
        vbox.add(sim);
        vbox.add(Box.createVerticalStrut(10));
        vbox.add(controlPanel);
        vbox.add(Box.createVerticalStrut(10));

        Container c = this.getContentPane();
        c.add(vbox);
    }

    private void updateProjectiles() {
        for (Projectile proj : projectileList) {
            int step = proj.step();
            System.out.println("Step: " + step + " " + proj);
        }
        sim.drawProjectiles(projectileList);
    }
}
