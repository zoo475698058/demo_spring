package com.example.demo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zero
 */
public class ZxcsBooks {
    public static void main(String[] args) {
        String scoreUrl = "http://zxcs.me/content/plugins/cgz_xinqing/cgz_xinqing_action.php?action=show&id=";
        String contentUrl = "http://zxcs.me/post/";
        String downloadUrl = "http://zxcs.me/download.php?id=";

        //max 12300
        List<String> scoreList = new ArrayList<>();
        for (int i = 0; i < 12300; i++) {
            HttpResponse response = HttpRequest.get(scoreUrl + i).execute();
            if (!response.isOk()) {
                continue;
            }

            String text = response.body();
            int good = Convert.toInt(text.split(",")[0], -1);
            if (good < 1000) {
                continue;
            }
            scoreList.add(good + "-" + i);
        }
        scoreList.sort((a, b) -> b.compareTo(a));
        FileUtil.writeLines(scoreList, "E:\\zxcsScore.txt", "utf-8");

        List<String> titleList = new ArrayList<>();
        for (String item : scoreList) {
            String[] str = item.split("-");
            String id = str[1];
            HttpResponse resp = HttpRequest.get(contentUrl + id).execute();
            if (!resp.isOk()) {
                continue;
            }
            String text2 = resp.body();
            String title = text2.substring(text2.indexOf("<title>") + 7, text2.indexOf("</title>"));
            titleList.add(title + ", id:" + id + ", good:" + str[0]);
        }

        String path = "E:\\zxcs.txt";
        String charset = "utf-8";
        FileUtil.writeString(downloadUrl, path, charset);
        FileUtil.writeLines(titleList, path, charset, true);
    }
}
