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

package org.apache.shardingsphere.sharding.rewrite.token.pojo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import org.apache.shardingsphere.infra.binder.statement.SQLStatementContext;
import org.apache.shardingsphere.infra.database.DefaultDatabase;
import org.apache.shardingsphere.infra.metadata.database.schema.reviser.model.ShardingSphereSchema;
import org.apache.shardingsphere.infra.route.context.RouteMapper;
import org.apache.shardingsphere.infra.route.context.RouteUnit;
import org.apache.shardingsphere.sharding.rule.ShardingRule;
import org.apache.shardingsphere.sql.parser.sql.common.value.identifier.IdentifierValue;
import org.junit.Test;

public final class IndexTokenTest {
    
    @Test
    public void assertToString() {
        IndexToken indexToken = new IndexToken(0, 0,
                new IdentifierValue("t_order_index"), mock(SQLStatementContext.class, RETURNS_DEEP_STUBS), mock(ShardingRule.class), mock(ShardingSphereSchema.class));
        RouteUnit routeUnit = mock(RouteUnit.class);
        when(routeUnit.getTableMappers()).thenReturn(Collections.singletonList(new RouteMapper("t_order", "t_order_0")));
        when(routeUnit.getDataSourceMapper()).thenReturn(new RouteMapper(DefaultDatabase.LOGIC_NAME, "ds_0"));
        assertThat(indexToken.toString(routeUnit), is("t_order_index_t_order_0"));
    }
}
