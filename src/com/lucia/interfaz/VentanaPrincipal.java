import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

    private PanelInicio panelInicio;
    private JPanel panelPrueba1; // Placeholder - Panel Partida
    private JPanel panelPrueba2; // Placeholder - Panel Puntuaciones
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        setTitle("Especulacion Financiera para Dummies");
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Paneles
        panelInicio = new PanelInicio();
        panelPrueba1 = new JPanel();
            panelPrueba1.setBackground(Color.GREEN);
        panelPrueba2 = new JPanel();
            panelPrueba2.setBackground(Color.MAGENTA);

        // Funcionalidad botones del panelInicio
        panelInicio.getBtnNuevaPrt().addActionListener(e -> cardLayout.show(getContentPane(), "panelP1"));
        panelInicio.getBtnCargarPrt().addActionListener(e -> cardLayout.show(getContentPane(), "panelP1"));
        panelInicio.getBtnPuntuacion().addActionListener(e -> cardLayout.show(getContentPane(), "panelP2"));

        add(panelInicio, "panelInicio");
        add(panelPrueba1, "panelP1");
        add(panelPrueba2, "panelP2");

        cardLayout.show(getContentPane(), "panelInicio");
    }

    public static void main(String[] args) { // Prueba
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
