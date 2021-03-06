/*
 * Copyright (C) 2014, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.udmurtlyk.extrainputmethod.latin;

import android.content.Context;
import android.view.KeyEvent;

final class SpecialKeyDetector {
    /**
     * Special physical key detector
     * @param context a context of this detector.
     */
    public SpecialKeyDetector(final Context context) {
    }

    /**
     * Record a down key event.
     * @param keyEvent a down key event.
     */
    public void onKeyDown(final KeyEvent keyEvent) {
    }

    /**
     * Record an up key event.
     * @param keyEvent an up key event.
     */
    public void onKeyUp(final KeyEvent keyEvent) {
    }
}
