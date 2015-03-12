//GraphingCalculator.java

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GraphingCalculator extends JFrame {
	
	public static Scanner keyb;
	public static int width;
	public static int height;
	public static Graphics g;
	public static double[] domain;
	
	public static void main (String args[]) {
		width=800;
		height=600;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setTitle("Greg's Graphing Calculator");
		g = frame.getGraphics();
		g.setColor(Color.RED);
		
		keyb = new Scanner(System.in);
		System.out.print("Choose one of the following (#):\n1. Linear\n2. Quadratic\n3. Cubic\n4. Sine\n5. Cosine\n6. Tangent\n7. Arc Sine\n8. Arc Cosine\n9. Arc Tangent\n10. Hyperbolic Sine\n11. Hyperbolic Cosine\n12. Hyperbolic Tangent\n13. Log Base-10\n14. Natural Log\n15. e^x\n16. Square Root\n17. Cube Root\n18. Power Base-b\n19. Absolute Value\n20. Rational\n> ");
		int selection = keyb.nextInt();
		
		int px = 0;
		int py = 0;
		
		if(selection == 1) {
			System.out.print("\nFor the equation 'y = mx + b'...\nEnter m: ");
			double m = keyb.nextDouble();
			System.out.print("Enter b: ");
			double b = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = m * x + b;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = m * x + b;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 2) {
			System.out.print("\nFor the equation 'y = ax^2 + bx + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter b: ");
			double b = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextInt();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.pow(x,2) + b * x + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.pow(x,2) + b * x + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 3) {
			System.out.print("\nFor the equation 'y = ax^3 + bx^2 + cx + d'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter b: ");
			double b = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.pow(x,3) + b * Math.pow(x,2) + c * x + d;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.pow(x,3) + b * Math.pow(x,2) + c * x + d;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 4) {
			System.out.print("\nFor the equation 'y = a * sin(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.sin(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.sin(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 5) {
			System.out.print("\nFor the equation 'y = a * cos(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.cos(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.cos(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 6) {
			System.out.print("\nFor the equation 'y = a * tan(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.tan(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.tan(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 7) {
			System.out.print("\nFor the equation 'y = a * arcsin(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.asin(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.asin(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 8) {
			System.out.print("\nFor the equation 'y = a * arccos(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.acos(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.acos(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 9) {
			System.out.print("\nFor the equation 'y = a * arctan(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.atan(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.atan(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 10) {
			System.out.print("\nFor the equation 'y = a * sinh(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.sinh(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.sinh(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 11) {
			System.out.print("\nFor the equation 'y = a * cosh(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.cosh(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.cosh(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 12) {
			System.out.print("\nFor the equation 'y = a * tanh(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.tanh(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.tanh(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 13) {
			System.out.print("\nFor the equation 'y = a * log10(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.log10(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.log10(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 14) {
			System.out.print("\nFor the equation 'y = a * ln(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.log(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.log(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 15) {
			System.out.print("\nFor the equation 'y = a * e^(k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.exp(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.exp(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 16) {
			System.out.print("\nFor the equation 'y = a * (k(x - d))^(1/2) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.sqrt(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.sqrt(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 17) {
			System.out.print("\nFor the equation 'y = a * (k(x - d))^(1/3) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.cbrt(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.cbrt(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 18) {
			System.out.print("\nFor the equation 'y = a * b^(k(x - d)) + c'...\nEnter base: ");
			double b = keyb.nextDouble();
			System.out.print("Enter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.pow(b, k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.pow(b, k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 19) {
			System.out.print("\nFor the equation 'y = a * |k(x - d)| + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a * Math.abs(k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a * Math.abs(k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		} else if(selection == 20) {
			System.out.print("\nFor the equation 'y = (a / k(x - d)) + c'...\nEnter a: ");
			double a = keyb.nextDouble();
			System.out.print("Enter k: ");
			double k = keyb.nextDouble();
			System.out.print("Enter d: ");
			double d = keyb.nextDouble();
			System.out.print("Enter c: ");
			double c = keyb.nextDouble();
			domain = getDomain();
			System.out.print("x\ty\n");
			
			for(double x=domain[0]; x<domain[1]+domain[2]; x+=domain[2]) {
				double y = a / (k * (x - d)) + c;
				System.out.println(x + "\t" + y);
				int tx = xValToPixel(x);
				int ty = yValToPixel(y);
				g.fillOval(tx-3,ty-3,6,6);
			}
			
			drawAxis();
			Boolean isFirst = false;
			
			for(int gx=0; gx<width; gx++) {
				double x = xPixelToVal(gx);
				double y = a / (k * (x - d)) + c;
				int gy = yValToPixel(y);
				
				if(Double.isNaN(y)) {
					isFirst = true;
				} else {
					if(gx == 0 || isFirst) {
						isFirst = false;
						px = gx;
						py = gy;
					} else if(py >= height && gy <= 0) {
						g.drawLine(gx,0,gx,gy);
						px = gx;
						py = gy;
					} else if(gy >= height && py <= 0) {
						g.drawLine(gx,height,gx,gy);
						px = gx;
						py = gy;
					} else {
						g.drawLine(px,py,gx,gy);
						px = gx;
						py = gy;
					}
				}
			}
		}
		
		frame.setVisible(true);
	}
	
	public static double[] getDomain() {
		System.out.print("\nStarting x (Table / x-Zoom)? ");
		double start = keyb.nextDouble();
		System.out.print("Ending x (Table / x-Zoom)? ");
		double end = keyb.nextDouble();
		System.out.print("Increment (Table)? ");
		double step = keyb.nextDouble();
		System.out.print("Minimum y on graph (y-Zoom)? ");
		double miny = keyb.nextDouble();
		System.out.print("Maximum y on graph (y-Zoom)? ");
		double maxy = keyb.nextDouble();
		System.out.println("");
		double[] r = {start, end, step, miny, maxy};
		return(r);
	}
	
	public static void drawAxis() {
		g.setColor(Color.BLUE);
		int xa = xValToPixel(0);
		g.drawLine(xa,0,xa,height);
		int ya = yValToPixel(0);
		g.drawLine(0, ya, width, ya);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString((int)Math.round(domain[0])),10,ya+12);
		g.drawString(Integer.toString((int)Math.round(domain[1])),width-41,ya+12);
		g.drawString(Integer.toString((int)Math.round(domain[3])),xa+2,height-10);
		g.drawString(Integer.toString((int)Math.round(domain[4])),xa+2,41);
	}
	
	public static double xPixelToVal(int i) {
		double v = i * (domain[1]-domain[0]) / width + domain[0];
		return(v);
	}
	
	public static int xValToPixel(double v) {
		int i = (int) Math.round(((v - domain[0]) / (domain[1]-domain[0])) * width);
		return(i);
	}
	
	public static int yValToPixel(double v) {
		int i = -(int) Math.round(((v - domain[3]) / (domain[4]-domain[3])) * height) + height;
		return(i);
	}
}

