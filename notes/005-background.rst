Android work in Background
===========================

Opciones para el trabajo en background:

* TimerTask
* Threads & Runnable
* AsyncTask
* Service - Componente a parte. No ejecutan en otro thread diferente a la actividad.

Note::

    IntentService - Servicio que se ejecuta en un thread a parte

Servicios
----------

En background, gps, nuevo mensaje, etc.

Actividad directo con el Servicio.
El Servicio a través de los eventos.

Boot Service
-------------

Aplicaciones al inicio del sistema para inicializar Servicios a través de intent-filter como **BroadcastReceiver**.

TimerTask
----------

Lanzar un thread para modificar la interfaz de usuario.

    runOnUiThreasd( new Runnablele() {...

Threads
--------

Ejecuta en un nuevo thread pero no se puede actualizar la UI:

    run()
    thread.start()

AsyncTask
----------



