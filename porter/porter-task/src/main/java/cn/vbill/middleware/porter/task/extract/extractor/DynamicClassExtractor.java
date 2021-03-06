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

package cn.vbill.middleware.porter.task.extract.extractor;

import cn.vbill.middleware.porter.core.event.etl.ETLBucket;
import cn.vbill.middleware.porter.task.extract.ExtractMetadata;

/**
 * 动态类Extractor
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2018年03月09日 10:28
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2018年03月09日 10:28
 */
public class DynamicClassExtractor implements Extractor {

    @Override
    public void extract(ETLBucket bucket, ExtractMetadata metadata) {
        if (null != metadata && null != metadata.getProcessor()) {
            metadata.getProcessor().process(bucket);
        }
    }

    @Override
    public int order() {
        return 1;
    }
}
