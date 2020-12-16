package com.eryi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String number;

    @Override
    public String toString(){
        return "id:"+id+"\t"+"number:"+number;
    }
}
