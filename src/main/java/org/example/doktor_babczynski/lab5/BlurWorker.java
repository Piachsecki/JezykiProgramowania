package org.example.doktor_babczynski.lab5;

import javax.swing.*;

class BlurWorker  {
    private final PaintPanel paintPanel;

    public BlurWorker(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        paintPanel.applyBlur();
    }

}