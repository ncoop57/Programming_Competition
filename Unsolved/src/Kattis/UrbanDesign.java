package Kattis;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UrbanDesign {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int points = 0;

		ArrayList<Line2D> lines = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
				Line2D line = new Line2D.Float(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
				lines.add(line);
		}
		
		
		
		points = scan.nextInt();
		Point2D p1;
		Point2D p2;
		
		for(int j = 0; j < points; j++) {
			String id1 = "";
			String id2 = "";
			p1 = new Point2D.Float(scan.nextInt(), scan.nextInt());
			p2 = new Point2D.Float(scan.nextInt(), scan.nextInt());
			Line2D line = new Line2D.Float(p1, p2);
			int counter = 0;
			for(int i = 0; i<lines.size(); i++){

				if (line.intersectsLine(lines.get(i)))
					counter++;

				/*if(lines.get(i).relativeCCW(p1)<0) {
					id1 += "0";
				}else {
					id1 += "1";
				}
				if(lines.get(i).relativeCCW(p2)<0) {
					id2 += "0";
				}else {
					id2 += "1";
				}*/
			}

//			BigInteger pid1 = new BigInteger(id1, 2);
//			BigInteger pid2 = new BigInteger(id2, 2);
//			BigInteger xor = pid1.xor(pid2);

			if (counter % 2 == 1) {
				System.out.println("different");
			}else {
				System.out.println("same");
			}
				
		}
	}

}