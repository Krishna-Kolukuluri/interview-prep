package loadbalancer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class IpPool {
    private static final Object lock = "";
    public static Map<String, Integer> ipMap = new ConcurrentHashMap<>();
    static {
        ipMap.put("192.168.1.1", 10);
        ipMap.put("192.168.1.2", 10);
        ipMap.put("192.168.1.3", 10);
        ipMap.put("192.168.1.4", 10);
        ipMap.put("192.168.1.5", 10);
        ipMap.put("192.168.1.6", 10);
        ipMap.put("192.168.1.7", 10);
        ipMap.put("192.168.1.8", 10);
        ipMap.put("192.168.1.9", 10);
        ipMap.put("192.168.1.10", 10);
    }

    public static void addIpToPool(String ipAddress, Integer weight){
        if(!ipMap.containsKey(ipAddress)){
            synchronized (lock){
                ipMap.put(ipAddress, weight);
            }
        }
    }

    public static void removeIpFromPool(String ipAddress){
        if(ipMap.containsKey(ipAddress)){
            synchronized (lock){
                ipMap.remove(ipAddress);
            }
        }
    }

    public static void updateIpWeight(String ipAddress, Integer weight){
        if(ipMap.containsKey(ipAddress)){
            synchronized (lock){
                ipMap.put(ipAddress, weight);
            }
        }
    }
}
