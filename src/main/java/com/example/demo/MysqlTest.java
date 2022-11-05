package com.example.demo;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

/**
 * @author Zero
 */
public class MysqlTest {
    public static void main(String[] args) {
        try {
            Entity entity = Db.use().get("language", "name", "English");
            System.out.println(entity.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
