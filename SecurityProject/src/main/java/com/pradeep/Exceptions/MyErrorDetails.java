package com.pradeep.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MyErrorDetails {

    private LocalDateTime lcdt;

    private String message;

    private String descroption;



}
