MSWL Advanced Development
==========================

# Introduction

Notes and Exercises for Advanced Development Subject coursed in [Master on Libre Software (Master Universitario en Software libre)](http://master.libresoft.es/) at [Universidad Rey juan Carlos](http://www.urjc.es/).

# Requirements

* LaTeX: to compile source code documentation files.
* Android SDK.

# Android Application

**TBC**

# Proof of concept

Android proof of concept applications in Android directory such as `HelloWorld`:

```shell
mswl-advanced-development
├── android
```

**TBC**

# Notes

Generate pdf using LaTeX:

```shell
$ pdflatex [name-of-latex-file.tex]
```

**TBC**

# Exercises

Exercises placed in `exercises` directory:

```shell
mswl-advanced-development
├── android
│   ├── exercises
```

## Exercise 001

### Description 

The first exercise is about android layouts. You can use all the documentation in slides (Intro and Layouts). The goal of this exercise is build an interface similar to social network profile. 
You can use this layout as template.

![Android Layouts](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/exercise-001/assets/exercise-001-layout.png)

**Remember:**

* You should try to use the minimum number of layouts and all the text must be referenced in string.xml file. 
* Use Ctrl + F11 to change the view of emulator

### Solution

* Exercise 001 solution using ScrollView:

```shell
mswl-advanced-development
└── android/
    └── exercises
       └── exercise-001
```

* See [README](https://github.com/ricardogarfe/mswl-advanced-development/blob/master/android/exercises/exercise-001/README.md) file for solution.

## Exercise 002

### Description 

The second exercise is about activities. You can use all the documentation in slides and source code. The goal of this exercise is understand the send of parameters between activities.

We make in class an exercise that it has a main activity with some buttons. One of them button generates a transition to `activity2` with `startAcitivityForResult` call and send the title that have to appear in `activity2`. When user push back key from `activity2` we send a **param (20)** as return and show it in the main activity using a **Toast**.

The exercise then consist in make the same with _other activity (called activity3)_. As this way, the main activity must show a Toast saying `"Come back Activity2"` or `"Come back Activity3"`.

### Resources

*  [Activities and send parameters](https://github.com/rocapal/android-examples/tree/master/02.1-Activities)

*  [Life Cycle of Acitivities](https://github.com/rocapal/android-examples/tree/master/02.2-ActivitiesLifeCycle)

### Solution

* Exercise 002 **ActivitiesExercise**:

```shell
mswl-advanced-development
└── android/
    └── exercises
       └── ActivitiesExercise
```

* See [README](https://github.com/ricardogarfe/mswl-advanced-development/blob/master/android/exercises/ActivitiesExercise/README.md) file for solution.


# License

<a href="http://creativecommons.org/licenses/by/3.0/" rel="Creative Commons Attribution 3.0">![Foo](http://i.creativecommons.org/l/by/3.0/88x31.png)</a>

This work by Ricardo Gracía Fernández - ricardogarfe [at] gmail [dot] com is licensed under a [Creative Commons Attribution 3.0 Unported License](http://creativecommons.org/licenses/by/3.0/).

