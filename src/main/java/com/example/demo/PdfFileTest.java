package com.example.demo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * @author Zero
 */
public class PdfFileTest {
    public static void main(String[] args) throws IOException {
        String path = "E:\\pdfTest\\1.txt";
        String outPath = "E:\\pdfTest\\res3.pdf";
        String jStr = FileUtil.readUtf8String(path);

        JSONObject object = JSONUtil.parseObj(jStr);
        String filesStr = object.getStr("obj");

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bStr = decoder.decodeBuffer(filesStr);
        FileUtil.writeBytes(bStr, outPath);
    }
}
