package org.dcl;

import org.dcl.pubsub.PushPubSub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
                PushPubSub pushPubSub = new PushPubSub();
        String projectId = "fod-poc1";
        String topicId = "topic-avro-bigq";
        String msg = getmsg();
        pushPubSub.publishMessage(projectId, topicId,msg);
    }

    private static String getmsg() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Work\\Disney\\Code\\Rules-Builder-IJ-2024\\dcl-rules-crud-svc\\logs\\sample2.jsonl"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}