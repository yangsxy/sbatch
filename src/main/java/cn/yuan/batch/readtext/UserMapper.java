package cn.yuan.batch.readtext;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import cn.yuan.batch.User;

/**
 * Created by yuandg on 2016/5/4.
 */
public class UserMapper implements FieldSetMapper<User> {
	
    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        User user = new User();
        user.setName(fieldSet.readString(0));
        user.setAge(fieldSet.readInt(1));
        return user;
    }
}
