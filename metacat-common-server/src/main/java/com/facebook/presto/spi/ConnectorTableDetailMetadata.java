/*
 * Copyright 2016 Netflix, Inc.
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.facebook.presto.spi;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * This class contains any extra metadata about the table. This was created initially for the serde info that exists in
 * hive.
 *
 * Created by amajumdar on 1/15/15.
 */
public class ConnectorTableDetailMetadata extends ConnectorTableMetadata {
    private StorageInfo storageInfo;
    private Map<String, String> metadata;
    private AuditInfo auditInfo;
    public ConnectorTableDetailMetadata(SchemaTableName table,
            List<ColumnMetadata> columns, Map<String, String> metadata) {
        this( table, columns, null, null, metadata, null);
    }

    public ConnectorTableDetailMetadata(SchemaTableName table,
            List<ColumnMetadata> columns, StorageInfo storageInfo, Map<String, String> metadata) {
        this( table, columns, null, storageInfo, metadata, null);
    }

    public ConnectorTableDetailMetadata(SchemaTableName table, List<ColumnMetadata> columns
            , String owner, StorageInfo storageInfo, Map<String, String> metadata
            , AuditInfo auditInfo)
    {
        super(table, columns, Maps.newHashMap(), owner, false);
        this.storageInfo = storageInfo;
        this.metadata = metadata;
        this.auditInfo = auditInfo!=null?auditInfo:new AuditInfo();
    }

    public StorageInfo getStorageInfo() {
        return storageInfo;
    }

    public void setStorageInfo(StorageInfo storageInfo) {
        this.storageInfo = storageInfo;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }
}
