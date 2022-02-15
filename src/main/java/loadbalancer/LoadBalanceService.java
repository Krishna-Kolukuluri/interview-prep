package loadbalancer;

public interface LoadBalanceService {
    String getServer(String clientIp);
}
