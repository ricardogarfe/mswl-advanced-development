Google Maps v2 Android Emulator
================================

ricardo@ricardo-ubuntu:~/Descargas$ adb shell mount -o remount,api14-nexusS -t yaffs2 /dev/block/mtdblock0 /system
ricardo@ricardo-ubuntu:~/Descargas$ adb shell chmod 777 /system/app
ricardo@ricardo-ubuntu:~/Descargas$ adb push GoogleLoginService.apk /system/app/
2507 KB/s (2584466 bytes in 1.006s)
ricardo@ricardo-ubuntu:~/Descargas$ adb push GoogleServicesFramework.apk /system/app/
2617 KB/s (2221760 bytes in 0.828s)
ricardo@ricardo-ubuntu:~/Descargas$ adb push Phonesky.apk /system/app/
2606 KB/s (3996106 bytes in 1.497s)
ricardo@ricardo-ubuntu:~/Descargas$ adb install com.google.android.apps.maps-1.apk
2424 KB/s (7223877 bytes in 2.910s)
	pkg: /data/local/tmp/com.google.android.apps.maps-1.apk
ricardo@ricardo-ubuntu:~/Descargas$ adb install com.google.android.gms-2.apk
2579 KB/s (4075482 bytes in 1.543s)
	pkg: /data/local/tmp/com.google.android.gms-2.apk

