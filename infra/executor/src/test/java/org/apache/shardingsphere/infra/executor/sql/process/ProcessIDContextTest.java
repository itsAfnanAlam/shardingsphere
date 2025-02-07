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

package org.apache.shardingsphere.infra.executor.sql.process;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProcessIDContextTest {
    
    @AfterEach
    void tearDown() {
        ProcessIDContext.remove();
    }
    
    @Test
    void assertIsEmpty() {
        assertTrue(ProcessIDContext.isEmpty());
        ProcessIDContext.set("123e4567e89b12d3a456426655440000");
        assertFalse(ProcessIDContext.isEmpty());
    }
    
    @Test
    void assertGet() {
        assertNull(ProcessIDContext.get());
        ProcessIDContext.set("123e4567e89b12d3a456426655440000");
        assertThat(ProcessIDContext.get(), is("123e4567e89b12d3a456426655440000"));
    }
    
    @Test
    void assertSet() {
        assertNull(ProcessIDContext.get());
        ProcessIDContext.set("123e4567e89b12d3a456426655440000");
        assertThat(ProcessIDContext.get(), is("123e4567e89b12d3a456426655440000"));
        ProcessIDContext.set("123e4567e89b12d3a456426655440001");
        assertThat(ProcessIDContext.get(), is("123e4567e89b12d3a456426655440001"));
    }
    
    @Test
    void assertRemove() {
        assertNull(ProcessIDContext.get());
        ProcessIDContext.set("123e4567e89b12d3a456426655440000");
        assertThat(ProcessIDContext.get(), is("123e4567e89b12d3a456426655440000"));
        ProcessIDContext.remove();
        assertNull(ProcessIDContext.get());
    }
}
