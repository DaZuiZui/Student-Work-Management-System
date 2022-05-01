package com.example.morandi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private String imaurl ;
    private String role ;
    private String sonusername;
}
