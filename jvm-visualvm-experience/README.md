# Исследование JVM через VisualVM #

1. 11:15:07: Executing ':JvmExperience.main()'...

Starting Gradle Daemon...
Gradle Daemon started in 10 s 60 ms
 Task :compileJava UP-TO-DATE
 Task :processResources NO-SOURCE
 Task :classes UP-TO-DATE

 Task :JvmExperience.main()
Please open 'ru.netology.JvmExperience' in VisualVm
2. 11:15:50.278665: loading io.vertx
3. 11:15:50.526487700: loaded 529 classes
4. 11:15:53.529813800: loading io.netty
5. 11:15:54.020629200: loaded 2117 classes
6. 11:15:57.021213400: loading org.springframework
7. 11:15:57.203460400: loaded 869 classes
11:16:00.218595300: now see heap
8. 11:16:00.219586100: creating 5000000 objects
9. 11:16:00.435912300: created
10. 11:16:03.438034300: creating 5000000 objects
11. 11:16:03.572666300: created
12. 11:16:06.606947700: creating 5000000 objects
13. 11:16:06.749310400: created

BUILD SUCCESSFUL in 1m 2s
2 actionable tasks: 1 executed, 1 up-to-date
11:16:10: Execution finished ':JvmExperience.main()'.

![Графики CPU, Heap, Classes, Threads](/Графики.jpg)

![Графики Metaspace](/Metaspace.jpg)

1. При запуске программы на графике Threads мы видим 14 потоков, в которых она работает,
   13 из них фоновые. 
2. Начало загрузки классов из пакета io.vertx
3. Загруженно 529 классов в облать памяти Metaspace. 
   На графике CPU видим скачок нагрузки на процессор.
   На графике Metaspace видим увеличение занимаемой памяти.
   На графике Classes видим увеличение количества загруженных классов, было 2700, стало 3474(разница 774?).
4. Начало загрузки классов из пакета io.netty.
5. Загруженно 2117 классов в область памяти Metaspace.
   На графике CPU видим скачок нагрузки на процессор.
   На графике Metaspace видим увеличение занимаемой памяти.
   На графике Classes видим увеличение количества загруженных классов, было 3474, стало 5557.
6. Начало загрузки классов из пакета org.springframework.
7. Загруженно 869 классов в область памяти Metaspace.
   На графике CPU видим скачок нагрузки на процессор.
   На графике Metaspace видим увеличение занимаемой памяти.
   На графике Classes видим увеличение количества загруженных классов, было 5557, стало 6451.
8. Начало создания 5000000
9. На графике Heap виден рост использования памяти.
10. Начало создания 5000000
11. На графике Heap виден рост использования памяти.
12. Начало создания 5000000
13. На графике Heap виден рост использования памяти.