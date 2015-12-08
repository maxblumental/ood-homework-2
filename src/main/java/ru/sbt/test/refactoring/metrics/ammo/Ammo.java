package ru.sbt.test.refactoring.metrics.ammo;

/**
 * Created by Maxim on 12/6/2015.
 */
public class Ammo {
    private int amount;
    private int currentStripperClip = 0;
    private final int stripperClipVolume;

    public int getCurrentStripperClip() {
        return currentStripperClip;
    }

    public int getAmount() {
        return amount;
    }

    public Ammo(int amount, int stripperClipVolume) {
        this.amount = amount;
        this.stripperClipVolume = stripperClipVolume;
        this.currentStripperClip = stripperClipVolume;
    }

    public void shoot() {
        if (currentStripperClip > 0) {
            currentStripperClip--;
        }
    }

    public void reload() {
        if (amount >= stripperClipVolume) {
            currentStripperClip = stripperClipVolume;
            amount -= stripperClipVolume;
        } else if (amount > 0) {
            currentStripperClip = amount;
            amount = 0;
        }
    }
}
