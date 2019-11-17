package jedisdemo;

/**
 * @ClassName RedisPoolJava
 * @Description
 * @Author wangzhen
 * @Date 2019/11/17 下午3:59
 **/
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolJava{
    //服务器ip地址
    private static String ADDR = "localhost";
    //端口
    private static int PORT = 6379;
    //密码
    private static String AUTH = "123456";
    //连接示例最大连接数
    private static int MAX_ACTIVE = 1024;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException
    private static int MAX_WAIT = 10000;
    //连接超时的时间　
    private static int TIMEOUT = 10000;
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;
    //数据库模式是16个数据库0~15
    public static final int DEFAULT_DATABASE = 0;

    //初始化redis连接池
    static{
        try{
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(MAX_ACTIVE);
            jedisPoolConfig.setMaxIdle(MAX_IDLE);
            jedisPoolConfig.setMaxWaitMillis(MAX_WAIT);
            jedisPoolConfig.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(jedisPoolConfig,"localhost");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取redis示例
    public synchronized static Jedis getJedis(){
        try{
            if(jedisPool != null){
                Jedis resource = jedisPool.getResource();
                System.out.println("redis服务正在运行"+resource.ping());
                return resource;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //释放资源
    public static void returnResource(final Jedis jedis){
        if(jedis != null){
            jedisPool.close();
        }
    }

    public static void main(String[] args) {
        Jedis jedis = RedisPoolJava.getJedis();
        if(jedis.setnx("sunday","haha") == 1){
            System.out.println("获得锁1");
        }
        if (jedis.setnx("medei","haha") == 1){
            System.out.println("获得锁2");
            System.out.println("值:"+jedis.get("medei"));
        }
    }
}
