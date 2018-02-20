/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.textswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * This sample shows the use of the {@link android.widget.TextSwitcher} View with animations. A
 * {@link android.widget.TextSwitcher} is a special type of {@link android.widget.ViewSwitcher} that animates
 * the current text out and new text in when
 * {@link android.widget.TextSwitcher#setText(CharSequence)} is called.
 */
public class MainActivity extends Activity {
    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    private TextSwitcher mSwitcher2;
    private int nCounter = 0;
    private TextView tv1;
    private TextView tv4;
    private TextView tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);


        mSwitcher = findViewById(R.id.switcher);
        mSwitcher2 = findViewById(R.id.switcher2);
        mSwitcher.setFactory(mFactory);
        mSwitcher2.setFactory(mFactory);

        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        mSwitcher2.setInAnimation(in);
        mSwitcher2.setOutAnimation(out);

        Button nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCounter++;
                mSwitcher.setText(String.valueOf(mCounter));

            }
        });

        Button nextButton2 = findViewById(R.id.button2);
        nextButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nCounter++;

                mSwitcher2.setText(String.valueOf(nCounter));

            }
        });

        Button sum = findViewById(R.id.button3);
        sum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv4 = findViewById(R.id.tv4);
                tv5 = findViewById(R.id.tv5);
                int sum = nCounter+mCounter;
                tv4.setText("Result = ");
                tv5.setText(String.valueOf(sum));
            }
        });

        // Set the initial text without an animation
        mSwitcher.setCurrentText(String.valueOf(mCounter));
        mSwitcher2.setCurrentText(String.valueOf(nCounter));
    }
    private ViewFactory mFactory = new ViewFactory() {

        @Override
        public View makeView() {
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };


}
