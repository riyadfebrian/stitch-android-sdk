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

package com.mongodb.stitch.core.services.mongodb.remote.sync;

import com.mongodb.stitch.core.services.mongodb.remote.CompactChangeEvent;
import org.bson.BsonValue;

/**
 * CompactChangeEventListener receives change event notifications.
 * @param <DocumentT> the type of class represented by the document in the change event.
 */
public interface CompactChangeEventListener<DocumentT>
    extends BaseChangeEventListener<DocumentT, CompactChangeEvent<DocumentT>> {

  /**
   * Called when a compact change event happens for the given document id.
   *
   * @param documentId the _id of the document related to the event.
   * @param event the compact change event.
   */
  void onEvent(final BsonValue documentId, final CompactChangeEvent event);
}
