package com.gmall.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestJwt {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("memberId","1");
        map.put("nickname","zhangsan");
        String ip = "127.0.0.1";
        String time = new SimpleDateFormat("yyyyMMdd HHmm").format(new Date());
        String encode = JwtUtil.encode("2019gmall0105", map, ip + time);

        Map<String, Object> decode = JwtUtil.decode(encode, "2019gmall0105", ip + time);

        System.err.println(encode);
        System.out.println(decode.toString());

    }
}
