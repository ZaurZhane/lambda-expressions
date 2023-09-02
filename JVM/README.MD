После запуска программы JVM дает команду подсистеме загрузщиков классов ClassLoader загрузить класс JvmComprehension
Загрузка осуществляется в несколько этапов:
1. Программа(исполняемый код) запрашивает класс JvmComprehension в загрузщике Application ClassLoader, ищет в кэше, 
если находит, то загружает, иначе поиск продолжается далее...
2. Запрашивается класс JvmComprehension в загрузщике Platform ClassLoader, ищет в кэше, если находит, то загружает,
иначе поиск продолжается далее...
3. Запрашивается класс JvmComprehension в загрузщике Bootstrap ClassLoader, если находит, то загружает,
 иначе возвращает запрос в Platform ClassLoader.
4. Если Platform ClassLoader находит, то загружает, иначе возвращает в Application ClassLoader.
5. Если Application ClassLoader находит, то загружает, иначе выбрасывается ошибка java.lang.ClassNotFoundException
6. Если класс загружен то происходит подготовка класса к выполнению: проверка, что код валиден, подготовка примитивов
в статических полях, связывание ссылок на другие классы.
7. Инициализация. Выполняются static инициализаторы и инициализаторы static полей.

Далее выполнение кода:

1. Загрузщик Application ClassLoader загружает класс JvmComprehension в область памяти Metaspace.
Происходит вызов метода main(). в области памяти Stack Memory создается фрейм main.
В Stack Memory во фрейме main создается переменная "i" со значением 1.
2. Загрузщик Bootstrap ClassLoader загружает класс Object в Metaspace.
В области памяти Heap создается объект new Object. В Stack Memory во фрейме main создается переменная "o", 
которая хранитит в себе ссылку на объект new Object.
3. Загрузщик Bootstrap ClassLoader загружает класс Integer в Metaspace. 
Во фрейме main псоздается переменная "ii" со значением 2.
4. Создаётся новый фрейм printAll в Stack Memory. В него передается ссылка на значения в heap переменной "o"  
и значения переменных i и ii.
5. В Stack Memory во фрейме printAll создается переменная "uselessVar" со значением 700.
6. Bootstrap ClassLoader загружает класс System в Metaspace. Создается новый фрейм out.println. В него передается переменные "о", "i", "ii".
Создается фрейм o.toString().  
7. В области памяти Heap создается объект "finished".
   Создается новый фрейм printIn и в него передается ссылка на объект "finished". 

