/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.hellojnicallback;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tickView;
    JniHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tickView = (TextView) findViewById(R.id.tickView);
        handler = new JniHandler();
    }

    @Override
    public void onResume() {
        super.onResume();
        //hour = minute = second = 0;
        ((TextView) findViewById(R.id.hellojniMsg)).setText(handler.stringFrom());
        handler.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.stop();
    }
}

