package org.example.doktor_babczynski.lab5;

import java.awt.*;
class ColorChangeWorker {
    private PaintPanel paintPanel;

    public ColorChangeWorker(PaintPanel paintPanel, Color newColor) {
        this.paintPanel = paintPanel;
                paintPanel.setCurrentColor(newColor);
                paintPanel.repaint();
    }
}