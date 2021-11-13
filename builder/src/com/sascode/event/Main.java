package com.sascode.event;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
	    Event event1 = new Event.Builder(1L)
                .withContent("This is some content!!!")
                .withTitle("Some Title")
                .withStartDate(LocalDate.of(2021, Month.DECEMBER, 23))
                .withEndDate(LocalDate.of(2022, Month.JANUARY, 12))
                .build();

        System.out.print(event1.toString());
    }
}
