package at.kaindorf.data;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Streams<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 12. April 2023<br>
 * <b>Time:</b> 08:15<br>
 */

@AllArgsConstructor
@lombok.Data
public class Data {
    private double value;
    private LocalDate year;
}
