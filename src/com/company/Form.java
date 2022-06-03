package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Form extends JFrame {
    private JButton todayBtn;
    private JTextArea textArea;
    private JPanel root;
    String text;
    List<TimeTableLine> timeTable;
    SimpleDateFormat simplify = new SimpleDateFormat("dd.MM.yyyy");
    String dateTxt = new String();
    private JList<TimeTableLine> scheduleListView;
    //List<TimeTableLine> scheduleList =new ArrayList<>(Arrays.asList(timeTableLine));

    public Form(List<TimeTableLine> timeTable){
        this.setVisible(true);
        this.setContentPane(root);
        this.timeTable = timeTable;
        dateTxt = simplify.format(Calendar.getInstance().getTime());
        //System.out.println(simplify.format(Calendar.getInstance().getTime()));
        todayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
                textArea.replaceSelection("");
                Iterator<TimeTableLine> timeTableLineIterator = timeTable.stream().filter(new Predicate<TimeTableLine>() {
                    @Override
                    public boolean test(TimeTableLine timeTableLine) {
                        return timeTableLine.groupCode.equals("19ИТ-ПИ(б/о)ПИП-1");
                    }
                }).filter(new Predicate<TimeTableLine>() {
                    @Override
                    public boolean test(TimeTableLine timeTableLine) {
                        return timeTableLine.day.equals(dateTxt);
                    }
                }).iterator();

                textArea.selectAll();
                while(timeTableLineIterator.hasNext()) {
                    textArea.append(timeTableLineIterator.next().discipline);
                    textArea.append("\r\n");
                }


            }
        });
        scheduleListView.setCellRenderer(new ScheduleListViewRenderer());
        DefaultListModel<TimeTableLine> scheduleListModel =new DefaultListModel<>();
        scheduleListModel.addAll(timeTable);
        scheduleListView.setModel(scheduleListModel);
        /*
        yesterdayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tomorrowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
         */
        this.setSize(700,500);
    }

    public void setValue(String text) {
        this.text = text;
    }
}
