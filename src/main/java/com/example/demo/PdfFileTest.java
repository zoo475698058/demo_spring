package com.example.demo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.util.Base64Utils;

/**
 * @author Zero
 */
public class PdfFileTest {
    public static void main(String[] args) {
        String path = "E:\\pdfTest\\1.txt";
        String outPath = "E:\\pdfTest\\res3.pdf";
        String jStr = FileUtil.readUtf8String(path);

        JSONObject object = JSONUtil.parseObj(jStr);
        String filesStr = object.getStr("obj");

        byte[] bStr = Base64Utils.decodeFromString(filesStr);
        FileUtil.writeBytes(bStr, outPath);
    }
}
