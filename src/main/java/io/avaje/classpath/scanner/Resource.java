/**
 * Copyright 2010-2016 Boxfuse GmbH
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.avaje.classpath.scanner;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

/**
 * A loadable resource.
 */
public interface Resource {

  /**
   * Return the location of the resource on the classpath (path and filename).
   */
  String location();

  /**
   * Return the name of this resource, without the path.
   */
  String name();

  /**
   * Return the content as InputStream.
   */
  InputStream inputStream();

  /**
   * Return the content as lines.
   */
  List<String> loadAsLines(Charset charset);

  /**
   * Return the content of this resource as a string.
   */
  String loadAsString(Charset charset);

}
