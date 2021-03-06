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

package com.mongodb.stitch.core.auth.providers.function;

import com.mongodb.stitch.core.auth.ProviderCapabilities;
import com.mongodb.stitch.core.auth.StitchCredential;

import org.bson.Document;


/**
 * The credential used for custom function log ins.
 */
public class FunctionCredential implements StitchCredential {
  private final String providerName;
  private final Document payload;

  /**
   * Constructs a Function credential for a user.
   *
   * @param payload arguments to be passed to a custom function.
   * @see <a href="https://docs.mongodb.com/stitch/auth/custom-function-auth/">Function Authentication</a>
   */
  public FunctionCredential(final Document payload) {
    this(FunctionAuthProvider.DEFAULT_NAME, payload);
  }

  private FunctionCredential(final String providerName, final Document payload) {
    this.payload = payload;
    this.providerName = providerName;
  }

  @Override
  public String getProviderName() {
    return providerName;
  }

  @Override
  public String getProviderType() {
    return FunctionAuthProvider.TYPE;
  }

  @Override
  public Document getMaterial() {
    return payload;
  }

  @Override
  public ProviderCapabilities getProviderCapabilities() {
    return new ProviderCapabilities(false);
  }
}
