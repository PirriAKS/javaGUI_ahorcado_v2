import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame {
    private JTextField txt_user;
    private JPanel container;
    private JPanel arriba;
    private JPanel medio;
    private JPanel abajo;
    private JLabel field_1;
    private JLabel field_2;
    private JLabel field_3;
    private JLabel field_4;
    private JLabel label_intentos;
    private JButton button_introduce;
    private JButton button_pista;
    private JLabel label_imagen;
    private JTextField txt_palabra;
    private JPanel introduce;
    private JButton button_generar;
    private JLabel field_5;
    private JLabel field_6;
    private JTextField txt_tema;
    private JTextField txt_hint;
    private JLabel label_tema;
    private JLabel field_7;
    private JLabel field_8;
    private JLabel field_9;
    private JLabel field_10;
    private static int vidas = 6;
    ImageIcon icon_aorc0 = new ImageIcon("src/main/java/imagenes/aorcado0.JPG");
    ImageIcon icon_bombilla = new ImageIcon("src/main/java/imagenes/bombilla.png");
    ImageIcon icon_aorc1 = new ImageIcon("src/main/java/imagenes/aorcado1.JPG");
    ImageIcon icon_aorc2 = new ImageIcon("src/main/java/imagenes/aorcado2.JPG");
    ImageIcon icon_aorc3 = new ImageIcon("src/main/java/imagenes/aorcado3.JPG");
    ImageIcon icon_aorc4 = new ImageIcon("src/main/java/imagenes/aorcado4.JPG");
    ImageIcon icon_aorc5 = new ImageIcon("src/main/java/imagenes/aorcado5.JPG");
    ImageIcon icon_aorc6 = new ImageIcon("src/main/java/imagenes/aorcado6.JPG");
    private static App a = new App();
    private static Objeto o = new Objeto();
    private static ArrayList objetos = new ArrayList<Objeto>();
    private static char[] letras;
    private static int cont_vidas;
    private static int cont_add;
    private static String pista;

    public App() {
        button_pista.setIcon(icon_bombilla);
        arriba.setVisible(false);
        medio.setVisible(false);
        abajo.setVisible(false);
        button_pista.setEnabled(false);
        label_imagen.setIcon(icon_aorc0);
        label_intentos.setText(Integer.toString(vidas));
        button_generar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = Add();
                if (flag) {
                    Extract(Random());
                    PaintWord();
                    Visible();
                }
            }
        });
        button_introduce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = txt_user.getText().toLowerCase();
                if (valor.equals("")) {
                    JOptionPane.showMessageDialog(container, "Introduce letra");
                } else {
                    char letra = valor.charAt(0);
                    Compare(letra);
                    SetIco();
                    CheckLife();
                }
            }
        });
        button_pista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(container, pista);
            }
        });
    }

    public static void main(String[] args) {
        Init();
    }

    private static void Init() {
        a.setContentPane(a.container);
        a.setVisible(true);
        a.setTitle("Ahorcado v.2");
        a.setSize(500, 500);
        //a.pack();
        a.txt_user.setDocument(new LimitJTextField(1));
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static boolean Add() {
        boolean flag = false;
        if (a.txt_palabra.getText().length() > 10) {
            JOptionPane.showMessageDialog(a.container, "Introduce una palabra de hasta 10 letras");
            Erase();
        } else if (a.txt_palabra.getText().equals("")) {
            JOptionPane.showMessageDialog(a.container, "Inserta una letra");
            Erase();
        } else {
            o = new Objeto(a.txt_palabra.getText().toLowerCase(), a.txt_tema.getText().toLowerCase(), a.txt_hint.getText().toLowerCase());
            objetos.add(o);
            cont_add = cont_add + 1;
            Erase();
        }
        if (cont_add == 5) {
            flag = true;
        }
        return flag;
    }

    private static void Erase() {
        a.txt_palabra.setText("");
        a.txt_tema.setText("");
        a.txt_hint.setText("");
    }

    private static Objeto Random() {
        int numeroAleatorio = (int) (Math.random() * 4);
        Objeto o = (Objeto) objetos.get(numeroAleatorio);
        return o;
    }

    private static void Compare(char letra) {
        boolean flag = false;
        int cont_letrarepetida = 0;
        for (int i = 0; i < letras.length; i++) {
            if (letra == letras[i]) {
                flag = true;
                switch (i) {
                    case 0:
                        a.field_1.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 1:
                        a.field_2.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 2:
                        a.field_3.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 3:
                        a.field_4.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 4:
                        a.field_5.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 5:
                        a.field_6.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 6:
                        a.field_7.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 7:
                        a.field_8.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 8:
                        a.field_9.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                    case 9:
                        a.field_10.setText(String.valueOf(letra));
                        cont_letrarepetida = cont_letrarepetida + 1;
                        break;
                }
            }
        }
        if (cont_letrarepetida == 2) {
            cont_vidas = cont_vidas + 1;
        } else if (cont_letrarepetida == 3) {
            cont_vidas = cont_vidas + 2;
        } else if (cont_letrarepetida == 4) {
            cont_vidas = cont_vidas + 3;
        } else if (cont_letrarepetida == 5) {
            cont_vidas = cont_vidas + 4;
        } else if (cont_letrarepetida == 6) {
            cont_vidas = cont_vidas + 5;
        } else if (cont_letrarepetida == 7) {
            cont_vidas = cont_vidas + 6;
        } else if (cont_letrarepetida == 8) {
            cont_vidas = cont_vidas + 7;
        } else if (cont_letrarepetida == 9) {
            cont_vidas = cont_vidas + 8;
        } else if (cont_letrarepetida == 10) {
            cont_vidas = cont_vidas + 9;
        } else {
            cont_vidas = cont_vidas;
        }
        cont_letrarepetida = 0;
        if (!flag) {
            vidas = vidas - 1;
            a.label_intentos.setText(Integer.toString(vidas));
        } else {
            cont_vidas = cont_vidas + 1;
            vidas = vidas;
        }
        a.txt_user.setText("");
    }

    private static void Extract(Objeto o) {
        char[] letras_array = new char[o.getNombre().length()];
        for (int i = 0; i < o.getNombre().length(); i++) {
            letras_array[i] = o.getNombre().charAt(i);
        }
        letras = letras_array;
        a.label_tema.setText(o.getTema());
        pista = o.getPista();
    }

    private static void Visible() {
        a.arriba.setVisible(true);
        a.medio.setVisible(true);
        a.abajo.setVisible(true);
        a.introduce.setVisible(false);
    }

    private static void PaintWord() {
        switch (letras.length) {
            case 1:
                a.field_1.setText("_");
                break;
            case 2:
                a.field_1.setText("_");
                a.field_2.setText("_");
                break;
            case 3:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                break;
            case 4:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                a.field_4.setText("_");
                break;
            case 5:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                a.field_4.setText("_");
                a.field_5.setText("_");
                break;
            case 6:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                a.field_4.setText("_");
                a.field_5.setText("_");
                a.field_6.setText("_");
                break;
            case 7:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                a.field_4.setText("_");
                a.field_5.setText("_");
                a.field_6.setText("_");
                a.field_7.setText("_");
                break;
            case 8:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                a.field_4.setText("_");
                a.field_5.setText("_");
                a.field_6.setText("_");
                a.field_7.setText("_");
                a.field_8.setText("_");
                break;
            case 9:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                a.field_4.setText("_");
                a.field_5.setText("_");
                a.field_6.setText("_");
                a.field_7.setText("_");
                a.field_8.setText("_");
                a.field_9.setText("_");
                break;
            case 10:
                a.field_1.setText("_");
                a.field_2.setText("_");
                a.field_3.setText("_");
                a.field_4.setText("_");
                a.field_5.setText("_");
                a.field_6.setText("_");
                a.field_7.setText("_");
                a.field_8.setText("_");
                a.field_9.setText("_");
                a.field_10.setText("_");
                break;
        }
    }

    private static void SetIco() {
        switch (vidas) {
            case 5:
                a.label_imagen.setIcon(a.icon_aorc1);
                break;
            case 4:
                a.label_imagen.setIcon(a.icon_aorc2);
                break;
            case 3:
                a.label_imagen.setIcon(a.icon_aorc3);
                break;
            case 2:
                a.label_imagen.setIcon(a.icon_aorc4);
                break;
            case 1:
                a.label_imagen.setIcon(a.icon_aorc5);
                break;
            case 0:
                a.label_imagen.setIcon(a.icon_aorc6);
                break;
        }
    }

    private static void CheckLife() {
        //si queda 1 vida enseñamos el boton de pista
        if (vidas == 1) {
            a.button_pista.setEnabled(true);
        }
        //si se completan todos los if se gana, si vidas llega a 0 se pierde
        if (cont_vidas == letras.length) {
            JOptionPane.showMessageDialog(a.container, "GANASTE!");
            System.exit(0);
        } else if (vidas == 0) {
            JOptionPane.showMessageDialog(a.container, "PERDISTE!");
            System.exit(0);
        }
    }

    static class LimitJTextField extends PlainDocument {
        private int max;

        LimitJTextField(int max) {
            super();
            this.max = max;
        }

        public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
            if (text == null)
                return;
            if ((getLength() + text.length()) <= max) {
                super.insertString(offset, text, attr);
            }
        }
    }
}
