package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ScheduleListViewRenderer extends JLabel implements ListCellRenderer<TimeTableLine>{
    public ScheduleListViewRenderer() {
        setOpaque(true);
        Font oldFont = getFont();

        setFont(oldFont.deriveFont(Font.PLAIN, 14));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends TimeTableLine> list, TimeTableLine currentElem, int index, boolean isSelected, boolean cellHasFocus) {
        if(isSelected){
            setBackground(MaterialColors.ORANGE_500);
            setForeground(MaterialColors.BLUE_GRAY_600);
        }else{
            setBackground(MaterialColors.BLACK);
            setForeground(MaterialColors.GREEN_A400);
        }
        setText(currentElem.discipline);
        return this;
    }
}
