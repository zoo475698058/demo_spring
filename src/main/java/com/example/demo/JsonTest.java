package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Map;

public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonObjectStr = "{\"brand\":\"ford\", \"doors\":5}";
        Map<String, Object> map = objectMapper.readValue(jsonObjectStr, new TypeReference<Map<String, Object>>() {});
        System.out.println(objectMapper.writeValueAsString(map));

        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5, \"owners\" : [\"John\", \"Jack\", \"Jill\"], \"nestedObject\" : { \"field\" : \"value\" } }";
        JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);
        // 或者
        jsonNode = objectMapper.readTree(carJson);

        // 取JSON属性值
        JsonNode brandNode = jsonNode.get("brand");
        String brand = brandNode.asText();
        System.out.println("brand = " + brand);
        JsonNode doorsNode = jsonNode.get("doors");
        int doors = doorsNode.asInt();
        System.out.println("doors = " + doors);

        System.out.println("null--- " + jsonNode.hasNonNull("abc"));

        String a =  "{\"head\":{\"txTime\":\"20220808073028\",\"retCode\":\"60000000\",\"retMessage\":\"OK\"},\"person\":{\"userId\":\"E5B6C9D2B5EE2D19E05311016B0AF783\",\"personName\":\"象六\",\"identTypeCode\":\"0\",\"identNo\":\"430382199412110006\",\"email\":\"\",\"mobilePhone\":\"15197163914\",\"authenticationMode\":\"公安部\",\"authenticationTime\":\"20220808073028\",\"usedEmailLogin\":1,\"usedMobileLogin\":1,\"isOpenSM2\":0},\"notSendPwd\":0}";
        JsonNode aNode = objectMapper.readTree(a);
        System.out.println("id--- " + aNode.get("userId"));
        System.out.println("id--- " + aNode.get("person").get("userId"));
        System.out.println("id--- " + aNode.hasNonNull("person"));
        System.out.println("id--- " + aNode.hasNonNull("userId"));
        System.out.println("userId--- " + objectMapper.createObjectNode().put("userId", "123123").toString());

        // 取JSON数组
        JsonNode jsonArray = jsonNode.get("owners");
        JsonNode jsonArrayNode = jsonArray.get(0);
        String john = jsonArrayNode.asText();
        System.out.println("john = " + john);

        // 取JSON内嵌对象
        JsonNode childNode = jsonNode.get("nestedObject");
        JsonNode childField = childNode.get("field");
        String field = childField.asText();
        System.out.println("field = " + field);

        // 创建ObjectNode
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("brand", "Mercedes");
        objectNode.put("doors", 5);
        ObjectNode nestNode = objectMapper.createObjectNode();
        nestNode.put("field", "value");
        objectNode.set("nestedObject", nestNode);
        System.out.println(objectMapper.writeValueAsString(objectNode));
    }
}
