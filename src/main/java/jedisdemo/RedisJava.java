package jedisdemo;

/**
 * @ClassName RedisJava
 * @Description
 * @Author wangzhen
 * @Date 2019/11/17 下午3:25
 **/
import redis.clients.jedis.Jedis;
public class RedisJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("服务正在运行"+jedis.ping());
    }
}
