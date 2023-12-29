import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class LinePanel extends JPanel{
	int x1,y1,x2,y2;
	boolean firstClicked = false;
	public LinePanel() {
		setSize(500,500);
		setLayout(null);
		addMouseListener(new MouseListener() {
					
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println(e.getX()+","+e.getY());
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (firstClicked == false) {
						x1 = e.getX();
						y1 = e.getY();
						System.out.println("1="+x1+","+y1);
						firstClicked = true;
					}else {
						x2 = e.getX();
						y2 = e.getY();
						System.out.println("2="+x2+","+y2);	
						ddaline(x1, y1, x2, y2);
						x1=x2;
						y1=y2;
					}
				}
			}
		});
	}
	
	void ddaline (int x1,int y1,int x2,int y2) {
		Graphics g = getGraphics();
		double dx,dy,x,y,step,m,xinc,yinc;
		dx = x2-x1;
		dy = y2-y1;
		
		if(Math.abs(dx)>Math.abs(dy)) {
			step = Math.abs(dx);
		} else {
			step = Math.abs(dy);
		}
		
		xinc = (dx/step);
		yinc = (dy/step);
		
		x=x1;
		y=y1;
		
		g.setColor(Color.red);
		g.fillOval((int)x, (int)y, 2, 2);
		
		for(float i = 1;i<=step;i++) {
			x=x+xinc;
			y=y+yinc;
			g.fillOval((int)x, (int)y, 2, 2);
		}
	
	}
}
