/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.data

import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.R

/* Hard-coded data for the sample. */
@Immutable
data class Favorite(
    val name: String,
    val photo: Int,
)

@Immutable
data class Subject(
    val name: String,
    val photo: Int,
)

object UserData {
    val favorites: List<Favorite> = listOf(
        Favorite("Short mantras", R.drawable.c_1_short_mantras),
        Favorite("Nature meditations", R.drawable.c_2_nature_meditations),
        Favorite("Stress and anxiety", R.drawable.c_3_stress_and_anxiety),
        Favorite("Self-massage", R.drawable.c_4_self_message),
        Favorite("Overwhelmed", R.drawable.c_5_overwhelmed),
        Favorite("Nightly wind down", R.drawable.c_6_nightly_wind_down),
    )

    val bodies: List<Subject> = listOf(
        Subject("Inversions", R.drawable.b_1_inversions),
        Subject("Quick yoga", R.drawable.b_2_quick_yoga),
        Subject("Stretching", R.drawable.b_3_stretching),
        Subject("Tabata", R.drawable.b_4_tabata),
        Subject("HIIT", R.drawable.b_5_hiit),
        Subject("Pre-natal yoga", R.drawable.b_6_pre_natal_yoga),
    )

    val minds: List<Subject> = listOf(
        Subject("Meditate", R.drawable.m_1_meditate),
        Subject("With kids", R.drawable.m_2_with_kids),
        Subject("Aromatherapy", R.drawable.m_3_aromatherapy),
        Subject("On the go", R.drawable.m_4_on_the_go),
        Subject("With pets", R.drawable.m_5_with_pets),
        Subject("High stress", R.drawable.m_6_high_stress),
    )
}
