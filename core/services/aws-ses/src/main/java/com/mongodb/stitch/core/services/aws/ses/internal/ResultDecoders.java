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

package com.mongodb.stitch.core.services.aws.ses.internal;

import static com.mongodb.stitch.core.internal.common.Assertions.keyPresent;

import com.mongodb.stitch.core.services.aws.ses.AwsSesSendResult;
import org.bson.BsonReader;
import org.bson.Document;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;

/**
 * @deprecated use AwsServiceClient instead.
 */
@Deprecated
class ResultDecoders {

  static final Decoder<AwsSesSendResult> sendResultDecoder = new AwsSesSendResultDecoder();

  private static final class AwsSesSendResultDecoder implements Decoder<AwsSesSendResult> {
    @Override
    public AwsSesSendResult decode(final BsonReader reader, final DecoderContext decoderContext) {
      final Document document = (new DocumentCodec()).decode(reader, decoderContext);
      keyPresent(Fields.MESSAGE_ID_FIELD, document);
      return new AwsSesSendResult(document.getString(Fields.MESSAGE_ID_FIELD));
    }

    private static final class Fields {
      static final String MESSAGE_ID_FIELD = "messageId";
    }
  }
}
