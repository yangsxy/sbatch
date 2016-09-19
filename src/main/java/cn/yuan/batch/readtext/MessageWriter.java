package cn.yuan.batch.readtext;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by yuandg on 2016/5/4.
 */
public class MessageWriter implements ItemWriter<Message> {
    @Override
    public void write(List<? extends Message> list) throws Exception {
        System.out.println("Result:");
        for (Message message : list) {
            System.out.println(message.getContent());
        }
    }
}
