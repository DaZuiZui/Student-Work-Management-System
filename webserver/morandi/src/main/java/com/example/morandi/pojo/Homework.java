package com.example.morandi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Homework {
    private int id;
    private String name;
    private Date time;
    private String teacher;
    private String context;
}
