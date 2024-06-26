/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.platform.modification

import com.intellij.openapi.project.Project
import org.jetbrains.annotations.TestOnly
import org.jetbrains.kotlin.analysis.api.platform.KotlinPlatformComponent
import org.jetbrains.kotlin.analysis.project.structure.KtModule

/**
 * [KotlinGlobalModificationService] is a central service for the invalidation of caches during/between tests.
 *
 * All `publish` functions must be called in a write action because the events in [KotlinModificationTopics] guarantee that the listener is called in a
 * write action.
 *
 * Implementations of this service should publish global modification events to at least the following components:
 * - [KotlinModificationTrackerFactory]
 * - [KotlinModificationTopics] via [analysisMessageBus][org.jetbrains.kotlin.analysis.api.platform.analysisMessageBus]
 */
public abstract class KotlinGlobalModificationService : KotlinPlatformComponent {
    /**
     * Publishes an event of global modification of the module state of all [KtModule]s.
     */
    @TestOnly
    public abstract fun publishGlobalModuleStateModification()

    /**
     * Publishes an event of global modification of the module state of all source [KtModule]s.
     */
    @TestOnly
    public abstract fun publishGlobalSourceModuleStateModification()

    /**
     * Publishes an event of global out-of-block modification of all source [KtModule]s. The event does not invalidate module state like
     * [publishGlobalSourceModuleStateModification], so some module structure-specific caches might persist.
     */
    @TestOnly
    public abstract fun publishGlobalSourceOutOfBlockModification()

    public companion object {
        public fun getInstance(project: Project): KotlinGlobalModificationService =
            project.getService(KotlinGlobalModificationService::class.java)
    }
}
