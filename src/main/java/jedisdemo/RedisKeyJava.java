package jedisdemo;

/**
 * @ClassName RedisKeyJava
 * @Description
 * @Author wangzhen
 * @Date 2019/11/17 下午3:45
 **/
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class RedisKeyJava{
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //获取并输出
        Set<String> redisKeys = jedis.keys("*");
        Iterator<String> iterator = redisKeys.iterator();
        while (iterator.hasNext()){
            String it = iterator.next();
            System.out.println("key:"+it);
        }

    }
}
