package StarTrek;

import java.util.Random;

import Untouchables.WebGadget;

public class Game {
	private static int MAX_RANGE = 4000;

	private int remainingEnergy = 10000;
	private int torpedoes = 8;

    public int energyRemaining() {
        return remainingEnergy;
    }

    public void setTorpedoes(int value) {
            torpedoes = value;
        }
    public int getTorpedoes() {
            return torpedoes;
        
    }

    public void fireWeapon(WebGadget wg) {
        fireWeapon(new Galaxy(wg));
    }

    public void fireWeapon(Galaxy wg) {
        if (wg.parameter("command").equals("phaser")) {
			int energyCostOfCommand = Integer.parseInt(wg.parameter("amount"));
			Klingon enemy = (Klingon) wg.variable("target");
			if (remainingEnergy >= energyCostOfCommand) {
				int distance = enemy.distance();
				if (distance > Game.MAX_RANGE) {
					wg.writeLine("Klingon out of range of phasers at " + distance + " sectors...");
				} else {
					int damage = calculateDamage(energyCostOfCommand, distance);
					wg.writeLine("Phasers hit Klingon at " + distance + " sectors with " + damage + " units");

					int enemyEnegyLeft = enemy.takeDamage(damage);
					if (enemyEnegyLeft > 0)
						wg.writeLine("Klingon has " + enemyEnegyLeft + " remaining");
					else
						wg.writeLine("Klingon destroyed!");
				}
				remainingEnergy -= energyCostOfCommand;

			} else {
				wg.writeLine("Insufficient energy to fire phasers!");
			}

		} else if (wg.parameter("command").equals("photon")) {
			Klingon enemy = (Klingon) wg.variable("target");
			if (torpedoes > 0) {
				int distance = enemy.distance();
				if ((rnd(4) + ((distance / 500) + 1) > 7)) {
					wg.writeLine("Torpedo missed Klingon at " + distance + " sectors...");
				} else {
					int damage = 800 + rnd(50);
					wg.writeLine("Photons hit Klingon at " + distance + " sectors with " + damage + " units");
					if (damage < enemy.getEnergy()) {
						enemy.setEnergy(enemy.getEnergy() - damage);
						wg.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
					} else {
						wg.writeLine("Klingon destroyed!");
						enemy.delete();
					}
				}
				torpedoes -= 1;

			} else {
				wg.writeLine("No more photon torpedoes!");
			}
		}
	}

	private int calculateDamage(int energyCostOfCommand, int distance) {
		int damage = energyCostOfCommand - (((energyCostOfCommand / 20) * distance / 200) + rnd(200));
		if (damage < 1)
			damage = 1;

		return damage;
	}

	// note we made generator public in order to mock it
    // it's ugly, but it's telling us something about our *design!* ;-)
	public static Random generator = new Random();
	private static int rnd(int maximum) {
		return generator.nextInt(maximum);
	}


}
