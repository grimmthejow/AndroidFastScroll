/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xapps.media.xmusic.fastscroll.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.xapps.media.xmusic.fastscroll.FastScroller;
import com.xapps.media.xmusic.fastscroll.FastScrollerBuilder;

public class RecyclerViewListStatefulFragment extends RecyclerViewFragment {

    @NonNull
    public static RecyclerViewListStatefulFragment newInstance() {
        return new RecyclerViewListStatefulFragment();
    }

    @NonNull
    protected FastScroller createFastScroller(@NonNull RecyclerView recyclerView) {
        return new FastScrollerBuilder(recyclerView)
                // It was later discovered that the following XML drawable doesn't work on
                // Lollipop (API 21) due to the bug that GradientDrawable didn't actually implement
                // tinting until Lollipop MR1 (API 22). So if you need to support API 21, you'll
                // need to work around it yourself.
                .setThumbDrawable(AppCompatResources.getDrawable(recyclerView.getContext(),
                        R.drawable.afs_thumb_stateful))
                .build();
    }
}
