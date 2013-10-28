package StorePackage;
import java.awt.*;
import java.util.*;

public abstract class Store {
	/**
	 * |		|		 |		 |		  |		   |
	 * |     	|		 |		 |		  |		   |
	 * |   __	|   __	 |		 |   __	  |	  __   |
	 * |--|  |--|--|  |--|		 |--|  |--|--|  |--|
	 * |										   |
	 * |										   |
	 * |										   |
	 * |--|  |--|--|  |--|       |--|  |--|--|  |--|
	 * |  ````  |  ````  |		 |  ````  |  ````  |
	 * |		|		 |		 |		  |  PUB!  |
	 * |--------|--------|		 |--------|--------|
	 */
	public Point LEFT_LEFT, LEFT_MID, LEFT_RIGHT, RIGHT_LEFT, RIGHT_MID, RIGHT_RIGHT;
	public ArrayList<Point> Border = new ArrayList();
	abstract void setDimension();
	/**
	 * Added points of border into the Border ArrayList
	 */
	protected void setBorder() {
		for (int i = 0; i < 20; i++) {
			Border.add(new Point((int)LEFT_LEFT.getX() + i, (int)LEFT_LEFT.getY()));
		}
		for (int j = 0; j < 30; j++) {
			Border.add(new Point((int)LEFT_MID.getX(), (int)LEFT_MID.getY()+j));
		}
		for (int k = 0; k < 60; k++) {
			Border.add(new Point((int)LEFT_RIGHT.getX()+k, (int)LEFT_RIGHT.getY()));
		}
		for (int l = 0; l < 30; l++) {
			Border.add(new Point((int)RIGHT_LEFT.getX(), (int)RIGHT_LEFT.getY()-l));
		}
		for (int m = 0; m < 21; m++) {
			Border.add(new Point((int)RIGHT_MID.getX()+m, (int)RIGHT_MID.getY()));
		}
	}
	/**
	 * @return border in array format
	 */
	public Point[] getBorder() {
		Point[] B = new Point[Border.size()];
		for (int i = 0; i < Border.size(); i++) {
			B[i] = Border.get(i);
		}
		return B;
	}
	
	/**
	 * 
	 * @return border in arrayList format
	 */
	public ArrayList<Point> getArrayListBorder() {
		return Border;
	}
}
