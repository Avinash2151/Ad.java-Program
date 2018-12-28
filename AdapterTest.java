import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class AdapterTest extends JFrame implements ActionListener
{
	int X,Y;
	String str;
	JButton b;
	JLabel l;
	
	public AdapterTest()
	{
		super("The Adapter Test");
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel p=new JPanel();
		p.setLayout(new FlowLayout());
		
		l=new JLabel(str+X+Y);
		getContentPane().add(l);
		b=new JButton("quit");
		b.addActionListener(this);
		p.add(b);
		
		getContentPane().add(p);
		ListenerClass listen=new ListenerClass();
		addMouseListener(listen);
		setSize(300,300);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
		if("quit".equals(s))
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		AdapterTest t=new AdapterTest();
	}
}

class ListenerClass extends MouseAdapter
{
	public void mouseClicked(MouseEvent ea)
	{
		AdapterTest at;
		at=(AdapterTest)ea.getSource();
		at.l.setText("Mouse clicked at:"+ea.getX()+""+ea.getY());
	}
}