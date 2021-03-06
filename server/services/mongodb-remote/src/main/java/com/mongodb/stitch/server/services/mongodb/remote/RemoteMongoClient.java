/*
 * Copyright 2018-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.stitch.server.services.mongodb.remote;

import com.mongodb.stitch.core.services.mongodb.remote.sync.internal.CoreRemoteClientFactory;
import com.mongodb.stitch.server.core.services.internal.NamedServiceClientFactory;
import com.mongodb.stitch.server.services.mongodb.remote.internal.RemoteMongoClientImpl;

/**
 * The remote MongoClient used for working with data in MongoDB remotely via Stitch.
 */
public interface RemoteMongoClient {

  /**
   * Gets a {@link RemoteMongoDatabase} instance for the given database name.
   *
   * @param databaseName the name of the database to retrieve
   * @return a {@code RemoteMongoDatabase} representing the specified database
   */
  RemoteMongoDatabase getDatabase(final String databaseName);

  NamedServiceClientFactory<RemoteMongoClient> factory =
      (service, appInfo) -> new RemoteMongoClientImpl(
        CoreRemoteClientFactory.getClient(
            service,
            appInfo,
            null));
}
