/*
 * This file is part of FastClasspathScanner.
 *
 * Author: Luke Hutchison
 *
 * Hosted at: https://github.com/lukehutch/fast-classpath-scanner
 *
 * --
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Luke Hutchison
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
 * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.lukehutch.fastclasspathscanner.matchprocessor;

import java.io.File;
import java.io.IOException;

import io.github.lukehutch.fastclasspathscanner.scanner.matchers.FileMatchProcessorAny;

/** The method to run when a file with a matching path is found on the classpath. */
@FunctionalInterface
public interface FileMatchContentsProcessorWithContext extends FileMatchProcessorAny {
    // TODO: update API so that module context can be passed in for modules, rather than a classpathElt file 
    /**
     * Process a file with a matching filename or path.
     *
     * <p>
     * You can get a fully-qualified URL for the file (even for files inside jars) by calling
     * ClasspathUtils.getClasspathResourceURL(classpathElt, relativePath)
     *
     * @param classpathElt
     *            The classpath element that contained the match (a jarfile or directory). If null, the classpath
     *            element was a module.
     * @param relativePath
     *            The path of the matching file relative to the classpath element that contained the match.
     * @param fileContents
     *            A byte array containing the file contents.
     * @throws IOException
     *             If anything goes wrong while processing the file.
     */
    public void processMatch(File classpathElt, String relativePath, byte[] fileContents) throws IOException;
}