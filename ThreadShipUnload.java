package com.gmail.theslavahero;

import java.util.Arrays;

public class ThreadShipUnload extends Thread {

	private Ship ship;
	private Dock[] docks;

	public ThreadShipUnload(Ship ship, Dock[] docks) {
		super();
		this.ship = ship;
		this.docks = docks;
	}

	public ThreadShipUnload() {
		super();
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Dock[] getDocks() {
		return docks;
	}

	public void setDocks(Dock[] docks) {
		this.docks = docks;
	}

	public void run() {
		for (int i = 0; i <= docks.length; i++) {
			if (i == docks.length) {
				i = 0;
			}
			if (docks[i].isFree()) {

				try {
					this.sleep(ship.unloadToDock(docks[i]) * 1000);
					docks[i].setFree(true);
					
					break;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if (ship.getAmountOfContainers() == 0) {
			System.out.println("Ship has been unloaded.");
		}
	}

	@Override
	public String toString() {
		return "ThreadShipUnload [ship=" + ship + ", docks=" + Arrays.toString(docks) + "]";
	}

}
