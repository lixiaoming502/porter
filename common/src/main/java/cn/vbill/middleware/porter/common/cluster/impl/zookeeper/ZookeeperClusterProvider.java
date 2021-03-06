/*
 * Copyright ©2018 vbill.cn.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package cn.vbill.middleware.porter.common.cluster.impl.zookeeper;

import cn.vbill.middleware.porter.common.client.impl.ZookeeperClient;
import cn.vbill.middleware.porter.common.cluster.impl.AbstractClusterProvider;
import cn.vbill.middleware.porter.common.config.ClusterConfig;
import cn.vbill.middleware.porter.common.config.source.ZookeeperConfig;
import cn.vbill.middleware.porter.common.dic.ClusterPlugin;
import cn.vbill.middleware.porter.common.exception.ConfigParseException;
import cn.vbill.middleware.porter.common.client.Client;
import cn.vbill.middleware.porter.common.cluster.ClusterMonitor;

/**
 * zookeeper集群提供者
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年12月14日 18:15
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年12月14日 18:15
 */
public class ZookeeperClusterProvider extends AbstractClusterProvider {
    @Override
    protected ClusterPlugin getMatchType() {
        return ClusterPlugin.ZOOKEEPER;
    }

    @Override
    protected ClusterMonitor newMonitor() {
        return new ZookeeperClusterMonitor();
    }

    @Override
    protected Class getClusterListenerClass() {
        return ZookeeperClusterListener.class;
    }

    @Override
    protected Client initClient(ClusterConfig clusterConfig) throws ConfigParseException {
        ZookeeperConfig config = new ZookeeperConfig(clusterConfig.getClient()).stuff();
        return new ZookeeperClient(config);
    }
}