/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.blackbox;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.junit.jupiter.api.Tag;
import org.jetbrains.kotlin.konan.test.blackbox.support.group.FirPipeline;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/CExport")
@TestDataPath("$PROJECT_ROOT")
@Tag("frontend-fir")
@FirPipeline()
public class FirCExportTestStaticGenerated extends AbstractNativeCExportStaticTest {
    @Test
    public void testAllFilesPresentInCExport() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/CExport"), Pattern.compile("^([^_](.+))$"), null, false);
    }

    @Test
    @TestMetadata("kt36639")
    public void testKt36639() throws Exception {
        runTest("native/native.tests/testData/CExport/kt36639/");
    }

    @Test
    @TestMetadata("smoke0")
    public void testSmoke0() throws Exception {
        runTest("native/native.tests/testData/CExport/smoke0/");
    }
}
