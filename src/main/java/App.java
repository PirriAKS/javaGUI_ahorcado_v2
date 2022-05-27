import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    private JTextField txt_user;
    private JPanel container;
    private JPanel arriba;
    private JPanel medio;
    private JPanel abajo;
    private JLabel field_j;
    private JLabel field_a_1;
    private JLabel field_v;
    private JLabel field_a_2;
    private JLabel label_intentos;
    private JButton button_introduce;
    private JButton button_pista;
    private static int vidas=3;
    ImageIcon icon = new ImageIcon("src/main/java/imagenes/bombilla.png");

    public App() {
        //añadimos el icono de la bombilla al boton
        button_pista.setIcon(icon);
        //desactivamos el boton de pista
        button_pista.setEnabled(false);
        //ponemos el textfield de vidas igual al valor de la variable
        label_intentos.setText(Integer.toString(vidas));

        //action listener
        button_introduce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //recogemos el valor que introduce el usuario
                String valor=txt_user.getText();
                //realizamos las comparativas
                if(valor.equals("")){
                    JOptionPane.showMessageDialog(container,"Introduce un valor");
                }else if (valor.length()>=2){
                    JOptionPane.showMessageDialog(container,"Introduce sólo una letra");
                }else if(valor.equals("j")){
                    field_j.setText("j");
                }else if(valor.equals("a")){
                    field_a_1.setText("a");
                    field_a_2.setText("a");
                }else if(valor.equals("v")){
                    field_v.setText("v");
                }else{
                    vidas=vidas-1;
                    label_intentos.setText(Integer.toString(vidas));
                }
                //vaciamos el textfield
                txt_user.setText("");
                //si queda 1 vida enseñamos el boton de pista
                if(vidas==1){
                    button_pista.setEnabled(true);
                }
                //si se completan todos los if se gana, si vidas llega a 0 se pierde
                if(field_j.getText().equals("j")&&field_a_1.getText().equals("a")&&field_v.getText().equals("v")&&field_a_2.getText().equals("a")){
                    JOptionPane.showMessageDialog(container,"GANASTE!");
                    setVisible(false);
                }else if(vidas==0){
                    JOptionPane.showMessageDialog(container,"PERDISTE!");
                    setVisible(false);
                }
            }
        });

        //cuando se pulsa el boton de pista muestra un mensaje en pantalla
        button_pista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(container,"Lenguaje de programación");
            }
        });
    }

    //Ejecutable que realiza el metodo Init()
    public static void main(String[] args) {
        Init();
    }

    //clase con la cual arrancamos nuestro programa, siempre es igual, sólo se cambia el titulo y el nombre de la variable container
    private static void Init(){
        App a=new App();
        a.setContentPane(a.container);
        a.setVisible(true);
        a.setTitle("Ahorcado v.2");
        a.pack();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
