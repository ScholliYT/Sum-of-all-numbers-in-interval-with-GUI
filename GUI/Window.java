import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JFrame implements ActionListener
{
    private JLabel txtLowerInterval;
    private JLabel txtUpperInterval;
    private JLabel txtOutput;

    private JTextField inLowerInterval;
    private JTextField inUpperInterval;

    private JButton btnStart;

    public Window() {
        super("Sum of all numbers in interval");
        this.setSize(400, 300);
        this.setLocation(200, 200);
        this.setLayout(null);

        //Label
        txtLowerInterval= new JLabel("lower interval [incl.]");
        txtLowerInterval.setSize(150, 20);
        txtLowerInterval.setLocation(10, 10);
        this.add(txtLowerInterval
    );

        txtUpperInterval = new JLabel("upper interval [incl.]");
        txtUpperInterval.setSize(150, 20);
        txtUpperInterval.setLocation(200, 10);
        this.add(txtUpperInterval);

        //Input
        inLowerInterval = new JTextField();
        inLowerInterval.setSize(150, 20);
        inLowerInterval.setLocation(10, 40);
        this.add(inLowerInterval);

        inUpperInterval = new JTextField();
        inUpperInterval.setSize(150, 20);
        inUpperInterval.setLocation(200, 40);
        this.add(inUpperInterval);

        //Btn
        btnStart = new JButton("Start");
        btnStart.setSize(100, 20);
        btnStart.setLocation(150, 140);

        this.add(btnStart);
        btnStart.addActionListener(this);

        //Label
        txtOutput = new JLabel("Enter parameters first!");
        txtOutput.setSize(350, 20);
        txtOutput.setLocation(10, 200);
        this.add(txtOutput);

        sichtbarMachen();
    }

    public void sichtbarMachen() {
        this.setVisible(true); 
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnStart) {
            try {
                int a = Integer.parseInt(inLowerInterval.getText());
                int b = Integer.parseInt(inUpperInterval.getText());
                txtOutput.setText("The sum of all numbers from: " + a + ", to: " + b + " is: " + solve(a,b));
            } catch (NumberFormatException ignored) {
                txtOutput.setText("Wrong format!");
            }
        }
    } 

    private int solve(int a, int b)
    {
        System.out.println(a + " " + b);
        int result;
        if (a<=b)
            result = sum(a,b);
        else
            result = sum(b,a);
        return result;
    }

    private int sum(int a, int b)
    {
        int result = 0;
        while (a <=b) {
            result+=a;
            a++; 
        }
        return result;
    }
}
