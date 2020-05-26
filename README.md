# Dealer CUBA App

### Чтобы запустить:
* `gradle startDb createDb`
* `gradle setupTomcat deploy start`
* After the server is running, go to `localhost:8080/app`
* Press `Ctrl+C` on the command line to stop server

###### ...or open with <a href="https://doc.cuba-platform.com/studio/">CUBA Studio</a>

<a href="task.pdf">full description of task</a><br/>

#### Технические замечания
* При разработке и запуске использовал  Java 8, потестил запуск чз CUBA Studio и чз команды gradle.
* Страна по умолчанию для Пользователя — понял как необходимость расширить базовый класс КУБЫ User
и добавить в него поле "Страна", так же расширил экраны просмотра и редактирования юзеров, страну явно задать можно там.
* Создать сервис который возвращает список марок машин которые ещё не проданы и не оплачены
— сервис создан (ContractorDataComputingService), но из задания непонятно куда его стоило бы прикрутить в экраны.
* Справочник «Цвет» — аналогично, созданный справочник затем не предлагается использовать с другими сущностями.
