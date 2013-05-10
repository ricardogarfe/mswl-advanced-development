Activities
===========

Estados más importantes, es decir donde se describe más lógica y como se activan estos eventos:

* onStart()
* onStop()

Estados iniciales:

* onCreate()
* onStart()
* onResume()

Activity Running:

* onPause(): Si existe un PopUp.
* onStop(): Desaparece de la vista.
* onDestroy() -> ShutDown.

Comunicación entre estados:

* onRestart(): de onStop() -> onRestart() -> onStart().
* onPause(): Activity Running onPause() -> onResume().

Rotar pantalla:

* onSaveInstanceState() -> onPause() -> onStop() -> onDestroy()
* oncreate() -> onStart() -> onRestoreInstance() -> onResume()

Botón atrás:

* onDestroy()

Intent
=======

Intenciones en Android, es decir: programar eventos, actividades.

    Intent intent = new Intent(this, Activity.class);
    startActivity(intent);

Parte abstracta que describe una operación a realizar. A partir de constantes definidas para las acciones a ejecutarse en el **Intent**.

Las Actions para configurar los Intent: 
* ACTION_VIEW tel:123

startActivityforResult
=======================

Comunicación entre actividades para devolver un valor en vez de lanzar una actividad con startActivity. Recoger datos para mostrar en la Actividad principal.

Override de onActivityResult() donde se define un código para saber de que actividad vuelve:

    requestCode == ACTIVITY_REQUEST


