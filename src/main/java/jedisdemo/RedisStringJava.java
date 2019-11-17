package jedisdemo;

/**
 * @ClassName RedisStringJava
 * @Description
 * @Author wangzhen
 * @Date 2019/11/17 下午3:28
 **/
import redis.clients.jedis.Jedis;
public class RedisStringJava {
    public static void main(String[] args) {
        //连接本地redis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //设置redis的字符串数据
        jedis.set("sunday","吃饭吃饭");
        //获取存储的数据，并输出
        System.out.println("key的数据:"+jedis.get("sunday"));
    }
}
