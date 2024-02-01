package com.example.openinapp
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
//TODO [IN-COMPLETED] What I could have done better,
// {
// 1. Global UI Theming         : -  Utilize ui.theme to standardize colors, shapes, spacing, fonts,
//                                   and more across the entire application.
// 2. Optimize Spacing          : -  Ensure consistent and uniform spacing between different divisions on
//                                   the dashboard screen for a polished look.
// 3. OpenInApp Icon Setup      : -  Implement the  Real OpenInApp icon  in this Assignment App 😄.
// 4. WhatsApp Integration      : -  Connect the provided WhatsApp number from the API to the contactScreen
//                                   text composable,by enabling implicit intent.
// 5. FAB Button Configuration  : -  Explore how to set up the Floating Action Button (FAB) to match the design
//                                   specified in the UI on Figma for a cohesive and visually appealing interface.
// 6. Graph X/Y axis            : -  I was not able to edit the X and Y Axis Text-font
// }


// TODO [COMPLETED] -> Setup the dependency injection entry point.
@HiltAndroidApp
class OpenInAppMain : Application()