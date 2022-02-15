package loadbalancer;

import java.util.*;

public class WeightedRandom implements LoadBalanceService {
    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();

        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()) {
            String server = iterator.next();
            Integer weight = IpPool.ipMap.get(server);
            if (weight != null && weight > 0) {
                for (int i = 0; i < weight; i++) {
                    serverList.add(server);
                }
            }
        }

        Integer index = new Random().nextInt(serverList.size());
        String target = serverList.get(index);
        return target;
    }
}
