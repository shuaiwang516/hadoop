/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.tools;

import java.io.IOException;
import java.io.PrintStream;

import org.apache.hadoop.hdfs.HdfsConfiguration;
import org.apache.hadoop.hdfs.MiniDockerDFSCluster;
import org.apache.hadoop.tools.GetGroupsTestBase;
import org.apache.hadoop.util.Tool;
import org.junit.After;
import org.junit.Before;

/**
 * Tests for the HDFS implementation of {@link GetGroups}
 */
public class TestGetGroups extends GetGroupsTestBase {
  
  private MiniDockerDFSCluster cluster;

  @Before
  public void setUpNameNode() throws IOException {
    conf = new HdfsConfiguration();
    cluster = new MiniDockerDFSCluster.Builder(conf).numDataNodes(0).build();
  }
  
  @After
  public void tearDownNameNode() {
    if (cluster != null) {
      cluster.shutdown();
      cluster = null;
    }
  }

  @Override
  protected Tool getTool(PrintStream o) {
    return new GetGroups(conf, o);
  }

}
