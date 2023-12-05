package main;
import java.awt.*;
import javax.swing.*;


public class Gui extends JFrame {
	
	JTextField addsExecTime, subsExecTime, mulsExecTime, divsExecTime, ADDIExecTime, SUBIExecTime, lwExecTime,swExecTime;

    public void initialise() {
		/* Form */
		JLabel lbaddsExecTime = new JLabel("addsExecTime");
		addsExecTime = new JTextField();

		JLabel LBsubsExecTime = new JLabel("subsExecTime");
		subsExecTime = new JTextField();

		JLabel lbmulsExecTime = new JLabel("mulsExecTime");
		mulsExecTime = new JTextField();

		JLabel lbdivsExecTime = new JLabel("divsExecTime");
		divsExecTime = new JTextField();

		JLabel lbADDIExecTime = new JLabel("ADDIExecTime");
		ADDIExecTime = new JTextField();

		JLabel lbSUBIExecTime = new JLabel("SUBIExecTime");
		SUBIExecTime = new JTextField();

		JLabel lblwExecTime = new JLabel("lwExecTime");
		lwExecTime = new JTextField();

		JLabel lbswExecTime = new JLabel("swExecTime");
		swExecTime = new JTextField("swExecTime");

        JPanel formPanel =  new JPanel();
		formPanel.setLayout(new GridLayout(4,1,5,5));
		formPanel.add(addsExecTime);
		formPanel.add(subsExecTime);
		formPanel.add(mulsExecTime);
		formPanel.add(divsExecTime);
		formPanel.add(ADDIExecTime);
		formPanel.add(SUBIExecTime);
		formPanel.add(lwExecTime);
		formPanel.add(swExecTime);


        JPanel mainPanel = new JPanel(); 
        mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(128,128,255));
		mainPanel.add(formPanel,BorderLayout.NORTH);
        this.add(mainPanel);
        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String [] args){
		Gui myFrame = new Gui();
		myFrame.initialise();	
	}
}