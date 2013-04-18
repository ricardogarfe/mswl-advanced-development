ListActivities
================

En xml el id es diferente `@id/android:list` y la actividad `extends ListActivity`. El flujo sigue siendo el mismo que `Activity`.

* Lista y el Adaptador

En el adapter pasar un layout para mostrar en la lista. Android tiene elementos básicos para listas, spinners, etc.

xml:

    <ListView
        android:id="@id/android:list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" >
    </ListView>

Activity:

        listView = (ListView) findViewById(android.R.id.list);

Indexado por array que devuelve la posición del elemento pinchado.

Lista compleja
----------------

Las imágenes se considderan como Integer para obtenerlas en la aplicación. Debido a la referencia de memoria con la que se codifica.

Context de Android para acceder a los métodos de Android para Layouts, etc...

