/*
 * Copyright (C) 2012 The Android Open Source Project
 *
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
 */

package com.android.inputmethod.keyboard.internal;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.SparseIntArray;

import com.android.inputmethod.latin.utils.ResourceUtils;

public final class KeyVisualAttributes {
    public final Typeface mTypeface;

    public final float mLetterRatio;
    public final int mLetterSize;
    public final float mLabelRatio;
    public final int mLabelSize;
    public final float mLargeLetterRatio;
    public final float mHintLetterRatio;
    public final float mShiftedLetterHintRatio;
    public final float mHintLabelRatio;
    public final float mPreviewTextRatio;

    public final int mTextColor;
    public final int mTextInactivatedColor;
    public final int mTextShadowColor;
    public final int mFunctionalTextColor;
    public final int mHintLetterColor;
    public final int mHintLabelColor;
    public final int mShiftedLetterHintInactivatedColor;
    public final int mShiftedLetterHintActivatedColor;
    public final int mPreviewTextColor;

    public final float mHintLabelVerticalAdjustment;
    public final float mLabelOffCenterRatio;
    public final float mHintLabelOffCenterRatio;

    private static final int[] VISUAL_ATTRIBUTE_IDS = {
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTypeface,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLetterSize,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLabelSize,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLargeLetterRatio,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLetterRatio,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyShiftedLetterHintRatio,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelRatio,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyPreviewTextRatio,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTextColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTextInactivatedColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTextShadowColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_functionalTextColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLetterColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyShiftedLetterHintInactivatedColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyShiftedLetterHintActivatedColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyPreviewTextColor,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelVerticalAdjustment,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLabelOffCenterRatio,
        com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelOffCenterRatio
    };
    private static final SparseIntArray sVisualAttributeIds = new SparseIntArray();
    private static final int ATTR_DEFINED = 1;
    private static final int ATTR_NOT_FOUND = 0;
    static {
        for (final int attrId : VISUAL_ATTRIBUTE_IDS) {
            sVisualAttributeIds.put(attrId, ATTR_DEFINED);
        }
    }

    public static KeyVisualAttributes newInstance(final TypedArray keyAttr) {
        final int indexCount = keyAttr.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            final int attrId = keyAttr.getIndex(i);
            if (sVisualAttributeIds.get(attrId, ATTR_NOT_FOUND) == ATTR_NOT_FOUND) {
                continue;
            }
            return new KeyVisualAttributes(keyAttr);
        }
        return null;
    }

    private KeyVisualAttributes(final TypedArray keyAttr) {
        if (keyAttr.hasValue(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTypeface)) {
            mTypeface = Typeface.defaultFromStyle(
                    keyAttr.getInt(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTypeface, Typeface.NORMAL));
        } else {
            mTypeface = null;
        }

        mLetterRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLetterSize);
        mLetterSize = ResourceUtils.getDimensionPixelSize(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLetterSize);
        mLabelRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLabelSize);
        mLabelSize = ResourceUtils.getDimensionPixelSize(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLabelSize);
        mLargeLetterRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLargeLetterRatio);
        mHintLetterRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLetterRatio);
        mShiftedLetterHintRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyShiftedLetterHintRatio);
        mHintLabelRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelRatio);
        mPreviewTextRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyPreviewTextRatio);

        mTextColor = keyAttr.getColor(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTextColor, 0);
        mTextInactivatedColor = keyAttr.getColor(
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTextInactivatedColor, 0);
        mTextShadowColor = keyAttr.getColor(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyTextShadowColor, 0);
        mFunctionalTextColor = keyAttr.getColor(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_functionalTextColor, 0);
        mHintLetterColor = keyAttr.getColor(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLetterColor, 0);
        mHintLabelColor = keyAttr.getColor(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelColor, 0);
        mShiftedLetterHintInactivatedColor = keyAttr.getColor(
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyShiftedLetterHintInactivatedColor, 0);
        mShiftedLetterHintActivatedColor = keyAttr.getColor(
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyShiftedLetterHintActivatedColor, 0);
        mPreviewTextColor = keyAttr.getColor(com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyPreviewTextColor, 0);

        mHintLabelVerticalAdjustment = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelVerticalAdjustment, 0.0f);
        mLabelOffCenterRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyLabelOffCenterRatio, 0.0f);
        mHintLabelOffCenterRatio = ResourceUtils.getFraction(keyAttr,
                com.udmurtlyk.extrainputmethod.latin.R.styleable.Keyboard_Key_keyHintLabelOffCenterRatio, 0.0f);
    }
}
