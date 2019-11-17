package jedisdemo;

/**
 * @ClassName RedisListJava
 * @Description
 * @Author wangzhen
 * @Date 2019/11/17 下午3:37
 **/
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava{
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.lpush("site-list","java");
        jedis.lpush("site-list","python");
        jedis.lpush("site-list","sql");
        //读取数据
        List<String> redislist = jedis.lrange("site-list",0,2);
        for (int i = 0; i < redislist.size(); i++) {
            System.out.println("读取到的数据"+i+",值："+redislist.get(i));
        }
    }
}
