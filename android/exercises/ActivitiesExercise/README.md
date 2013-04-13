MSWL Advanced Development - Exercise 002
=========================================

# Introduction

Exercises 002 for Advanced Development Subject coursed in [Master on Libre Software (Master Universitario en Software libre)](http://master.libresoft.es/) at [Universidad Rey juan Carlos](http://www.urjc.es/).

# Requirements

* Android SDK.

# Description 

The second exercise is about activities. You can use all the documentation in slides and source code. The goal of this exercise is understand the send of parameters between activities.

We make in class an exercise that it has a main activity with some buttons. One of them button generates a transition to `activity2` with `startAcitivityForResult` call and send the title that have to appear in `activity2`. When user push back key from `activity2` we send a **param (20)** as return and show it in the main activity using a **Toast**.

The exercise then consist in make the same with _other activity (called activity3)_. As this way, the main activity must show a Toast saying `"Come back Activity2"` or `"Come back Activity3"`.

## Resources

*  [Activities and send parameters](https://github.com/rocapal/android-examples/tree/master/02.1-Activities)

*  [Life Cycle of Acitivities](https://github.com/rocapal/android-examples/tree/master/02.2-ActivitiesLifeCycle)

## Optional

* You can try to add the source code to send an intent to open an URL or open a call phone.

# Solution

* Activities Exercise using `Toast` to return values from activities, open an `URL` and open a `call phone`.

## Snapshots

Main Activity:

[Main Activity](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ActivitiesExercise/assets/main-activity.png)

Stack Activity:

[Stack Activity](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ActivitiesExercise/assets/stack-activity.png)

Return from Activity 2:

[Return from Activity 2](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ActivitiesExercise/assets/activity-2-toast.png)

Return from Activity 3:

[Return from Activity 3](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ActivitiesExercise/assets/activity-3-toast.png)

Open an `URL`:

[open an `URL`](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ActivitiesExercise/assets/activity-browser.png)

`call phone`:

[`call phone`](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ActivitiesExercise/assets/activity-call.png)

# License

<a href="http://creativecommons.org/licenses/by/3.0/" rel="Creative Commons Attribution 3.0">![Foo](http://i.creativecommons.org/l/by/3.0/88x31.png)</a>

This work by Ricardo Gracía Fernández - ricardogarfe [at] gmail [dot] com is licensed under a [Creative Commons Attribution 3.0 Unported License](http://creativecommons.org/licenses/by/3.0/).

