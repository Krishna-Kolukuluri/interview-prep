package loadbalancer;

public class LoadBalance {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        loadBalance();
    }

    public static void loadBalance(){
        doGetServer(new RoundRobin());
        doGetServer(new RandomLoadBalancer());
        doGetServer(new IpHash());
        doGetServer(new WeightedRoundRobin());
        doGetServer(new WeightedRandom());
    }

    public static void doGetServer(LoadBalanceService loadBalanceService){
        doGetServer(loadBalanceService, 100);
    }

    private static void doGetServer(LoadBalanceService loadBalanceService, int queryTimes){
        for (int i = 0; i < queryTimes; i++) {
            String serverId = loadBalanceService.getServer(String.valueOf(i));
            System.out.println(String.format("[%s] index:%s,%s", loadBalanceService.getClass().getSimpleName(), i, serverId));
        }
    }
}
