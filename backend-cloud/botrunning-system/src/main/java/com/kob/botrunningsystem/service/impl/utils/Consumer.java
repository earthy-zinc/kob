package com.kob.botrunningsystem.service.impl.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.function.Supplier;

import org.joor.Reflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class Consumer extends Thread {
    @Value("${kob-backend.receive-bot-move-url}")
    private String receiveBotMoveUrl;
    private static RestTemplate restTemplate;
    private Bot bot;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        Consumer.restTemplate = restTemplate;
    }

    public void startTimeout(long timeout, Bot bot) {
        this.bot = bot;
        this.start();
        try {
            this.join(timeout); // 最多等待 timeout 秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.interrupt(); // 中断线程
        }
    }

    /**
     * 在 code 中的 Bot 类名后面添加 uid
     */
    private String addUid(String code, String uid) {
        int k = code.indexOf(" implements java.util.function.Supplier<Integer>");
        return code.substring(0, k) + uid + code.substring(k);
    }

    @Override
    public void run() {
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString().substring(0, 8);
        Supplier<Integer> botInterface;
        try {
            botInterface =
                    Reflect.compile("com.kob.botrunningsystem.utils.Bot" + uid, addUid(bot.getBotCode(), uid)).create().get();
        }catch (NullPointerException e){
            // TODO  暂时性缓解无法利用反射创建出来Bot对象，之后要修改！
            e.printStackTrace();
            botInterface = new com.kob.botrunningsystem.utils.Bot();
        }
        File file = new File("input.txt");
        try (PrintWriter fileOut = new PrintWriter(file)) {
            fileOut.println(bot.getInput());
            fileOut.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Integer direction = botInterface.get();
        System.out.println("Move -> " + bot.getUserId() + " _> " + direction);

        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("userId", bot.getUserId().toString());
        data.add("direction", direction.toString());
        restTemplate.postForObject(receiveBotMoveUrl, data, String.class);
    }
}
