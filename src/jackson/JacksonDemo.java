package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonDemo {
    public static void main(String[] args) throws ParseException, IOException {
        User user=new User();
        user.setName("小乔");
        user.setEmail("xiaoqiao@163.com");
        user.setAge(8);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateFormat.parse("2017-02-15"));
        /**
         * 序列化为json序列
         */
        //将User对象序列化为json序列
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(user);
        System.out.println(json);
        //将java集合转为json序列
        List<User>users=new ArrayList<>();
        users.add(user);
        String jsonlist=mapper.writeValueAsString(users);
        System.out.println(jsonlist);

        /**
         * 将json序列反序列化
         */
        String json1="{\"name\":\"小乔\",\"age\":8,\"birthday\":1487088000000,\"email\":\"xiaoqiao@163.com\"}";
        User user1=mapper.readValue(json1,User.class);
        System.out.println(user1);
    }
}
