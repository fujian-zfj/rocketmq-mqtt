/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.mqtt.meta.raft.rpc;

import com.alipay.sofa.jraft.rpc.RpcContext;
import com.alipay.sofa.jraft.rpc.RpcProcessor;
import org.apache.rocketmq.mqtt.common.model.consistency.WriteRequest;
import org.apache.rocketmq.mqtt.meta.raft.MqttRaftServer;

/**
 * The RPC Processor for write request
 */
public class MqttWriteRpcProcessor extends AbstractRpcProcessor implements RpcProcessor<WriteRequest> {
    private final MqttRaftServer server;

    public MqttWriteRpcProcessor(MqttRaftServer server) {
        this.server = server;
    }

    @Override
    public void handleRequest(RpcContext rpcCtx, WriteRequest request) {
        handleRequest(server, request.getGroup(), rpcCtx, request);
    }

    @Override
    public String interest() {
        return WriteRequest.class.getName();
    }
}