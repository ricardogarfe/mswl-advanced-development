MSWL Advanced Development - Exercise 003
=========================================

# Introduction

Exercises 003 for Advanced Development Subject coursed in [Master on Libre Software (Master Universitario en Software libre)](http://master.libresoft.es/) at [Universidad Rey juan Carlos](http://www.urjc.es/).

# Requirements

* Android SDK.

# Description 

This weekly exercise is about android lists. You can use all the documentation in slides (Intro and Layouts). The goal of this exercise is build a list activity that show nodes information and between them (each two regular nodes) you should show a different layout with a textview (simulating advertising).

You can use the example of ListActivity as starting point.

# Resources

Use Log traces to debug your source code

```java
private final String TAG = getClass().getSimpleName(); 
Lod.d(TAG, "trace");
``` 

You can refresh your adapter when you change the data from array. Just you use your adapter with the following method:

```java
mAdapter.notifyDataSetChanged();
```

# Optional

You can try to use `GalleryView` instead of `ListView` to show results.

# Solution

`ListActivity` created using different items:

* Advertisement with text.
* ComplexItem composed by image and texts.

## Snapshots

Advertisement between every two list elements:

![Advertisement](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ListsLayout/assets/publicity-view.png)

Advertisement landscape between every two list elements:

![Advertisement landscape](https://raw.github.com/ricardogarfe/mswl-advanced-development/master/android/exercises/ListsLayout/assets/publicity-view-landscape.png)

# License

<a href="http://creativecommons.org/licenses/by/3.0/" rel="Creative Commons Attribution 3.0">![Foo](http://i.creativecommons.org/l/by/3.0/88x31.png)</a>

This work by Ricardo Gracía Fernández - ricardogarfe [at] gmail [dot] com is licensed under a [Creative Commons Attribution 3.0 Unported License](http://creativecommons.org/licenses/by/3.0/).

