import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SimulatorPanel extends JPanel {
    private List<Projectile> projectileList = new ArrayList<>();
    private int projectileSize = 10;
    private int groundLevel = 50;
    private Color[] colors = {
                                Color.BLUE,
                                Color.GREEN,
                                Color.RED,
                                Color.ORANGE,
                                Color.MAGENTA,
                                Color.YELLOW,
                                Color.BLACK
                             };
    private Color skyColor = new Color(0xD2E6F1);
    private Color grassColor = new Color(0x76CE3D);
    private Color dirtColor = new Color(0x89755D);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // sky
        g.setColor(skyColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        // ground
        g.setColor(grassColor);
        g.fillRect(0, getHeight()-groundLevel, getWidth(), groundLevel);
        g.setColor(dirtColor);
        g.fillRect(0, getHeight()-(groundLevel-10), getWidth(), groundLevel-10);

        // projectiles
        int i = 0;
        for (Projectile p : projectileList) {
            g.setColor(colors[i]);
            int y = (int)(getHeight()-groundLevel-p.getYPos()-projectileSize);
            g.fillOval((int)p.getXPos(), y, projectileSize, projectileSize);
            i++;
            i %= colors.length;
        }
    }

    public void drawProjectiles(List<Projectile> projectileList) {
        this.projectileList = projectileList;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}
