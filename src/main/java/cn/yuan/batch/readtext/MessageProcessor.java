package cn.yuan.batch.readtext;

import org.springframework.batch.item.ItemProcessor;

import cn.yuan.batch.User;

/**
 * Created by yuandg on 2016/5/4.
 */
public class MessageProcessor implements ItemProcessor<User,Message> {

    public Message process(User user) throws Exception {
        Message message=null;
        if (user.getAge()>16){
            message = new Message();
            message.setContent(user.getName()+",Please come to police station");
        }
        return message;
    }
}
