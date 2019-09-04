package org.sarba.mybatis.sharding.config;


import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-08-16 11:13
 * @description:
 **/
public class PowerDatabasePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        for (String s : collection) {
            Long value = preciseShardingValue.getValue().longValue();
            Long end = value / 10 % 10 ;
            if(s.endsWith(end +"")){
                return s;
            }
        }
        return null;
    }
}
