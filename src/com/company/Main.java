package com.company;

import com.formdev.flatlaf.FlatDarkLaf;
import com.google.gson.Gson;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        FlatDarkLaf.install();
        JsonExtractor extractor = new JsonExtractor(new Gson());
        List<TimeTableLine> currentTimeTable = extractor.getTimeTable("src/timetable1.json");
        Form form = new Form(currentTimeTable);
        List<TimeTableLine> filteredList  = new ArrayList<>();
        ListIterator<TimeTableLine> timeTableLineListIterator = filteredList.listIterator();
        //System.out.println(currentTimeTable.get(1).day);
        Iterator<TimeTableLine> timeTableLineIterator = currentTimeTable.stream().filter(new Predicate<TimeTableLine>() {
                    @Override
                    public boolean test(TimeTableLine timeTableLine) {
                        return timeTableLine.groupCode.contains("19ИТ-ПИ(б/о)ПИП-1");
                    }
                }).filter(new Predicate<TimeTableLine>() {
                    @Override
                    public boolean test(TimeTableLine timeTableLine) {
                        return timeTableLine.day.equals("08.04.2022");
                    }
                }).sorted(new Comparator<TimeTableLine>() {
                    @Override
                    public int compare(TimeTableLine o1, TimeTableLine o2) {
                        return o1.timeStart.compareTo(o2.timeStart);
                    }
                })
                .iterator();
        //System.out.println(newList.get(1).teacherFIO);

        //.out.println(extractor.getGroups("src/groups.json").get(1).name);

        //currentTimeTable.stream().filter(element -> element.contains("19ИТ-ПИ(б/о)ПИП-1"));
        Date d = new Date();
        System.out.println(d);

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("four 1 5 88 ");
        strings.add("five-six");

        /*
        strings.stream()
                .filter(element -> !element.contains("-"))
                .map(s -> "null")
                .forEach(System.out::println);
        System.out.println(strings);
         */
    }
}
