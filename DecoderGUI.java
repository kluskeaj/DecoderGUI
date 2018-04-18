import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DecoderGUI extends JFrame
{
    private JPanel panel;

    private JTextField messageText;
    private JTextField keyText;

    private JButton encodeButton;
    private JButton decodeButton;
    
    private JLabel messageLabel;
    private JLabel keyLabel;

    public DecoderGUI()
    {
        setTitle("Decoder");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        encodeButton = new JButton("Encode");
        decodeButton = new JButton("Decode");
        messageText = new JTextField(20);
        keyText = new JTextField(3);

        encodeButton.addActionListener(new ButtonHanlder());
        decodeButton.addActionListener(new ButtonHanlder());

        add(panel);
        panel.add(encodeButton);
        panel.add(decodeButton);
        panel.add(messageText);
        panel.add(keyText);

        setVisible(true);
    }

    private class ButtonHanlder implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource().equals(encodeButton))
            {
                messageText.setText(DecoderRing.encode(messageText.getText(),
                        Integer.valueOf(keyText.getText())));

            }
            else
            {
                messageText.setText(DecoderRing.decode(messageText.getText(),
                        Integer.valueOf(keyText.getText())));
            }

        }

    }

    public static void main(String[] args)
    {
        DecoderGUI app = new DecoderGUI();
    }

}
