import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class PanelJuego extends JPanel {

    public PanelJuego() {
        setLayout(new BorderLayout());

        PanelPerfil panelPerfil = new PanelPerfil();
        PanelTabs panelTabs = new PanelTabs();

        panelPerfil.setBackground(Color.BLUE);
        panelTabs.setBackground(Color.ORANGE);

        add(panelPerfil, BorderLayout.WEST);
        add(panelTabs, BorderLayout.CENTER);
    }
}
