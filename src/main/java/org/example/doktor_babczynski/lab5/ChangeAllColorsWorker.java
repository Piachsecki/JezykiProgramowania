package org.example.doktor_babczynski.lab5;

import java.awt.*;

class ChangeAllColorsWorker {
    private final PaintPanel paintPanel;
    private final Color newColor;

    public ChangeAllColorsWorker(PaintPanel paintPanel, Color newColor) {
        this.paintPanel = paintPanel;
        this.newColor = newColor;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        paintPanel.changeAllColors(newColor);
    }


}