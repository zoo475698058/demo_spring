package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Zero
 */
@Component
public class Constants {
    public static String JKS_PWD;

    @Value("${jks.pwd}")
    public void setJksPwd(String jksPwd) {
        JKS_PWD = jksPwd;
    }

}
